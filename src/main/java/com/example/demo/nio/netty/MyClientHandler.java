package com.example.demo.nio.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MyClientHandler extends SimpleChannelInboundHandler<MessageEntry> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageEntry msg) throws Exception {
        System.out.println("收到服务器回复消息");
        System.out.println(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接成功");
        //当连接激活时，发送消息
        MessageEntry messageEntry = new MessageEntry();
        messageEntry.setId(1);
        String message = new String("我是客户端...");
        messageEntry.setLength(message.getBytes(CharsetUtil.UTF_8).length);
        messageEntry.setContent(message);
        ctx.channel().writeAndFlush(messageEntry);
        System.out.println("消息发送成功");
    }
}
