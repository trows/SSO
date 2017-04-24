package com.trows.sso.extra.demo.netty.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;

import java.util.List;

/**
 * Created by pengruoying on 2017/4/19.
 * HttpJsonResponseDecoder
 */
public class HttpJsonResponseDecoder extends AbstractHttpJsonDecoder<DefaultFullHttpResponse>{
    protected HttpJsonResponseDecoder(Class<?> clazz) {
        super(clazz);
    }

    protected void decode(ChannelHandlerContext context,
                          DefaultFullHttpResponse msg, List<Object> out) throws Exception {
        HttpJsonResponse response = new HttpJsonResponse(msg,decodeDefault(context,msg.content()));
        out.add(response);
    }
}
