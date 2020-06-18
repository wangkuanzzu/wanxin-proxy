package com.qb.ad.common.enumm;

/**
 * @description:
 * @author: cuilh1
 * @date: 2020/3/3
 */
public enum ApiResultCodeEnum {
    SUCCESS("20000000", "成功"),
    NO_LOGIN("40000000", "未登录"),
    NO_PERMISSION("40000001", "没有权限"),
    LOGIN_FAIL("40000002", "用户名或密码错误"),
    USER_EXIST("40000003", "用户名已存在"),
    USER_NOT_EXIST("40000005", "用户不存在"),
    USER_DISABLE("40000006", "用户已被禁用"),
    PWD_DECODE_ERROR("40000007", "请使用密文传送密码"),
    REQUEST_GET_PARAM_NULL("40000008", "请求参数不能为空"),
    PWD_LENGTH_INVALID("40000009", "密码长度限制6-12位字符"),

    KEY_PAIR_ERROR("40001000", "密钥不匹配"),
    TRAFFIC_KEY_HOLD("40000100", "密钥已被使用"),
    TRAFFIC_NO_KEY("40000101", "请联系管理员分配密钥信息"),
    TRAFFIC_NAME_HOLD("40000102", "流量主名称已被占用"),
    TRAFFIC_NOT_EXIST("40000103", "此流量主不存在"),
    TRAFFIC_REG_TYPE_INVALID("40000104", "无效的注册类型，参见SDK的RegTypeEnum"),
    TRAFFIC_MOBILE_INVALID("40000105", "无效的联系人电话"),
    TRAFFIC_SOURCE_INVALID("40000106", "客户来源长度超出限制"),
    TRAFFIC_MANAGER_INVALID("40000107", "客户经理长度超出限制"),
    TRAFFIC_STATUS_INVALID("40000108", "您的认证状态不允许提现操作，请联系运营人员"),

    AD_NOT_EXIST("40000200", "无效的广告ID"),
    AD_POS_ERROR("40000201", "无效的广告位ID，参见SDK的AdPosIdEnum"),
    AD_URL_NOT_EXIST("40000202", "此广告无跳转链接"),
    AD_POS_NOT_EXIST("40000203", "查询不到广告位信息，请检查是否已创建广告位"),
    AD_GET_NULL("40000204", "获取不到广告信息，请联系运营人员检查是否已投放广告"),
    AD_POS_STATUS_UNABLE("40000205", "此广告位或分成状态未启用, 请联系运营人员"),

    SIGN_CHECK_FAIL("40000300", "验签失败"),

    PARK_NOT_EXIST("40000500", "车场不存在或已停用, 请联系运营人员"),
    PARK_ID_INVALID("40000501", "车场ID长度不能超过32位字符"),
    PARK_ID_EXIST("40000502", "创建车场失败，车场id已存在"),
    PARK_CITY_INVALID("40000503", "无效的城市ID，请参见SDK的CityIdEnum"),
    PARK_NAME_EXIST("40000504", "车场名称已被占用"),

    ACCOUNT_NOT_EXIT("40000600", "账户信息不存在"),
    BALANCE_ZERO("40000601", "无可提现金额"),

    FILE_ERROR_FORMAT("40000600", "文件格式错误"),
    FILE_UPLOAD_FAIL("40000601", "文件上传异常"),
    PLAN_URL_EMPTY("40000610", "跳转URL不能为空"),
    PLAN_NAME_EXIST("40000611", "计划名称已存在"),
    PLAN_NO_RESOURCE("40000612", "无可投放资源"),
    PLAN_SUMMARY_TARGET("40000613", "售卖量不能低于完成值"),
    PLAN_RESOURCE_HOLD("40000614", "排期计划有冲突"),
    PLAN_STATUS_UPDATE_REFUSE("40000615", "不允许此操作"),
    PLAN_CONTENT_EMPTY("40000616", "广告文案内容不能为空"),
    PLAN_IMAGE_EMPTY("40000617", "广告图片不能为空"),
    PLAN_END_TIME("40000618", "已开始投放，仅可修改结束时间"),
    PLAN_NOT_EXIST("40000619", "此计划不存在"),
    PLAN_INTERVAL_NULL("40000620", "请设置曝光频次"),

    ADVERTISER_NAME_EXIST("40000700","广告主名称已被占用"),

    PARAM_VALIDATE_FAIL("40009000", "参数校验失败"),
    JSON_DATA_BIND_ERROR("40009001", "参数绑定失败"),
    STATUS_ERROR("40009002", "无效的状态"),

    NOT_ALLOW_OPERATION("40009999", "不被允许的操作"),

    UNKNOWN_ERROR("50000000", "未知异常"),
    NULL_ERROR("50000001", "空指针"),
    SQL_ERROR("50000002", "SQL异常"),
    SYSTEM_ERROR("50000003", "系统异常"),


    ;

    ApiResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
