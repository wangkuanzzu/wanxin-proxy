package com.qb.ad.base.rest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 *
 */
@ApiModel(description = "加密服务参数")
public class EncodePostParam {

    @ApiModelProperty(value="公钥", required = true)
    @NotBlank(message="公钥不能为空")
    @Size(min=124,max=124)
    private String publicKey;

    @ApiModelProperty(value="加密数据", required = true)
    @NotBlank(message="加密数据不能为空")
    private String data;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
