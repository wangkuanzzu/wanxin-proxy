package com.qb.ad.base.rest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 *
 */
@ApiModel(description = "验签服务参数")
public class VerifyPostParam {

    @ApiModelProperty(value="公钥", required = true)
    @NotBlank(message="公钥不能为空")
    @Size(min=124,max=124)
    private String publicKey;

    @ApiModelProperty(value="验签数据", required = true)
    @NotBlank(message="验签数据不能为空")
    private Map<String,String> data;

    @ApiModelProperty(value="签名串", required = true)
    @NotBlank(message="签名串不能为空")
    private String sign;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
