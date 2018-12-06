package com.tensquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * Description:
 * date: 2018/11/29 9:30
 * author: loveLy
 */
@SpringBootApplication
@EnableEurekaClient
public class ArticleSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleSearchApplication.class,args);
    }


    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
