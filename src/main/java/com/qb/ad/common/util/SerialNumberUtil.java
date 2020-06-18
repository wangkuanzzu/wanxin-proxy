package com.qb.ad.common.util;

/**
 * @description: 业务编码工具类
 * @author: cuilh1
 * @date: 2020/4/14
 */
public class SerialNumberUtil {

    private static final String PARK_ID_FORMAT      = "%s-%s";
    private static final String PARK_ID_SPLlITER    = "-";
    private static final String SERIALNUMBER        = "%s-%s";

    public static String generateSerialNumber(String data1, String data2) {
        return String.format(SERIALNUMBER, data1, data2);
    }

    public static String generateParkSerialNumber(String partnerId, String parkId) {
        return String.format(PARK_ID_FORMAT, partnerId, parkId);
    }

    public static String getParkIdFromSerialNumber(String serialNumber) {
        return serialNumber.substring(serialNumber.indexOf(PARK_ID_SPLlITER) + 1);
    }
}
