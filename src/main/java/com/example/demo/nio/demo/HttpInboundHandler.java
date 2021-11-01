package com.example.demo.nio.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpInboundHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest){
            HttpRequest request= (HttpRequest)msg;
            String uri = request.getUri();
            if("/favicon.ico".endsWith(uri)){
                //ctx.writeAndFlush(null);
                return;
            }
            System.out.println(request.getUri());

            ByteBuf message = Unpooled.copiedBuffer("哈喽，我是服务器", CharsetUtil.UTF_8);

            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, message);
            response.headers().add(HttpHeaderNames.CONTENT_TYPE,"text/plain;charset=utf-8");
            response.headers().add(HttpHeaderNames.CONTENT_LENGTH,message.readableBytes());
            ctx.writeAndFlush(response);
        }
    }
}
