package com.qb.ad.base.rest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Map;

/**
 *
 */
@ApiModel(description = "签名服务参数")
public class SignPostParam {

    @ApiModelProperty(value="私钥", required = true)
    @NotBlank(message="私钥不能为空")
    @Size(min=200,max=200)
    private String privateKey;

    @ApiModelProperty(value="签名数据", required = true)
    @NotBlank(message="签名数据不能为空")
    private Map<String,String> data;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
