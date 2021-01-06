package com.example.demo.action;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
//@Import(value={PersonService.class,TestBeanRegistry.class})
@ComponentScan("com.example.demo")
//@Import(value={PersonService.class,TestBeanRegistry.class})
public class TestConfig{

    /**
     * 自定义管理bean生命周期的是那种方法
     * 1、 @Bean(initMethod="init",destroyMethod="destoro")  指定初始化和销毁方法  ---最正经的初始化方法
     * 2、实现InitializingBean、DisposableBean接口
     * 3、使用jsr250规范的注解，在方法上添加 @PostConstruct、 @PreDestroy注解
     *      @PostConstruct
     *     public void init(){
     *         System.out.println("init");
     *     }
     * @return
     */

    @Bean(initMethod="init",destroyMethod="destoro")
    public Dog dog(){
        return new Dog();
    }
    @Bean
    public PersonService personService(){
        return new PersonService();
    }
}
