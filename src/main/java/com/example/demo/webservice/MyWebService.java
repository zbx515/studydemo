package com.example.demo.webservice;

import javax.jws.WebService;

@WebService(name = "MyWebService",targetNamespace="http://webservice.demo.com")
public interface MyWebService {
    String getName(String name);
}
