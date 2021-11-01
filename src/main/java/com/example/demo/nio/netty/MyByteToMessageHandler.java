package com.example.demo.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class MyByteToMessageHandler extends ReplayingDecoder{
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("收到消息解码方法");
        int id = in.readInt();
        int length = in.readInt();

        byte[] byts = new byte[length];
        in.readBytes(byts);
        String content = new String(byts, CharsetUtil.UTF_8);
        MessageEntry messageEntry = new MessageEntry(id, length, content);
        out.add(messageEntry);
    }
}
