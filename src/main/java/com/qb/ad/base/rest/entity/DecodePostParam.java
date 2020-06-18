package com.qb.ad.base.rest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 *
 */
@ApiModel(description = "解密服务参数")
public class DecodePostParam {

    @ApiModelProperty(value="私钥", required = true)
    @NotBlank(message="私钥不能为空")
    @Size(min=200,max=200)
    private String privateKey;

    @ApiModelProperty(value="解密数据", required = true)
    @NotBlank(message="解密数据不能为空")
    private String data;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
