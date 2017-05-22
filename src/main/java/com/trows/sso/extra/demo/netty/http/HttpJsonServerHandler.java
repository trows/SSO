package com.trows.sso.extra.demo.netty.http;

import com.trows.sso.model.Account;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * Created by pengruoying on 2017/4/20.
 * HttpJsonServerHandler
 */
public class HttpJsonServerHandler extends SimpleChannelInboundHandler<HttpJsonRequest> {

    @Override
    protected void messageReceived(final ChannelHandlerContext channelHandlerContext, HttpJsonRequest httpRequest) throws Exception {
        HttpRequest request = httpRequest.getRequest();
        Account account = (Account) httpRequest.getBody();
        System.out.println(account+" from client");
        account.setEmail("server@trows.com");
        account.setTelephone("13579246810");

        ChannelFuture future = channelHandlerContext.writeAndFlush(new HttpJsonResponse(null, account));
        if (!HttpHeaders.isKeepAlive(request)) {
            future.addListener(new GenericFutureListener<Future<? super Void>>() {
                public void operationComplete(Future<? super Void> future) throws Exception {
                    channelHandlerContext.close();
                }
            });
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable throwable) throws Exception {


    }

}
