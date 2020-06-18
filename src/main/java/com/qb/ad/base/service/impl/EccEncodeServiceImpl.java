package com.qb.ad.base.service.impl;

import com.qb.ad.base.service.EccEncodeService;
import com.zzrb.util.ECCCryptUtil;
import org.springframework.stereotype.Service;

@Service
public class EccEncodeServiceImpl implements EccEncodeService {

    @Override
    public String encode(String publicKey, String data) throws Exception {
        return ECCCryptUtil.encrypt(data,publicKey);
    }

    @Override
    public String decode(String privateKey, String dataEncode) throws Exception {
        return ECCCryptUtil.decrypt(dataEncode,privateKey);
    }
}
