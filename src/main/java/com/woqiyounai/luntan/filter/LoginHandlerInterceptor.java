package com.woqiyounai.luntan.filter;

import com.woqiyounai.luntan.util.TokenUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//进行登录拦截
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //进行登录权限验证
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip)) {
            ip = request.getRemoteAddr();
            if (StringUtils.isEmpty(ip)) {
                ip = "127.0.0.1";
            }
        }
        if (TokenUtil.checkToken(token,userId,ip)) {
            System.out.println("pass");
            return true;
        }
        //开发模式,直接return true

        return false;
    }
}
