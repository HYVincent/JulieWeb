
package com.vincent.julie.netty;

import com.vincent.julie.dao.UserMapper;
import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
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

	private static NettyContextChannelMap instance;

	public static NettyContextChannelMap getInstance() {
		if(instance == null){
			instance = new NettyContextChannelMap();
		}
		return instance;
	}

	@Autowired
	private UserMapper userMapper;

	public static void add(String clientId, SocketChannel socketChannel) {
		map.put(clientId, socketChannel);
	}

	public static Channel get(String clientId) {
		return map.get(clientId);
	}

	public  void remove(SocketChannel socketChannel) {
		for (Map.Entry entry : map.entrySet()) {
			if (entry.getValue() == socketChannel) {
				String key = (String) entry.getKey();
				LOGGER.debug("通道" + key + "已被移除�?");
				map.remove(key);
				Map<String,Object> params = new HashMap<>();
				params.put("userLoginOutTime",System.currentTimeMillis());
				params.put("user_phone",key);
				userMapper.setLoginOutTime(params);
			}
		}
	}
}
