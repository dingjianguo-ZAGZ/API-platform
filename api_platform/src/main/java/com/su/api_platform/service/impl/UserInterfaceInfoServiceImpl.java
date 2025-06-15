package com.su.api_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.su.api_platform.common.ErrorCode;
import com.su.api_platform.exception.BusinessException;
import com.su.api_platform.mapper.UserInterfaceInfoMapper;
import com.su.api_platform.model.entity.InterfaceInfo;
import com.su.api_platform.model.entity.UserInterfaceInfo;
import com.su.api_platform.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

/**
* @author suhon
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2025-06-12 22:26:15
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo> implements UserInterfaceInfoService {
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        if (userInterfaceInfo.getInterfaceInfoId() < 0 || userInterfaceInfo.getUserId() < 0 ) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口不存在");
        }
        // 有参数则校验
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于0 ");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //判断
        if(interfaceInfoId <= 0 || userId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId",userId);
        updateWrapper.setSql("totalNum = totalNum + 1,leftNum = leftNum - 1");
        boolean update = update(updateWrapper);
        return update;

    }
}




