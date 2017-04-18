package com.trows.sso.extra.demo.netty.http;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by pengruoying on 2017/4/18.
 * HttpJsonRequest
 */
public class HttpJsonRequest {

    private FullHttpRequest request;
    private Object body;

    public HttpJsonRequest(FullHttpRequest request, Object body) {
        this.request = request;
        this.body = body;
    }

    public final FullHttpRequest getRequest() {
        return request;
    }

    public final void setRequest(FullHttpRequest request) {
        this.request = request;
    }

    public final Object getBody() {
        return body;
    }

    public final void setBody(Object body) {
        this.body = body;
    }
}
