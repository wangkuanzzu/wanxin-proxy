package com.qb.ad.common.util;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.util.ArrayList;

/**
 * @Description: 金额工具类
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.qlpay.org
 */
public class AmountUtil {

    /**
     * 将字符串"元"转换成"分"
     * @param str
     * @return
     */
    public static String convertDollar2Cent(String str) {
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuffer sb = df.format(Double.parseDouble(str),
                new StringBuffer(), new FieldPosition(0));
        int idx = sb.toString().indexOf(".");
        sb.deleteCharAt(idx);
        for (; sb.length() != 1;) {
            if(sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串"分"转换成"元"（长格式），如：100分被转换为1.00元。
     * @param s
     * @return
     */
    public static String convertCent2Dollar(String s) {
        if("".equals(s) || s ==null){
            return "";
        }
        long l;
        if(s.length() != 0) {
            if(s.charAt(0) == '+') {
                s = s.substring(1);
            }
            l = Long.parseLong(s);
        } else {
            return "";
        }
        boolean negative = false;
        if(l < 0) {
            negative = true;
            l = Math.abs(l);
        }
        s = Long.toString(l);
        if(s.length() == 1)
            return(negative ? ("-0.0" + s) : ("0.0" + s));
        if(s.length() == 2)
            return(negative ? ("-0." + s) : ("0." + s));
        else
            return(negative ? ("-" + s.substring(0, s.length() - 2) + "." + s
                    .substring(s.length() - 2)) : (s.substring(0,
                    s.length() - 2)
                    + "." + s.substring(s.length() - 2)));
    }

    /**
     * 将字符串"分"转换成"元"（短格式），如：100分被转换为1元。
     * @param s
     * @return
     */
    public static String convertCent2DollarShort(String s) {
        String ss = convertCent2Dollar(s);
        ss = "" + Double.parseDouble(ss);
        if(ss.endsWith(".0"))
            return ss.substring(0, ss.length() - 2);
        if(ss.endsWith(".00"))
            return ss.substring(0, ss.length() - 3);
        else
            return ss;
    }



    /**
     * @Title: addThousandSeparator
     * @Description: 格式化数字为千分位
     * @param t
     * @return String
     * @return String 返回类型
     */
    public static String addThousandSeparator(String t) {
        if (t == null) {
            return null;
        }
        String text = convertCent2Dollar(t);
        int index = text.indexOf(".");
        if (index > 0) {
            String integerPartial = text.substring(0, index);
            String decimalPartial = text.substring(index);
            return addThousandSeparatorForInteger(integerPartial) + decimalPartial;
        } else {
            return addThousandSeparatorForInteger(text);
        }
    }

    // 只给整数加千分位分隔符
    public static String addThousandSeparatorForInteger(String text) {
        int index = text.indexOf(".");
        if (index != -1) {
            return text;
        } else {
            int length = text.length();
            ArrayList<String> stringContainer = new ArrayList<String>();
            while (length > 3) {
                stringContainer.add(text.substring(length - 3, length));
                length = length - 3;
            }
            stringContainer.add(text.substring(0, length)); // 将最前面的小于三个数字的也加入到数组去
            StringBuffer buffer = new StringBuffer();
            for (int i = stringContainer.size() - 1; i >= 0; i--) {
                buffer.append(stringContainer.get(i) + ",");
            }
            buffer.deleteCharAt(buffer.length() - 1);
            return buffer.toString();
        }
    }
}
