package com.vincent.julie.netty;

import com.vincent.julie.netty.msg.*;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Project: schoolmallapi
 * @ClassName: NettyServerHandler
 * @Description: 客户端消息处�?
 * @author:	chenpy
 * @date:	2016�?11�?1�?
 * @version 1.0.0
 */
@Sharable
public class NettyServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerHandler.class);

	@Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		NettyContextChannelMap.remove((SocketChannel) ctx.channel());
	}

	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LOGGER.error("服务器异常");
	}

	protected void messageReceived(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
		LOGGER.debug( "messageReceived");
		if (MsgType.LOGIN.equals(baseMsg.getType())) {
			LoginMsg loginMsg = (LoginMsg) baseMsg;
			if (NettyContextChannelMap.get(loginMsg.getPhoneNum()) == null) {
				NettyContextChannelMap.add(loginMsg.getPhoneNum(), (SocketChannel) channelHandlerContext.channel());
				LOGGER.debug( "client"+loginMsg.getPhoneNum()+" 登录");
			}
		} else {
			if (NettyContextChannelMap.get(baseMsg.getPhoneNum()) == null) {
				LoginMsg loginMsg = new LoginMsg();
				channelHandlerContext.channel().writeAndFlush(loginMsg);
			}
		}
		
		switch (baseMsg.getType()) {
			case PING:
				PingMsg pingMsg = (PingMsg) baseMsg;
				PingMsg replyPing = new PingMsg();
				NettyContextChannelMap.get(pingMsg.getPhoneNum()).writeAndFlush(replyPing);
				LOGGER.debug( "�յ�PING����");
				break;
			case LOGIN:
				break;
			case PUSH:
				PushMsg pushMsg = (PushMsg) baseMsg;
                LOGGER.debug( "phoneNum = " + pushMsg.getPhoneNum() + ", content = " + pushMsg.getContent());
				break;
			default:
                LOGGER.debug( "Default");
				break;
		}
		ReferenceCountUtil.release(baseMsg);
	}
	
	
	@Override
	public void channelRead(ChannelHandlerContext arg0, Object arg1) throws Exception {
		BaseMsg baseMsg = (BaseMsg) arg1;
        LOGGER.debug("baseMsg-->"+baseMsg);
		channelRead0(arg0, baseMsg);
		super.channelRead(arg0, arg1);
	}
	

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
		if (MsgType.LOGIN.equals(baseMsg.getType())) {
			LoginMsg loginMsg = (LoginMsg) baseMsg;
			if (NettyContextChannelMap.get(loginMsg.getPhoneNum()) == null) {
				NettyContextChannelMap.add(loginMsg.getPhoneNum(), (SocketChannel) channelHandlerContext.channel());
                LOGGER.debug( "client" + loginMsg.getPhoneNum() + " login");
			}
		} else {
			if (NettyContextChannelMap.get(baseMsg.getPhoneNum()) == null) {
				LoginMsg loginMsg = new LoginMsg();
				channelHandlerContext.channel().writeAndFlush(loginMsg);
			}
		}
		
		switch (baseMsg.getType()) {
			case PING:
				PingMsg pingMsg = (PingMsg) baseMsg;
				PingMsg replyPing = new PingMsg();
				NettyContextChannelMap.get(pingMsg.getPhoneNum()).writeAndFlush(replyPing);
                LOGGER.debug( "ping心跳");
				break;
			case LOGIN:
				LoginMsg login = (LoginMsg) baseMsg;
                LOGGER.debug("login: {}", login);
				break;
			case PUSH:
				PushMsg pushMsg = (PushMsg) baseMsg;
                LOGGER.debug( "phoneNum = " + pushMsg.getPhoneNum() + ", content = " + pushMsg.getContent());
				break;
			default:
                LOGGER.debug( "Default");
				break;
		}
		ReferenceCountUtil.release(baseMsg);
		
	}
}