package com.vincent.julie.netty;



import com.vincent.julie.netty.msg.PushMsg;

import io.netty.channel.socket.SocketChannel;

/**
 * @Project: schoolmallapi
 * @ClassName: NettyPush
 * @Description: 
 * @author:	chenpy
 * @version 1.0.0
 */
public class NettyPush {
    /** 
      * @package com.sayimo.school.mall.push.netty
      * @author chenpy
      * @Title:  
      * @param
      * @throws 
      * @return void
      */
    public static void push(PushMsg pushMsg){
        SocketChannel channel = (SocketChannel) NettyContextChannelMap.get(pushMsg.getPhoneNum());
        if (channel != null) {
            channel.writeAndFlush(pushMsg);
        }
    }
}
