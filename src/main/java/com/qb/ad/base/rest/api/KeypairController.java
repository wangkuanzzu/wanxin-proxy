package com.qb.ad.base.rest.api;


import com.qb.ad.base.service.EccSignService;
import com.qb.ad.common.constant.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 密钥对生成
 * @author: wk
 * @date: 20200617
 */
//@RestController
//@Api(value = "生成密钥对",tags = {"生成密钥对"})
public class KeypairController {


    @Resource
    private EccSignService eccSignService;

    @ResponseBody
    @GetMapping("/keypair/create")
    @ApiOperation(value = "生成密钥对",notes = "生成密钥对")
    public ApiResult<Map<String, String>> generateKeypair() throws Exception {
        String keypair = eccSignService.generateKeypair();
        return ApiResult.success(keypair);
    }



}
