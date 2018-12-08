package com.mtgz.common.service.client;

import com.mtgz.common.service.common.AppConstants;
import com.mtgz.common.service.common.entity.SmsConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by linyisheng on 2018/11/19.
 */
@FeignClient(value = AppConstants.SERVICE_NAME + "/sys")
public interface SysClient {

    @GetMapping("/getConfigObject")
    SmsConfig getConfigObject(@RequestParam("smsConfigKey") String smsConfigKey,
                              @RequestParam("smsConfigClass") Class<SmsConfig> smsConfigClass);
}
