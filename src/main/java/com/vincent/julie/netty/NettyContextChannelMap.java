
package com.vincent.julie.netty;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project: MyWebProject
 * @ClassName: NettyContextChannelMap
 * @Description: 存放已连接的用户信息
 * @author: chenpy
 * @version 1.0.0
 */
public class NettyContextChannelMap {

	private static final Logger LOGGER = LoggerFactory.getLogger(NettyContextChannelMap.class);
	private static Map<String, SocketChannel> map = new ConcurrentHashMap<>();

	public static void add(String clientId, SocketChannel socketChannel) {
		map.put(clientId, socketChannel);
	}

	public static Channel get(String clientId) {
		return map.get(clientId);
	}

	public static void remove(SocketChannel socketChannel) {
		for (Map.Entry entry : map.entrySet()) {
			if (entry.getValue() == socketChannel) {
				String key = (String) entry.getKey();
				LOGGER.debug("通道" + key + "已被移除�?");
				map.remove(key);
			}
		}
	}
}
