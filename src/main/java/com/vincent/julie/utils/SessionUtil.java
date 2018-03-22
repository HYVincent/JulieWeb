package com.vincent.julie.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name JulieWeb
 * @page com.vincent.julie.utils
 * @class describe
 * @date 2018/3/21 10:47
 */


public class SessionUtil {

    /**
     * 存放所有用户的session
     */
    private static Map<String,HttpSession> sessionMap = new HashMap<>();

    /**
     * 添加session
     * @param sessidId
     * @param session
     */
    public static void addSession(String sessidId,HttpSession session){
        sessionMap.put(sessidId,session);
    }

    /**
     * 移除sessionId
     * @param sessidId
     */
    public static void removeSession(String sessidId){
        sessionMap.remove(sessidId);
    }

}
