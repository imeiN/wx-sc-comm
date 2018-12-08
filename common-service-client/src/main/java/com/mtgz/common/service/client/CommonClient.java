package com.mtgz.common.service.client;

import com.mtgz.common.service.common.AppConstants;
import com.mtgz.common.service.common.entity.SysRegionEntity;
import com.mtgz.common.service.common.entity.SysSmsLogEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by linyisheng on 2018/11/19.
 */
@FeignClient(value = AppConstants.SERVICE_NAME)
public interface CommonClient {

    @RequestMapping(path = AppConstants.BASE_PATH + "/region", method = RequestMethod.POST)
    List<SysRegionEntity> getRegionList();

    @RequestMapping(path = AppConstants.BASE_PATH + "/sendSms", method = RequestMethod.POST)
    SysSmsLogEntity sendSms(SysSmsLogEntity smsLog);

    //RegionCacheUtil
    List<SysRegionEntity> getChildrenByParentId(Integer parentId);

    List<SysRegionEntity> getAllProvice();

    List<SysRegionEntity> getChildrenCity(String proviceName);

    List<SysRegionEntity> getChildrenDistrict(String proviceName, String cityName);

    SysRegionEntity getAreaByAreaId(Integer regionId);

    Integer getProvinceIdByName(String provinceName);

    Integer getCityIdByName(Integer provinceId, String cityName);

    Integer getDistrictIdByName(Integer provinceId, Integer cityId, String districtName);
}
