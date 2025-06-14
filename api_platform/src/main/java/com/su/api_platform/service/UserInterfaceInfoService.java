package com.su.api_platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.su.api_platform.model.entity.UserInterfaceInfo;

/**
* @author suhon
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2025-06-12 22:26:15
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * 校验
     *
     * @param userInterfaceInfo
     * @param add
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);
    boolean invokeCount(long interfaceInfoId,long userId);
}
