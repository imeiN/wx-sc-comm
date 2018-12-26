package com.mtgz.common.service.web.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigure {
    public static int connectTimeOutMillis = 12000;
    public static int readTimeOutMillis = 12000;
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    @Bean
    public Producer producer() {
        return new DefaultKaptcha();
    }
}
