package com.tensquare.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
 * Description:
 * date: 2018/12/5 14:22
 * author: loveLy
 */
//@EnableZuulProxy
@SpringBootApplication
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class);
    }


    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
