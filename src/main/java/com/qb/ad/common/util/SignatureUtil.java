package com.qb.ad.common.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Formatter;

public class SignatureUtil {
    public SignatureUtil() {
    }

    public static String genEncryptString(String joinstr, String API_SECRET) {
        String signature = "";

        try {
            SecretKeySpec e = new SecretKeySpec(API_SECRET.getBytes(), "HmacSHA256");
            Mac mac = Mac.getInstance(e.getAlgorithm());
            mac.init(e);
            byte[] hmac = mac.doFinal(joinstr.getBytes());
            StringBuilder sb = new StringBuilder(hmac.length * 2);
            Formatter formatter = new Formatter(sb);
            byte[] var8 = hmac;
            int var9 = hmac.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                byte b = var8[var10];
                formatter.format("%02x", new Object[]{Byte.valueOf(b)});
            }

            signature = sb.toString();
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        return signature;
    }

    public static String genJoinStr(String timestamp, String dataJson, String API_KEY) {
        StringBuffer aftersort = new StringBuffer();
        aftersort.append(dataJson).append(timestamp).append(API_KEY);
        String join_str = aftersort.toString();
        return join_str;
    }

    public static void main(String[] args) {
        String key = "YjcxNTM4MDUtNjQxZi00NjgzLWFhY2QtYjYyZmYzOGFjMjIz";
        String timestamp = "14223020022";
        String dataJson = "{\"aa\":\"bb\",\"cc\":\"dd\"}";
        String joinStr = genJoinStr(timestamp, dataJson, key);
        System.out.println(joinStr);
        System.out.println(genEncryptString(joinStr, key));
    }
}
