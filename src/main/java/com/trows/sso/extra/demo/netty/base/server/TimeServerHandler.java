package com.trows.sso.extra.demo.netty.base.server;

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
public class TimeServerHandler extends ChannelHandlerAdapter {

    private static final Logger logger = LogManager.getLogger(TimeServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext context, Object msg) throws UnsupportedEncodingException {
        logger.info("receive request");
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        String body = new String(req, "UTF-8");
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date().toString() : "BAD ORDER";
        context.write(Unpooled.copiedBuffer(currentTime.getBytes()));

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext context) {
        context.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable throwable) {
        context.close();
    }

}
