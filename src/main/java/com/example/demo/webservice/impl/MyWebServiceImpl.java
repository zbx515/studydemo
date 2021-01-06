package com.example.demo.webservice.impl;

import com.example.demo.webservice.MyWebService;

import javax.jws.WebService;

@WebService(serviceName = "MyWebService",targetNamespace = "http://webservice.demo.com",
            endpointInterface = "com.example.demo.webservice.MyWebService")
public class MyWebServiceImpl implements MyWebService {
    @Override
    public String getName(String name) {
        return "WebService测试成功：" + name;
    }
}
