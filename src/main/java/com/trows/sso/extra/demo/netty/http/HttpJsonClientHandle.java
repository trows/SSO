package com.trows.sso.extra.demo.netty.http;

import com.trows.sso.model.Account;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by pengruoying on 2017/4/20.
 * HttpJsonClientHandle
 */
public class HttpJsonClientHandle extends SimpleChannelInboundHandler<HttpJsonResponse> {

    private static final Logger logger = LogManager.getLogger(HttpJsonClientHandle.class);

    @Override
    public void channelActive(ChannelHandlerContext context) {
        Account account = new Account();
        account.setId(System.currentTimeMillis());
        account.setUserName("trows");
        HttpJsonRequest request = new HttpJsonRequest(null, account);
        context.writeAndFlush(request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable throwable) {
        logger.error(throwable);
        context.close();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, HttpJsonResponse httpJsonResponse) throws Exception {
        System.out.println("The client receive response of http header is : " + httpJsonResponse.getResponse().headers().names());
        System.out.println("The client receive response of http body is : " + httpJsonResponse.getResult());
    }
}
