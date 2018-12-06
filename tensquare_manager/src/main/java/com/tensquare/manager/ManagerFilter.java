package com.tensquare.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

/**
 * Description:
 * date: 2018/12/5 15:13
 * author: loveLy
 */
@Component
public class ManagerFilter /*extends ZuulFilte*/ {


    @Autowired
    private JwtUtil jwtUtil;

    //@Override
    public String filterType() {//过滤器类型
        return "pre";//前置过滤器
    }

    //@Override
    public int filterOrder() {
        return 0;//优先级，数字越大，优先级越低
    }

    //@Override
    public boolean shouldFilter() {
        return true;//过滤器开关，true表示开启
    }


    //@Override
    public Object run() /*throws ZuulException*/ {
        System.out.println("Zuul过滤器");

        /*requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //如果是跨域请求则放行
        if(request.getMethod().equals("OPTIONS")){
            return null;
        }*/
        //如果是登录请求则放行
        /*String url=request.getRequestURL().toString();
        if(url.indexOf("/admin/login")>0){
            System.out.println("登陆页面"+url);
            return null;
        }*/

        //其他情况进行鉴权
        /*String authHeader =(String)request.getHeader("Authorization");//获取头信息
        if(authHeader!=null && authHeader.startsWith("Bearer ") ){
            String token = authHeader.substring(7);
            Claims claims = jwtUtil.parseJWT(token);
            if(claims!=null){
                //如果拿到token并且有管理员权限,则添加头信息
                if("admin".equals(claims.get("roles"))){
                    requestContext.addZuulRequestHeader("Authorization",authHeader);
                    System.out.println("token 验证通过，添加了头信息"+authHeader);
                    return null;
                }
            }
        }*/

        //没有权限
        /*requestContext.setSendZuulResponse(false);//终止运行
        requestContext.setResponseStatusCode(401);//http状态码
        requestContext.setResponseBody("无权访问");
        //乱码处理
        requestContext.getResponse().setContentType("text/html;charset=UTF-8");*/
        return null;
    }
}
