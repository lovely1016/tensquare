package com.tensquare;

import org.springframework.stereotype.Component;

/**
 * Description:
 * date: 2018/12/5 14:57
 * author: loveLy
 */
@Component
public class WebFilter /*extends ZuulFilter*/ {

    //@Override
    public String filterType() {
        return "pre";// 前置过滤器

        //pre   请求被路由之前被调用
        //route 请求时被调用
        //post  route和error过滤器之后被调用
        //error 处理请求发生错误时调用
    }

    //@Override
    public int filterOrder() {
        return 0;// 优先级为0，数字越大，优先级越低
    }

    //@Override
    public boolean shouldFilter() {
        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }

    //@Override
    public Object run() /*throws ZuulException*/ {
        System.out.println("zuul过滤器...");

        //向heander中添加鉴权令牌
        //获取当前容器对象
        //Requestcontext requestcontext = Requestcontext.getCurrentContext;
        //获取request对象,和header
        /*HttpServletRequest request = requestContext.getRequest();
        string authorization = request.getHeader("Authorization);
        if (authorization!=null) {
            requestContext.addZuulRequestHeader("Authorization",authorization);
        }*/
        //放行
        return null;
    }
}
