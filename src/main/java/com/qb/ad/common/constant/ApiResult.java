package com.qb.ad.common.constant;

import com.qb.ad.common.enumm.ApiResultCodeEnum;

import java.io.Serializable;

/**
 * 开放api接口返回对象
 *
 */
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 响应码
    private String status;

    // 响应描述（用户信息）
    private String message;
    // 描述信息（开发人员使用）
    private String info;
    // 响应扩展
    private T result;
    //健康检查对象

    private static ApiResult<String> healthApiResult = new ApiResult<>();


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static ApiResult error(String code, String message, String info) {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(code);
        apiResult.setMessage(message);
        apiResult.setInfo(info);
        return apiResult;
    }
    public static ApiResult error(ApiResultCodeEnum apiResultCodeEnum, String info) {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(apiResultCodeEnum.getCode());
        apiResult.setMessage(apiResultCodeEnum.getMessage());
        apiResult.setInfo(info);
        return apiResult;
    }
    public static ApiResult error(ApiResultCodeEnum apiResultCodeEnum) {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(apiResultCodeEnum.getCode());
        apiResult.setMessage(apiResultCodeEnum.getMessage());
        apiResult.setInfo(apiResultCodeEnum.getMessage());
        return apiResult;
    }

    public static ApiResult success() {
        ApiResult apiResult = new ApiResult();
        apiResult.setInfo("success");
        apiResult.setStatus(ApiResultCodeEnum.SUCCESS.getCode());
        apiResult.setMessage(ApiResultCodeEnum.SUCCESS.getMessage());
        return apiResult;
    }

    public static <T> ApiResult success(T data) {
        ApiResult apiResult = new ApiResult();
        apiResult.setInfo("success");
        apiResult.setStatus(ApiResultCodeEnum.SUCCESS.getCode());
        apiResult.setMessage(ApiResultCodeEnum.SUCCESS.getMessage());
        apiResult.setResult(data);
        return apiResult;
    }

    /**
     * 返回健康检查对象
     */
    public static ApiResult<String> getHealthApiResult(String status) {
        healthApiResult.setMessage("ok");
        healthApiResult.setStatus(status);
        return healthApiResult;
    }
}
