package com.example.demo;

import com.example.demo.spboot.dao.UserMapper;
import com.example.demo.spboot.domain.User;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Autowired
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
    }

    /**
     * MQ测试 -- Queue
     * @throws Exception
     */
    @Test
    public void send()throws Exception{
        ActiveMQMessage mqMessage = new ActiveMQMessage();
        mqMessage.setStringProperty("msg","这是第一条测试消息...");
        jmsMessagingTemplate.convertAndSend(this.queue,mqMessage);
    }

    /**
     * MQ测试 -- Topic
     * @throws Exception
     */
    @Test
    public void sendTopic()throws Exception{
        jmsMessagingTemplate.convertAndSend(this.topic,"Topic : 这是第2条测试消息...");
    }


    /**
     * redis测试
     */
    @Test
    public void testRedis(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("key","hahaha");
        String key1 = opsForValue.get("key");
        System.out.println(key1);

    }


    @Test
    public void testQuery(){
        List query = userMapper.query("000001");
        System.out.println(query);
    }


    @Test
    public void testInsert(){
        User user = new User("000002", "哈哈哈");
        userMapper.insert(user);
    }
}
