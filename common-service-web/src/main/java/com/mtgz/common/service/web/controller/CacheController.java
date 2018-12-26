package com.mtgz.common.service.web.controller;

import com.mtgz.common.service.common.CommonAppConstants;
import com.mtgz.common.service.web.cache.J2CacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by linyisheng on 2018/11/19.
 */
@Slf4j
@RestController
@RequestMapping(value = CommonAppConstants.BASE_PATH + "/caches")
public class CacheController {

    @PostMapping("/{cacheName}/{key}")
    public void add(String cacheName, String key, Object value) {
        J2CacheUtils.put(cacheName, key, value);
    }

    @GetMapping("/{cacheName}/{key}")
    public Object get(String cacheName, String key) {
        return J2CacheUtils.get(cacheName, key);
    }

    @PostMapping("/-/{key}")
    public void add(String key, Object value) {
        J2CacheUtils.put(key, value);
    }

    @GetMapping("/-/{key}")
    public Object get(String key) {
        return J2CacheUtils.get(key);
    }

}
