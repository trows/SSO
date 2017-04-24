package com.trows.sso.extra.demo.netty.http;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * Created by pengruoying on 2017/4/19.
 * HttpJsonResponse
 */
public class HttpJsonResponse {
    private FullHttpResponse response;
    private Object result;

    public HttpJsonResponse(FullHttpResponse response, Object result) {
        this.response = response;
        this.result = result;
    }

    public final FullHttpResponse getResponse() {
        return response;
    }

    public final void setResponse(FullHttpResponse response) {
        this.response = response;
    }

    public final Object getResult() {
        return result;
    }

    public final void setResult(Object result) {
        this.result = result;
    }
}
