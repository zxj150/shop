package com.situ.shop.user.domain;

import java.io.Serializable;

import com.situ.shop.base.BaseClass;

public class ShoppingCart extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long userId;//用户id
	private Long shopNumber;//商品编号
	private Long shopCount;//购买数量
	private Float shopAllPrice;//商品总价
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(Long shopNumber) {
		this.shopNumber = shopNumber;
	}
	public Long getShopCount() {
		return shopCount;
	}
	public void setShopCount(Long shopCount) {
		this.shopCount = shopCount;
	}
	public Float getShopAllPrice() {
		return shopAllPrice;
	}
	public void setShopAllPrice(Float shopAllPrice) {
		this.shopAllPrice = shopAllPrice;
	}

}
