package com.pay.activetools.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 工具银行表
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
@TableName("tools_bank")
public class ToolsBank extends Model<ToolsBank> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * status
     */
	private Integer status;
    /**
     * create_date
     */
	@TableField("create_date")
	private Date createDate;
    /**
     * update_date
     */
	@TableField("update_date")
	private Date updateDate;
    /**
     * 银行简拼
     */
	@TableField("bank_code")
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ToolsBank{" +
			"id=" + id +
			", status=" + status +
			", createDate=" + createDate +
			", updateDate=" + updateDate +
			", bankCode=" + bankCode +
			", name=" + name +
			", shortName=" + shortName +
			", logo=" + logo +
			"}";
	}
}
