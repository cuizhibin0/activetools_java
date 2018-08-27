package com.pay.activetools.bean;


import java.io.Serializable;
import java.math.BigDecimal;

public class ToolsCustomerCategoryBean implements Serializable {

    /**
     * 状态
     */
    private String status;
    /**
     * 商户类别名称
     */
    private String name;
    /**
     * mcc
     */
    private Integer mcc;
    /**
     * 下限金额
     */
    private BigDecimal lowAmount;
    /**
     * 上限金额
     */
    private BigDecimal hightAmount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
    }

    public BigDecimal getLowAmount() {
        return lowAmount;
    }

    public void setLowAmount(BigDecimal lowAmount) {
        this.lowAmount = lowAmount;
    }

    public BigDecimal getHightAmount() {
        return hightAmount;
    }

    public void setHightAmount(BigDecimal hightAmount) {
        this.hightAmount = hightAmount;
    }

    @Override
    public String toString() {
        return "ToolsCustomerCategoryBean{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", mcc=" + mcc +
                ", lowAmount=" + lowAmount +
                ", hightAmount=" + hightAmount +
                '}';
    }
}
