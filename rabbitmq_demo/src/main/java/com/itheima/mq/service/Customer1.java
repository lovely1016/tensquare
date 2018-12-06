package com.itheima.mq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * date: 2018/12/1 21:27
 * author: loveLy
 */
@Component
@RabbitListener(queues = "itcast")
public class Customer1 {


    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itcastNo1接收到消息:"+message);
    }


}
