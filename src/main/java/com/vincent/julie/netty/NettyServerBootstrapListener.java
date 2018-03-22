package com.vincent.julie.netty;

import com.vincent.julie.config.Config;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Project: schoolmallapi
 * @ClassName: NettyServerBootstrap
 * @Description:netty服务�?
 * @author: chenpy
 * @version 1.0.0
 */
public class NettyServerBootstrapListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerBootstrapListener.class);

	@Override
    public void contextInitialized(ServletContextEvent sce) {
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(boss, worker);
		bootstrap.channel(NioServerSocketChannel.class);
		bootstrap.option(ChannelOption.SO_BACKLOG, 128);
		bootstrap.option(ChannelOption.TCP_NODELAY, true);
		bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

			@Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
				ChannelPipeline p = socketChannel.pipeline();
				p.addLast(new ObjectEncoder());
				p.addLast(new ObjectDecoder(1024 * 1024,
						ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
				p.addLast(new NettyServerHandler());
			}
		});

		ChannelFuture f;
		try {
			f = bootstrap.bind(Config.NETTY_PUSH_PORT).sync();
			if (f.isSuccess()) {
				LOGGER.debug("netty server start---------------");
				System.out.println("netty server start ------------");

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
    public void contextDestroyed(ServletContextEvent sce) {

	}
}
