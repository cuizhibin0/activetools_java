package com.pay.activetools.enums;

/***
 * CommonStatus.java
 *
 * @author shinelon
 *
 * @date 2017年11月2日
 *
 */
public enum CommonStatus {
    // 有效
    AVAILABLE(1),

    // 无效
    UNAVAILABLE(0);

    private Integer value;

    CommonStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
