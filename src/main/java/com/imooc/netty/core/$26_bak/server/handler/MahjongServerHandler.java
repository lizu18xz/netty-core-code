package com.imooc.netty.core.$26_bak.server.handler;

import com.alibaba.fastjson.JSON;
import com.imooc.netty.core.$26_bak.common.protocol.Request;
import com.imooc.netty.core.$26_bak.common.protocol.Response;
import com.imooc.netty.core.$26_bak.common.protocol.mahjong.RequestMahjongProtocol;
import com.imooc.netty.core.$26_bak.common.protocol.mahjong.ResponseMahjongProtocol;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 业务逻辑处理器
 */
@Slf4j
@Sharable
public class MahjongServerHandler extends SimpleChannelInboundHandler<RequestMahjongProtocol> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMahjongProtocol msg) throws Exception {
        Request request = msg.getBody();
        Response response = request.operate();

        ResponseMahjongProtocol responseMahjongProtocol = new ResponseMahjongProtocol();
        responseMahjongProtocol.setHeader(msg.getHeader());
        responseMahjongProtocol.setBody(response);

        System.out.println("receive request: " + JSON.toJSONString(msg));

        System.out.println("send response: " + JSON.toJSONString(responseMahjongProtocol));

        if (ctx.channel().isActive() && ctx.channel().isWritable()) {
            ctx.writeAndFlush(responseMahjongProtocol);
        } else {
            log.error("channel not available, drop msg, msg={}", JSON.toJSONString(responseMahjongProtocol));
        }

    }
}
