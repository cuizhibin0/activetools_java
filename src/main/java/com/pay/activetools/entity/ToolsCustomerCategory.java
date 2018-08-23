package com.pay.activetools.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 商户类别表
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
@TableName("tools_customer_category")
public class ToolsCustomerCategory extends Model<ToolsCustomerCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 状态 0：删除，1：有效
     */
	private Integer status;
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
	@TableField("low_amount")
	private BigDecimal lowAmount;
    /**
     * 上限金额
     */
	@TableField("hight_amount")
	private BigDecimal hightAmount;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 最后修改时间
     */
	@TableField("update_time")
	private Date updateTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ToolsCustomerCategory{" +
			"id=" + id +
			", status=" + status +
			", name=" + name +
			", mcc=" + mcc +
			", lowAmount=" + lowAmount +
			", hightAmount=" + hightAmount +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
