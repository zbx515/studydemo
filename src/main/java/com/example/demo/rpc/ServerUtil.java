package com.example.demo.rpc;


import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * rpc 服务端思想
 * 1、开启server监听来气客户端的请求
 * 2、将收到的请求 交给thread去执行
 * 3、根据请求的参数，找到对应的接口、方法
 * 4、执行、返回结果
 */
public class ServerUtil {

    public static void main(String[] args)throws Exception {
        ServerSocket server = new ServerSocket(8899);
        System.out.println("server start...");
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        while(true){
            Socket accept = server.accept();
            new Thread(new ServerTask(accept)).start();
        }
    }

    static class ServerTask implements Runnable{

        private Socket client;

        public ServerTask(Socket client){
            this.client = client;
        }

        @Override
        public void run() {
            DataInputStream input = null;
            DataOutputStream dataOutputStream = null;
            try{
                //接收请求数据
                input = new DataInputStream(client.getInputStream());
                String utf = input.readUTF();
                Map parse = JSON.parseObject(utf, Map.class);
                System.out.println(parse);
                //返回请求结果
                dataOutputStream = new DataOutputStream(client.getOutputStream());
                dataOutputStream.writeUTF("远程调用返回的结果");
                dataOutputStream.flush();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    dataOutputStream.close();
                    input.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
