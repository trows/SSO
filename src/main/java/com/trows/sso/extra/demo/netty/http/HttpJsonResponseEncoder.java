package com.trows.sso.extra.demo.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

import java.util.List;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;

/**
 * Created by pengruoying on 2017/4/19.
 * HttpJsonResponseEncoder
 */
public class HttpJsonResponseEncoder extends AbstractHttpJsonEncoder<HttpJsonResponse> {
    protected void encode(ChannelHandlerContext channelHandlerContext, HttpJsonResponse httpJsonResponse, List<Object> list)
            throws Exception {
        ByteBuf body = encodeDefault(channelHandlerContext, httpJsonResponse.getResult());
        FullHttpResponse response = httpJsonResponse.getResponse();

        if (response == null) {
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, body);
        } else {
            response = new DefaultFullHttpResponse(httpJsonResponse.getResponse().getProtocolVersion(),
                    httpJsonResponse.getResponse().getStatus(), body);
        }

        response.headers().set(CONTENT_TYPE,body.readableBytes());
        list.add(response);
    }
}
