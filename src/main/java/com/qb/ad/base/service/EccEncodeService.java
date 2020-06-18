package com.qb.ad.base.service;

import org.springframework.stereotype.Service;

public interface EccEncodeService {
    /**
     * 公钥加密字符串 返回加密后字符串
     * @param publicKey
     * @param data
     * @return
     */
    String encode(String publicKey, String data) throws Exception;

    /**
     * 私钥解密字符串 返回加密前字符串
     * @param privateKey
     * @param dataEncode
     * @return
     */
    String decode(String privateKey, String dataEncode) throws Exception;
}
