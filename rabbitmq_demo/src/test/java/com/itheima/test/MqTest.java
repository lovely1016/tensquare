package com.itheima.test;

import com.itheima.mq.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * date: 2018/12/1 19:26
 * author: loveLy
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MqTest {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend("itcast","你死不死啊");
    }


    @Test
    public void testSendFanout(){
        rabbitTemplate.convertAndSend("chuanzhi","","分列模式了解一下?");
    }


    @Test
    public void testSendTopic1(){
        rabbitTemplate.convertAndSend("topictest","goods.aaa","主题模式绑定itcast");
    }

    @Test
    public void testSendTopic2(){
        rabbitTemplate.convertAndSend("topictest","article.content.log","主题模式绑定itheima");
    }


}
