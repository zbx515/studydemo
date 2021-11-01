package com.example.demo.nio.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MyServerHandler extends SimpleChannelInboundHandler<MessageEntry> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageEntry msg) throws Exception {
        System.out.println("收到客户端消息： ");
        System.out.println(msg);

        String message = new String("我是服务器，这是要的消息...");
        int length = message.getBytes(CharsetUtil.UTF_8).length;
        MessageEntry messageEntry = new MessageEntry(2, length, message);
        ctx.channel().writeAndFlush(messageEntry);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("服务器收到连接");
    }
}
