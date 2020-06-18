package com.qb.ad.common.util;

import com.qb.ad.common.constant.ApiResult;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * @Description ResponseUtils
 * @Author clh
 * @Date 2020-03-05 22:27
 */
public class ResponseUtils {
    /**
     * 使用response输出JSON
     *
     * @param response
     * @param result
     */
    public static void out(ServletResponse response, ApiResult result) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JsonUtil.object2JsonWithNull(result));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

}
