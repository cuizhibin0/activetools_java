package com.pay.activetools.enums;

/***
 * CommonStatus.java
 *
 * @author shinelon
 *
 * @date 2017年11月2日
 *
 */
public enum CommonStatus  {
    // 有效
    AVAILABLE(1,"可用"),

    // 无效
    UNAVAILABLE(2,"禁用");

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    CommonStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static String getMsg(String code) {
        if (code != null) {
            for (CommonStatus enums : CommonStatus.values()) {
                if (enums.getCode().equals(code)) {
                    return enums.getMsg();
                }
            }
        }
        return "";
    }


}
