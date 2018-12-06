package com.tensquare.friend;

import com.tensquare.friend.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Description:
 * date: 2018/12/4 11:25
 * author: loveLy
 */
@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {

    //主要是代码springmvc配置文件使拦截器生效

    @Autowired
    private JwtFilter jwtFilter;

    //添加拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtFilter).
                addPathPatterns("/**")  //拦截所有
                .excludePathPatterns("/**/login");  //放行登录页面
    }
}
