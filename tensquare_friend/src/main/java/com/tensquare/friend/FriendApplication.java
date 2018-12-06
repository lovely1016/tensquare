package com.tensquare.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import util.IdWorker;
import util.JwtUtil;

/**
 * Description:
 * date: 2018/12/4 17:09
 * author: loveLy
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class FriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
