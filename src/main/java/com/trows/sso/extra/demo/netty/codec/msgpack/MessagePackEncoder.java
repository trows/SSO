package com.trows.sso.extra.demo.netty.codec.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;


/**
 * Created by pengruoying on 2017/4/15.
 * MessagePack编码
 */
public class MessagePackEncoder extends MessageToByteEncoder<Object>{

    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        System.out.println("编码被调用");
        MessagePack messagePack = new MessagePack();
        byteBuf.writeBytes(messagePack.write(o));
    }
}
