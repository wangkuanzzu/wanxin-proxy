package com.qb.ad.base.rest.api;


import com.qb.ad.base.rest.entity.SignPostParam;
import com.qb.ad.base.rest.entity.VerifyPostParam;
import com.qb.ad.base.service.EccSignService;
import com.qb.ad.common.constant.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 签名验签
 * @author: wk
 * @date: 20200617
 */
//@RestController
//@Api(value = "签名验签接口",tags = {"签名验签接口"})
public class SignController {


    @Resource
    private EccSignService eccSignService;

    @ResponseBody
    @PostMapping("/keypair/sign")
    @ApiOperation(value = "签名",notes = "签名")
    public ApiResult<Map<String, String>> sign(@Validated @RequestBody SignPostParam signPostParam) throws Exception {
        String sign = eccSignService.sign(signPostParam.getPrivateKey(), signPostParam.getData());
        return ApiResult.success(sign);
    }

    @ResponseBody
    @PostMapping("/keypair/verify")
    @ApiOperation(value = "验签",notes = "验签")
    public ApiResult<Map<String, String>> verify(@Validated @RequestBody VerifyPostParam verifyPostParam) throws Exception {
        Boolean check = eccSignService.verify(verifyPostParam.getPublicKey(),verifyPostParam.getData(),verifyPostParam.getSign());
        return ApiResult.success(check);
    }


}
