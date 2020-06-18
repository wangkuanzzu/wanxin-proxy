package com.qb.ad.base.service;

import com.qb.ad.base.rest.entity.AdGetParam;

import java.util.Map;

public interface WanxinService {

    /**
     * 获取广告
     * @return
     */

    Map<String, Object> getAdForWanxin(AdGetParam adGetParam) throws Exception;

}
