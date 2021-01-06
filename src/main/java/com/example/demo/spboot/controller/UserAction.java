package com.example.demo.spboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.spboot.domain.User;
import com.example.demo.spboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RestController
public class UserAction {

    private final Logger logger = LoggerFactory.getLogger(UserAction.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    public String insert(@PathVariable String aac001,@PathVariable  String aac003){
        logger.info("NFO ----  insert: aac001:"+ aac001+"aac003:"+aac003);
        User user = new User(aac001,aac003);
        userService.insert(user);
        return "保存成功";
    }
    @RequestMapping("/query/{aac002}")
    @ResponseBody
    public String query(@PathVariable("aac002") String aac002){
        logger.info("INFO ---- query: aac002"+aac002);
        List<User> list = userService.query(aac002);
        String s = JSONObject.toJSONString(list);
        System.out.println(s);
        return s;
    }


}
