package com.mtgz.common.service.common.util;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:58<br>
 * 描述: ApiUserUtils <br>
 */
public class ApiUserUtils {

//    //替换字符串
//    public static String getCode(String APPID, String REDIRECT_URI, String SCOPE) {
//        return String.format(ResourceUtil.getConfigByName("wx.getCode"), APPID, REDIRECT_URI, SCOPE);
//    }

    //替换字符串
    public static String getWebAccess(String CODE,
                                      String webAccessTokenhttps,
                                      String appId,
                                      String secret) {
        return String.format(webAccessTokenhttps,
                appId,
                secret,
                CODE);
    }

//    //替换字符串
//    public static String getUserMessage(String access_token, String openid) {
//        return String.format(ResourceUtil.getConfigByName("wx.userMessage"), access_token, openid);
//    }
}