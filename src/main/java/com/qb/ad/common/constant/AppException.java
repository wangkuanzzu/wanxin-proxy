package com.qb.ad.common.constant;


import com.qb.ad.common.enumm.ApiResultCodeEnum;

public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;

    public AppException(Throwable cause, String code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }
    public AppException(ApiResultCodeEnum apiResultCodeEnum) {
        super();
        this.code = apiResultCodeEnum.getCode();
        this.message = apiResultCodeEnum.getMessage();
    }


    public AppException(String code, String message) {
        super(String.format("【%s:%s】", new Object[]{code, message}));
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
