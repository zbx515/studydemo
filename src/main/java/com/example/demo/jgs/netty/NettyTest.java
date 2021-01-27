package com.example.demo.jgs.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import org.junit.jupiter.api.Test;

import javax.xml.stream.events.Characters;
import java.net.InetSocketAddress;

public class NettyTest {

    /**
     * netty
     * 服务端
     */
    @Test
    public void server() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        //server
        ChannelFuture future = new ServerBootstrap()
                //设置线程组
                .group(group)
                //设置channel类型
                .channel(NioServerSocketChannel.class)
                //设置handler，此ChannelInitializer  为过桥用
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new Myhandler());
                    }
                })
                //绑定到IP port
                .bind(new InetSocketAddress(9090));

        future.sync().channel().closeFuture().sync();

    }

    @Test
    public void client() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        ChannelFuture future = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new Myhandler());
                    }
                })
                .connect(new InetSocketAddress(9090));

        Channel client = future.sync().channel();
        ByteBuf byteBuf = Unpooled.copiedBuffer("我是你爸爸".getBytes());
        ChannelFuture send = client.writeAndFlush(byteBuf);
        send.sync();
        client.closeFuture().sync();

    }

}

class Myhandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client  registed...");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        CharSequence charSequence = buf.getCharSequence(0, buf.readableBytes(), CharsetUtil.UTF_8);
        System.out.println(charSequence);
        ctx.writeAndFlush(buf);
    }
}
