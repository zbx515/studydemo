package com.example.demo.nio.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class GroupChatClient {
    public static void main(String[] args)throws Exception {
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            ChannelFuture channelFuture = bootstrap.group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    //.addLast(new StringEncoder())
                                    //.addLast(new StringDecoder())
                                    .addLast(new MyByteToMessageHandler())
                                    .addLast(new MyMessageToByteHandler())
                                    .addLast(new MyClientHandler());
                        }
                    }).connect("localhost", 9999).sync();
            //channelFuture.channel().writeAndFlush("hahahhah");
            while(true){

            }
        }finally {
            loopGroup.shutdownGracefully();
        }
    }
}
