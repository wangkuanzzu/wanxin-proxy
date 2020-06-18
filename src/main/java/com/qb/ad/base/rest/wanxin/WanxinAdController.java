package com.qb.ad.base.rest.wanxin;


import com.qb.ad.base.rest.entity.AdGetParam;
import com.qb.ad.base.service.WanxinService;
import com.qb.ad.common.constant.ApiResult;
import com.qb.ad.common.util.MyLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 代理万信接入安泊平台
 * @author: wk
 * @date: 20200618
 */
@RestController
@Api(value = "代理万信接入安泊平台接口",tags = {"代理万信接入安泊平台接口"})
public class WanxinAdController {

    private static final MyLog logger = MyLog.getLog(WanxinAdController.class);

    @Resource
    private WanxinService wanxinService;

    @ResponseBody
    @PostMapping("/wanxin/ad")
    @ApiOperation(value = "获取广告",notes = "获取广告")
    public ApiResult<Map<String, String>> getWanxinAd(@Validated @RequestBody AdGetParam adGetParam) throws Exception {
        logger.info("万信获取广告参数：adGetParam:{}",adGetParam.getAdPosId());
        Map<String , Object> retNMap = wanxinService.getAdForWanxin(adGetParam);
        return ApiResult.success(retNMap);
    }

//    @ResponseBody
//    @PostMapping("/wanxin/ad/redirect")
//    @ApiOperation(value = "点击广告",notes = "点击广告")
//    public ApiResult<Map<String, String>> redirectWanxinAd(@Validated @RequestBody RedirectAdParam redirectAdParam) throws Exception {
//        return ApiResult.success();
//    }

}
