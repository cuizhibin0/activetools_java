package com.pay.activetools.bean;


import com.pay.activetools.enums.CodeEnum;

/**
 * @Description:
 * @Author: zhibin.cui
 * @Date: 下午6:12 2018/6/17
 */
public class JsonResultView<T> {

    /**
     * code
     */
    private String code = CodeEnum.SUCCESS.getCode();
    /**
     * 消息
     */
    private String msg = CodeEnum.SUCCESS.getMsg();

    /**
     * 这里存放返回的主要数据
     */
    private T object;


    public JsonResultView() {

    }

    public JsonResultView(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }

    public JsonResultView(String code) {
        this.code = code;

    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getObject() {
        return object;
    }


    public JsonResultView<T> setCode(String code) {
        this.code = code;

        return this;
    }

    public JsonResultView<T> setMsg(String msg) {
        this.msg = msg;

        return this;
    }

    public JsonResultView<T> setObject(T object) {
        this.object = object;

        return this;
    }


}
