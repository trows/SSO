package com.trows.sso.extra.demo.netty.http;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.Charset;

/**
 * Created by pengruoying on 2017/4/19.
 * AbstractHttpJsonDecoder
 */
public abstract class AbstractHttpJsonDecoder<T> extends MessageToMessageDecoder<T> {
    private static final Logger logger = LogManager.getLogger(AbstractHttpJsonDecoder.class);

    private Class<?> clazz;
    private final static String CHARSET_NAME = "UTF-8";
    private final static Charset UTF_8 = Charset.forName(CHARSET_NAME);

    protected AbstractHttpJsonDecoder(Class<?> clazz) {
        this.clazz = clazz;
    }

    protected Object decodeDefault(ChannelHandlerContext channelHandlerContext, ByteBuf body) throws Exception {
        String content = body.toString(UTF_8);
        return JSON.parseObject(content, clazz);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable throwable) {
            logger.error(throwable);
    }
}
