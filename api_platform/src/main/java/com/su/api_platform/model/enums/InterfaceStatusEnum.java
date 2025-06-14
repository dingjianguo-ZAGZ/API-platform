package com.su.api_platform.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 接口状态美剧枚举
 */
public enum InterfaceStatusEnum {

    ONLINE("上线", 1),
    OFFLINE("关闭", 0),
    ;

    private final String text;
    private final int status;

    InterfaceStatusEnum(String text, int status) {
        this.text = text;
        this.status = status;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.status).collect(Collectors.toList());
    }

    /**
     * 根据 status 获取枚举
     *
     * @param status
     * @return
     */
    public static InterfaceStatusEnum getEnumByValue(int status) {
        if (ObjectUtils.isEmpty(status)) {
            return null;
        }
        for (InterfaceStatusEnum anEnum : InterfaceStatusEnum.values()) {
            if (anEnum.status == status) {
                return anEnum;
            }
        }
        return null;
    }

    public int getValue() {
        return status;
    }

    public String getText() {
        return text;
    }
}
