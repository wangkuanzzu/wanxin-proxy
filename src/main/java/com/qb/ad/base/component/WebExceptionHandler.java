package com.qb.ad.base.component;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.qb.ad.common.constant.ApiResult;
import com.qb.ad.common.constant.AppException;
import com.qb.ad.common.enumm.ApiResultCodeEnum;
import com.qb.ad.common.util.MyLog;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.GeneralSecurityException;
import java.sql.SQLException;

/**
 * @description: 异常处理
 * @author: cuilh1
 * @date: 2020/3/3
 */
@RestControllerAdvice
@ResponseBody
public class WebExceptionHandler {

    private static final MyLog logger = MyLog.getLog(WebExceptionHandler.class);

    @ExceptionHandler
    public ApiResult appException(AppException appException) {
        logger.error("自定义异常", appException);
        ApiResult apiResult = ApiResult.error(appException.getCode(), appException.getMessage(), appException.getMessage());
        return apiResult;
    }

    /**
     * @description 请求体参数空异常
     * @param exception
     * @return com.qb.ad.common.constant.ApiResult
     * @author cuilh
     * @date 2020/4/10 14:12
     */
    @ExceptionHandler
    public ApiResult httpMessageNotReadableException(HttpMessageNotReadableException exception) {
        logger.error("请求体参数空异常", exception);
        ApiResult apiResult = ApiResult.error(ApiResultCodeEnum.REQUEST_GET_PARAM_NULL, exception.getMessage());
        return apiResult;
    }

    /**
     * 密钥引起的异常（解密/验签）
     * @param ex
     * @return
     */
    @ExceptionHandler(GeneralSecurityException.class)
    public ApiResult generalSecurityException(GeneralSecurityException ex){
        logger.error("GeneralSecurityException", ex);
        ApiResult result = ApiResult.error(ApiResultCodeEnum.KEY_PAIR_ERROR,  ex.getMessage());
        return result;
    }

    @ExceptionHandler(NullPointerException.class)
    public ApiResult nullPointerException(NullPointerException exception){
        logger.error("NullPointerException", exception);
        ApiResult result = ApiResult.error(ApiResultCodeEnum.NULL_ERROR,  exception.getMessage());
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.debug("validationFail MethodArgumentNotValidException" + ex.getMessage());
        FieldError fieldError = ex.getBindingResult().getFieldError();
        logger.info("validationFail", fieldError.getField()+fieldError.getDefaultMessage());
        return ApiResult.error(ApiResultCodeEnum.PARAM_VALIDATE_FAIL, fieldError.getDefaultMessage());
    }
    @ExceptionHandler(BindException.class)
    public ApiResult bindException(BindException ex) {
        logger.info("validationFail BindException", ex);
        FieldError fieldError = ex.getBindingResult().getFieldError();
        logger.info("validationFail", fieldError.getField()+fieldError.getDefaultMessage());
        return ApiResult.error(ApiResultCodeEnum.PARAM_VALIDATE_FAIL, fieldError.getDefaultMessage());
    }
    @ExceptionHandler(InvalidFormatException.class)
    public ApiResult jsonDatabindInvalidFormatException(InvalidFormatException exception) {
        logger.error("InvalidFormatException", exception);
        return ApiResult.error(ApiResultCodeEnum.JSON_DATA_BIND_ERROR, exception.getMessage());
    }

    @ExceptionHandler
    public ApiResult SQLException(SQLException exception) {
        logger.error("sql异常", exception);
        ApiResult apiResult = ApiResult.error(ApiResultCodeEnum.SQL_ERROR);
        return apiResult;
    }

    @ExceptionHandler
    public ApiResult unknownException(Exception exception) {
        logger.error("系统异常", exception);
        ApiResult apiResult = ApiResult.error(ApiResultCodeEnum.SYSTEM_ERROR, exception.getMessage());
        return apiResult;
    }
}
