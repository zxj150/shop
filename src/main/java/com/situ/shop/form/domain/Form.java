package com.situ.shop.form.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.shop.base.BaseClass;
@Alias("Form")
public class Form extends BaseClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long formNumber;//订单编号
	private Long  userId;//用户id
	private Float allPrice;//总价格
	private Long addressId;//收货地址id
	private Integer condition;//订单状态
	private Integer payWay;//支付方式1.支付宝 2.微信
	public Long getFormNumber() {
		return formNumber;
	}
	public void setFormNumber(Long formNumber) {
		this.formNumber = formNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Float getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(Float allPrice) {
		this.allPrice = allPrice;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public Integer getCondition() {
		return condition;
	}
	public void setCondition(Integer condition) {
		this.condition = condition;
	}
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	
	
}
