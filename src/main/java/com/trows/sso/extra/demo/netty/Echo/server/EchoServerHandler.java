package com.trows.sso.extra.demo.netty.Echo.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by pengruoying on 2017/4/10.
 * 服务处理handler
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

    private static final Logger logger = LogManager.getLogger(EchoServerHandler.class);

    private static final String ECHO_REQ = "Hello Client! I got your message :";
    private int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext context, Object msg) throws UnsupportedEncodingException {
        String body = (String) msg;
        logger.info("This is " + ++counter + " times receive client : [" + body + "]");
        body = ECHO_REQ + body + "$_";
        context.writeAndFlush(Unpooled.copiedBuffer(body.getBytes()));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext context) {
        logger.info("channelReadComplete");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable throwable) {
        logger.error(throwable);
        context.close();
    }

}
