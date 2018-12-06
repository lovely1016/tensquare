package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * Description:
 * date: 2018/11/27 20:41
 * author: loveLy
 */
@SpringBootApplication
@EnableEurekaClient
public class SpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class,args);
    }


    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
