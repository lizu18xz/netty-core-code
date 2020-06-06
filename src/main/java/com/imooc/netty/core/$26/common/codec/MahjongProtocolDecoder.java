package com.imooc.netty.core.$26.common.codec;

import com.imooc.netty.core.$26.common.protocol.MahjongProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class MahjongProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        MahjongProtocol mahjongProtocol = new MahjongProtocol();
        mahjongProtocol.decode(msg);
        out.add(mahjongProtocol);
    }
}
