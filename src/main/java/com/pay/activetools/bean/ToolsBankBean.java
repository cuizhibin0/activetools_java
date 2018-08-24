package com.pay.activetools.bean;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

public class ToolsBankBean implements Serializable {

    private Long id;
    /**
     * status
     */
    private String status;
    /**
     * 银行简称
     */
    private String bankCode;
    /**
     * 名称
     */
    private String name;
    /**
     * 简称
     */
    @TableField("short_name")
    private String shortName;
    /**
     * 银行logo图片地址
     */
    private String logo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "ToolsBankBean{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
