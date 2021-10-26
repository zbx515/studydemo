package com.example.demo.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServer {
    public static void main(String[] args)throws Exception {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8899));
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        FileOutputStream outputStream = new FileOutputStream("ddj.pdf");
        int count = 0;
        while((count = socketChannel.read(byteBuffer)) > 0){
            outputStream.write(byteBuffer.array());
            byteBuffer.rewind();
        }

    }
}
