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
@FeignClient(value = AppConstants.SERVICE_NAME, path = AppConstants.SERVICE_NAME + "/sys")
public interface CommonClient {

    @GetMapping(path = "/region")
    List<SysRegionEntity> getRegionList();

    @PostMapping(path = "/sendSms")
    SysSmsLogEntity sendSms(@RequestBody SysSmsLogEntity smsLog);

    //RegionCacheUtil
    @GetMapping(path = "/getChildrenByParentId")
    List<SysRegionEntity> getChildrenByParentId(@RequestParam("parentId")Integer parentId);


    @GetMapping(path = "/getAllProvice")
    List<SysRegionEntity> getAllProvice();


    @GetMapping(path = "/getChildrenCity")
    List<SysRegionEntity> getChildrenCity(@RequestParam("proviceName") String proviceName);


    @GetMapping(path = "/getChildrenDistrict")
    List<SysRegionEntity> getChildrenDistrict(@RequestParam("proviceName")String proviceName,
                                              @RequestParam("cityName")String cityName);


    @GetMapping(path = "/getAreaByAreaId")
    SysRegionEntity getAreaByAreaId(@RequestParam("regionId")Integer regionId);


    @GetMapping(path = "/getProvinceIdByName")
    Integer getProvinceIdByName(@RequestParam("provinceName") String provinceName);

    @GetMapping(path = "/getCityIdByName")
    Integer getCityIdByName(@RequestParam("provinceId")Integer provinceId,
                            @RequestParam("cityName")String cityName);


    @GetMapping(path = "/getDistrictIdByName")
    Integer getDistrictIdByName(@RequestParam("provinceId") Integer provinceId,
                                @RequestParam("cityId")Integer cityId,
                                @RequestParam("districtName")String districtName);
}
