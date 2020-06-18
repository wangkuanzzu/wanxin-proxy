package com.qb.ad.base.health;

import com.qb.ad.common.constant.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;



@Controller
public class HealthController  {


    /**
     * healthCheck
     *
     * @param request
     * @return
     */
    @RequestMapping("/health")
    @ResponseBody
    public ApiResult healthCheck(HttpServletRequest request) {
        ApiResult ret = ApiResult.success();
        return ret;
    }

}
