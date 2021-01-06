package com.example.demo.action;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexAction {

    //返回json格式的数据
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] files){
        MultipartFile file=null;
        for(int i=0;i<files.length;i++){
            file=files[i];
            System.out.println(file.getOriginalFilename());
        }
        Map map  = new HashMap<>();
        map.put("return","success");
        String json = JSON.toJSONString(map);
        return json;
    }
}
