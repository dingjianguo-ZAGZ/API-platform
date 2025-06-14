package com.su.api_platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.su.api_platform.model.entity.InterfaceInfo;

/**
 * 帖子服务
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);


}
