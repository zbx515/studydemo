package com.example.demo.spboot.mq;

import org.apache.activemq.command.ActiveMQMessage;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class Sender {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void sendQueue()throws Exception{
        ActiveMQMessage mqMessage = new ActiveMQMessage();
        mqMessage.setStringProperty("msg","这是第一条测试消息...");
        jmsMessagingTemplate.convertAndSend(this.queue,mqMessage);
    }

    public void sendTopic()throws Exception{
        jmsMessagingTemplate.convertAndSend(this.topic,"Topic : 这是第一条测试消息...");
    }

}
