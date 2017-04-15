package com.trows.sso.extra.demo.netty.Echo.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;

/**
 * Created by pengruoying on 2017/4/13.
 * 客户端处理服务
 */
public class EchoClientHandler extends ChannelHandlerAdapter {
    private static final Logger logger = LogManager.getLogger(EchoClientHandler.class);

    private int counter;
    private static final String ECHO_REQ = "Hello Server!$_";

    @Override
    public void channelActive(ChannelHandlerContext context) {
        for (int i = 0; i < 10; i++) {
            context.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext context, Object msg) {
        logger.info("This is " + ++counter + " times receive server : [" + msg + "]");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable throwable) {
        logger.error("Unexpected exception" + throwable.getMessage());
        context.close();
    }
}
