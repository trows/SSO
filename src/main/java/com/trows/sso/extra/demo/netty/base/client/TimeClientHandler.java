package com.trows.sso.extra.demo.netty.base.client;

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
public class TimeClientHandler extends ChannelHandlerAdapter {
    private static final Logger logger = LogManager.getLogger(TimeClientHandler.class);

    private final ByteBuf firstMessage;


    public TimeClientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext context) {
        context.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext context, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] res = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(res);
        try {
            logger.info("Now is : " + new String(res, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable throwable) {
        logger.error("Unexpected exception" + throwable.getMessage());
        context.close();
    }
}
