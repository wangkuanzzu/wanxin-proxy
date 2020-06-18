package com.qb.ad.base.service.impl;

import com.qb.ad.base.service.EccSignService;
import com.zzrb.ecc.AnboECCKey;
import com.zzrb.util.ECCSignUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EccSignServiceImpl implements EccSignService {
    @Override
    public String generateKeypair() throws Exception {
        return AnboECCKey.generateKeyPair();
    }

    @Override
    public String sign(String privateKey, Map<String, String> data) throws Exception {
        return ECCSignUtil.sign(privateKey,data);
    }

    @Override
    public Boolean verify(String publicKey, Map<String, String> data, String sign) throws Exception {
        return ECCSignUtil.verify(publicKey,data,sign);
    }
}
