package com.trows.sso.extra.demo.netty.http;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by pengruoying on 2017/4/18.
 * http json
 */
public abstract class AbstractHttpJsonEncoder<T> extends MessageToMessageEncoder<T> {
    final static String CHARSET_NAME = "UTF-8";
    final static Charset UTF_8 = Charset.forName(CHARSET_NAME);

    protected ByteBuf encodeDefault(ChannelHandlerContext context, Object body) throws Exception {

        String str = JSON.toJSONString(body);
        return Unpooled.copiedBuffer(str, UTF_8);
    }

    public void exceptionCaught(ChannelHandlerContext context, Throwable throwable) {

    }
}
