package com.example.demo.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

public class MyMessageToByteHandler extends MessageToByteEncoder<MessageEntry> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageEntry msg, ByteBuf out) throws Exception {
        System.out.println("编码方法调用");
        out.writeInt(msg.getId());
        out.writeInt(msg.getLength());
        byte[] bytes = msg.getContent().getBytes(CharsetUtil.UTF_8);
        out.writeBytes(bytes);
    }
}
