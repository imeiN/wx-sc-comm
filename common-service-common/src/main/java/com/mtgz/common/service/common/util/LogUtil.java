package com.mtgz.common.service.common.util;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * log日志辅助类
 * Created by @author changsheng on 2017/11/11.
 */
public class LogUtil {

    private LogUtil() {
    }

    static LogUtil instanced;

    static {
        instanced = new LogUtil();
    }


    private static final String LOG_UUID = "LOG_UUID";

    private InheritableThreadLocal<Map<String, String>> inheritableThreadLocal = new InheritableThreadLocal<Map<String, String>>() {
        protected Map<String, String> childValue(Map<String, String> parentValue) {
            return parentValue == null ? null : new HashMap(parentValue);
        }
    };

    private void put(String key, String val) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        } else {
            Map<String, String> map = (Map) this.inheritableThreadLocal.get();
            if (map == null) {
                map = new HashMap();
                this.inheritableThreadLocal.set(map);
            }

            ((Map) map).put(key, val);
        }
    }


    private String get(String key) {
        Map<String, String> map = (Map) this.inheritableThreadLocal.get();
        if (map == null) {
            map = new HashMap();
            this.inheritableThreadLocal.set(map);
        }
        return map.get(key);
    }

    /**
     * 更新日志跟踪id
     *
     * @param logID 日志跟踪id(为空时创建新日志跟踪id)
     */
    public String updateLogId(String logID) {
        if (null == logID || "".equals(logID)) {
            logID = createLogId();
            put(LOG_UUID, logID);
        } else {
            put(LOG_UUID, logID);
        }
        return logID;
    }

    /**
     * 创建日志跟踪id
     *
     * @return 日志跟踪id
     */
    public String createLogId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取日志跟踪id
     *
     * @return 日志跟踪id
     */
    public static String getLogId() {


        Object object = instanced.get(LOG_UUID);
        return instanced.updateLogId(object == null ? "" : object.toString());
    }
}
