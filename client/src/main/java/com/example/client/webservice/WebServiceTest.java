package com.example.client.webservice;

import com.example.demo.webservice.MyWebService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class WebServiceTest {

    public static void main(String[] args) {
        //WebServiceTest.test1();
        WebServiceTest.test2();
    }
    /**
     * 1.代理类工厂的方式,需要拿到对方的接口地址
     */
    public static void test1() {
        try {
            // 接口地址
            String address = "http://127.0.0.1:8080/demo/zb?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(MyWebService.class);
            // 创建一个代理接口实现
            MyWebService us = (MyWebService) jaxWsProxyFactoryBean.create();
            String name = us.getName("张半仙");
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 2：动态调用
     */
    public static void test2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8080/demo/zb?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new MyInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getName", "张半仙");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
