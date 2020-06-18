package com.qb.ad.base.rest.api;


import com.qb.ad.base.rest.entity.DecodePostParam;
import com.qb.ad.base.rest.entity.EncodePostParam;
import com.qb.ad.base.rest.entity.SignPostParam;
import com.qb.ad.base.rest.entity.VerifyPostParam;
import com.qb.ad.base.service.EccEncodeService;
import com.qb.ad.base.service.EccSignService;
import com.qb.ad.common.constant.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 加密解密服务
 * @author: wk
 * @date: 20200617
 */
//@RestController
//@Api(value = "加密解密接口",tags = {"解密解密接口"})
public class CryptController {


    @Resource
    private EccEncodeService eccEncodeService;

    @ResponseBody
    @PostMapping("/keypair/encode")
    @ApiOperation(value = "加密",notes = "加密")
    public ApiResult<Map<String, String>> encode(@Validated @RequestBody EncodePostParam encodePostParam) throws Exception {
        String encodeData = eccEncodeService.encode(encodePostParam.getPublicKey(), encodePostParam.getData());
        return ApiResult.success(encodeData);
    }

    @ResponseBody
    @PostMapping("/keypair/decode")
    @ApiOperation(value = "解密",notes = "解密")
    public ApiResult<Map<String, String>> decode(@Validated @RequestBody DecodePostParam decodePostParam) throws Exception {
        String data = eccEncodeService.decode(decodePostParam.getPrivateKey(),decodePostParam.getData());
        return ApiResult.success(data);
    }



}
