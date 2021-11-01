package com.example.demo.nio.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class MyIdleStateHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;
            IdleState idleState = event.state();
            switch (idleState) {
                case ALL_IDLE:
                    System.out.println("读写空闲事件...");
                    break;
                case READER_IDLE:
                    System.out.println("读空闲事件...");
                    break;
                case WRITER_IDLE:
                    System.out.println("写空闲事件...");
                    break;
            }
        }

    }
}
