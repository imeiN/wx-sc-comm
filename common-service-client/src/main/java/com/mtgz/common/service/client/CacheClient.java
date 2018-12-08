package com.mtgz.common.service.client;

import com.mtgz.common.service.common.AppConstants;
import com.mtgz.common.service.common.entity.SysRegionEntity;
import com.mtgz.common.service.common.entity.SysSmsLogEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by linyisheng on 2018/11/19.
 */
@FeignClient(value = AppConstants.SERVICE_NAME)
public interface CacheClient {

    @PostMapping("/{cacheName}/{key}")
    void add(String cacheName, String key, Object value);

    @GetMapping("/{cacheName}/{key}")
    Object get(String cacheName, String key);

    @PostMapping("/-/{key}")
    void add(String key, Object value);

    @GetMapping("/-/{key}")
    Object get(String key);

    @DeleteMapping("/{cacheName}/{key}")
    Boolean remove(String cacheName, String key);
}
