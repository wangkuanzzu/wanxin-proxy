package com.qb.ad.base.rest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "广告获取参数")
public class AdGetParam {

    @ApiModelProperty(value="广告位置id（入场推送：1；出场推送：2；输入车牌：3；支付页面：4；付款成功：5）")
    @NotBlank(message = "广告位置id不能为空")
    private String adPosId;

    public String getAdPosId() {
        return adPosId;
    }

    public void setAdPosId(String adPosId) {
        this.adPosId = adPosId;
    }
}
