package com.example.demo.webservice;

import com.example.demo.webservice.impl.MyWebServiceImpl;
import org.apache.cxf.jaxws.support.JaxWsServiceFactoryBean;

import javax.xml.ws.Endpoint;

public class WebServiceUtil {
    public static void main(String[] args) {
        String address = "http://8080/hello/WebService";
        Endpoint.publish(address,new MyWebServiceImpl());
        System.out.println("服务已启动...");
    }
}
