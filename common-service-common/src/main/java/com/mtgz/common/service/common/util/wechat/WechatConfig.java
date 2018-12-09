package com.mtgz.common.service.common.util.wechat;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.security.KeyStore;

@SuppressWarnings("deprecation")
public class WechatConfig {

    private static SSLConnectionSocketFactory sslcsf;

    public static SSLConnectionSocketFactory getSslcsf(String certName, String mchId) {
        if (null == sslcsf) {
            setSsslcsf(certName, mchId);
        }
        return sslcsf;
    }

    private static void setSsslcsf(String certName, String mchId) {
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            Thread.currentThread().getContextClassLoader();
            InputStream instream = new WechatRefundApiResult().getClass().getResourceAsStream(certName);
            try {
                keyStore.load(instream, mchId.toCharArray());
            } finally {
                instream.close();
            }
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mchId.toCharArray()).build();
            sslcsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
