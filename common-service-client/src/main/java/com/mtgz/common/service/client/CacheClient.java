package com.mtgz.common.service.client;

import com.mtgz.common.service.common.CommonAppConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by linyisheng on 2018/11/19.
 */
@FeignClient(value = CommonAppConstants.SERVICE_NAME, path = CommonAppConstants.SERVICE_NAME + "/caches")
public interface CacheClient {

    @PostMapping("/{cacheName}/{key}")
    void add(@PathVariable("cacheName") String cacheName, @PathVariable("key") String key, Object value);

    @GetMapping("/{cacheName}/{key}")
    Object get(@PathVariable("cacheName") String cacheName, @PathVariable("key") String key);

    @PostMapping("/-/{key}")
    void add(@PathVariable("key") String key, Object value);

    @GetMapping("/-/{key}")
    Object get(@PathVariable("key") String key);

    @DeleteMapping("/{cacheName}/{key}")
    Boolean remove(@PathVariable("cacheName") String cacheName, @PathVariable("key") String key);
}
