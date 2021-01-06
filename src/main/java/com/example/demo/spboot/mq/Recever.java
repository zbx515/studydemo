package com.example.demo.spboot.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.MapMessage;
import javax.jms.Message;

@Component
public class Recever {
    @JmsListener(destination = "test")
    public void receverQueue(Message message)throws Exception{
        String info = message.getStringProperty("msg");
        System.out.println(info);
    }

    @JmsListener(destination = "testTopic")
    public void receverTopic(String message)throws Exception{
        System.out.println(message);
    }
}
