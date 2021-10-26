package com.example.demo.rpc;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.HashMap;

public class ClientUtil {
    public static void main(String[] args) {
        ServerProducer method = new ClientUtil().getRemortMethod();
        method.sendData();
    }

    public  ServerProducer getRemortMethod(){
        ServerProducer proxyInstance = (ServerProducer)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{ServerProducer.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket client = new Socket();
                client.connect(new InetSocketAddress("localhost", 8899));
                HashMap<String, String> param = new HashMap<>();
                param.put("interfaceName", "ServerTest");
                param.put("methodName", "test");
                param.put("args", "aaaa");
                String string = JSON.toJSONString(param);
                //发送请求数据
                DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
                dataOutputStream.writeUTF(string);
                dataOutputStream.flush();
                //读取返回结果
                DataInputStream stream = new DataInputStream(client.getInputStream());
                String str = stream.readUTF();
                System.out.println(new String(str));
                return null;
            }
        });
        return proxyInstance;
    }
}
