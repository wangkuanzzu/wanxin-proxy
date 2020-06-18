package com.qb.ad.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qb.ad.base.rest.config.WanxinInfoProperties;
import com.qb.ad.base.rest.config.WanxinKeypairProperties;
import com.qb.ad.base.rest.entity.AdGetParam;
import com.qb.ad.base.service.WanxinService;
import com.qb.ad.common.constant.AppException;
import com.qb.ad.common.enumm.ApiResultCodeEnum;
import com.qb.ad.common.util.JsonUtil;
import com.qb.ad.common.util.MyLog;
import com.zzrb.util.ECCSignUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class WanxinServiceImpl implements WanxinService {

    private static  final MyLog logger =MyLog.getLog(WanxinServiceImpl.class);

    @Autowired
    private WanxinInfoProperties wanxinInfoProperties;

    @Autowired
    private WanxinKeypairProperties wanxinKeypairProperties;

    @Value("${anbo.ad.url}")
    private String anboAdUrl;

    @Value("${anbo.ad.redirect.url}")
    private String anboAdRedirectUrl;


    @Override
    public Map<String, Object> getAdForWanxin(AdGetParam adGetParam) throws Exception {
        // 根据抽象广告位获取广告
        Map<String, String> map = new HashMap<>();
        map.put("adPosId", adGetParam.getAdPosId());
        map.put("parkId", wanxinInfoProperties.getPark());
        map.put("partnerId", wanxinInfoProperties.getPartner());

        String sign = ECCSignUtil.sign(wanxinKeypairProperties.getPri(), map);
        logger.info("万信获取广告sign:" + sign);
        map.put("sign", sign);

        String json = JSONObject.toJSONString(map);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestBuilder requestBuilder = RequestBuilder.get(anboAdUrl);
        requestBuilder.addHeader("Content-type", "application/json");
        StringEntity jsonBody = new StringEntity(json, ContentType.APPLICATION_JSON);
        requestBuilder.setEntity(jsonBody);
        HttpUriRequest httpRequest = requestBuilder.build();
        CloseableHttpResponse resp = httpClient.execute(httpRequest);
        String result = EntityUtils.toString(resp.getEntity(), "utf-8");
        logger.info("万信获取广告result:" + result);

        // 结果中拿到adId 和 content 拼接跳转地址
        Map<String, Object> retMap = new HashMap<>();
        JSONObject jsonObject = JsonUtil.getJSONObjectFromJson(result);
        if(!jsonObject.get("status").toString().equals("20000000")){
            throw new AppException(jsonObject.getString("status"),jsonObject.getString("message"));
        }
        String content = jsonObject.getJSONObject("result").get("content").toString();
        String adId = jsonObject.getJSONObject("result").get("adId").toString();
        map.clear();
        map.put("adId", adId);
        map.put("parkId", wanxinInfoProperties.getPark());
        map.put("partnerId", wanxinInfoProperties.getPartner());
        String signRedirect = ECCSignUtil.sign(wanxinKeypairProperties.getPri(), map);
        String redirectUrl =  String.format("?sign=%s&adId=%s&partnerId=%s&parkId=%s",signRedirect,adId,wanxinInfoProperties.getPartner(),wanxinInfoProperties.getPark());
        redirectUrl = anboAdRedirectUrl + redirectUrl;
        logger.info("万信点击广告redirectUrl:" + redirectUrl);
        // 返回数据 map
        //  广告内容：图片或文字   广告跳转地址
        retMap.put("content", content);
        retMap.put("redirectUrl", redirectUrl);
        return retMap;
    }
}
