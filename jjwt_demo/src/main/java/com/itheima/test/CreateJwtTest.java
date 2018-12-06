package com.itheima.test;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Description:
 * date: 2018/12/3 21:57
 * author: loveLy
 */
public class CreateJwtTest {

    //生成Token
    public static void main(String[] args) {

        long now = System.currentTimeMillis();
        long exp = now + 1000*60;   //1分钟过期时间
        JwtBuilder builder = Jwts.builder().setId("888")
                .setSubject("小白")   //面向的用户
                .setIssuedAt(new Date())    //签发时间
                .setExpiration(new Date(exp))   //设置过期时间
                .claim("roles","admin")     //自定义claim
                .claim("logo","logo.png")
                .signWith(SignatureAlgorithm.HS256, "itcast");  //设置签名密钥

        System.out.println(builder.compact());

    }
}
