package com.qb.ad.base.rest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(description = "广告跳转参数")
public class AdRedirectParam {

    @ApiModelProperty(value="广告id", required = true)
    @NotBlank(message="广告id不能为空")
    private String adId;
}
