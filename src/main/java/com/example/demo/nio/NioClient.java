package com.example.demo.nio;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NioClient {
    public static void main(String[] args)throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8899));

        FileChannel channel = new FileInputStream("G:\\ddj.pdf").getChannel();
        long size = (long)Math.ceil(channel.size()*1.0/(1024*1024*8)*1.0);
        int i=0;
        long to = 0;
        long start = System.currentTimeMillis();
        while(i < size){
            to = channel.transferTo(i*to, 1024 * 1024 * 8, socketChannel);
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start));
    }
}
