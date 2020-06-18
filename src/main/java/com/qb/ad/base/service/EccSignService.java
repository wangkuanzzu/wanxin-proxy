package com.qb.ad.base.service;

import java.util.Map;

public interface EccSignService {
    /**
     * 创建密钥对
     * @return
     */
    String generateKeypair() throws Exception;

    /**
     * 签名
     * @param privateKey
     * @param data
     * @return
     */
    String sign(String privateKey, Map<String, String> data) throws Exception;

    /**
     * 验签
     * @param publicKey
     * @param data
     * @param sign
     * @return
     */
    Boolean verify(String publicKey, Map<String, String> data, String sign) throws Exception;

}
