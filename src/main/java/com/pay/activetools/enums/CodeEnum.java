package com.pay.activetools.enums;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description:
 * @Author: zhibin.cui
 * @Date: 下午6:10 2018/6/17
 */
public enum CodeEnum {

    SUCCESS("0000", "操作成功"),
    FAIL("0001", "操作失败");

    private String code;

    private String msg;

    private CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }



    public JSONObject getJsonMsg() {
        String resultMsg = "{\"code\":\"%s\",\"msg\":\"%s\"}";
        return JSONObject.parseObject(String.format(resultMsg, code, msg));
    }
}
