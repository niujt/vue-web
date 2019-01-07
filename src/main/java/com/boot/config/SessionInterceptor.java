package com.boot.config;

import com.boot.entity.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置登录拦截器
 */
public class SessionInterceptor implements HandlerInterceptor {
    public static Logger logger= LoggerFactory.getLogger(SessionInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws  Exception{
            logger.info(request.getRequestURI());
            if(request.getRequestURI().equals("/login")){
                return true;
            }
            Login login=(Login)request.getSession().getAttribute("login");
            if(login==null){
                return false;
            }
            else{
                return true;
            }
    }


}
