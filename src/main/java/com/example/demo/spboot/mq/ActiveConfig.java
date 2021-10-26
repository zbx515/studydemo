package com.example.demo.spboot.mq;



import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

//@Configuration
public class ActiveConfig {
    @Bean
    public Queue firstQueue(){
        return new ActiveMQQueue("test");
    }

    @Bean
    public Topic firstTopic(){
        return new ActiveMQTopic("testTopic");
    }
}
