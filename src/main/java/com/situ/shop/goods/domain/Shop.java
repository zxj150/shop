package com.situ.shop.goods.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.situ.shop.base.BaseClass;
@Alias("Shop")
public class Shop extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long listId;//目录id
	private String shopName;//商品名称
	private Long shopCode;//商品编号
	private CommonsMultipartFile shopPictureFile;//商品图片
	private String shopPicture;
	public CommonsMultipartFile getShopPictureFile() {
		return shopPictureFile;
	}
	public void setShopPictureFile(CommonsMultipartFile shopPictureFile) {
		this.shopPictureFile = shopPictureFile;
	}
	public String getShopPicture() {
		return shopPicture;
	}
	public void setShopPicture(String shopPicture) {
		this.shopPicture = shopPicture;
	}
	private Float shopPrice;//商品价格
	private Long shopNumber;//商品库存数量
	private Integer shopState;//商品上下架状态1.商家 0 。下架
	private String shopInfo;//商品介绍
	
	public Long getListId() {
		return listId;
	}
	public void setListId(Long listId) {
		this.listId = listId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Long getShopCode() {
		return shopCode;
	}
	public void setShopCode(Long shopCode) {
		this.shopCode = shopCode;
	}
	public Float getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(Float shopPrice) {
		this.shopPrice = shopPrice;
	}
	public Long getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(Long shopNumber) {
		this.shopNumber = shopNumber;
	}
	public Integer getShopState() {
		return shopState;
	}
	public void setShopState(Integer shopState) {
		this.shopState = shopState;
	}
	public String getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(String shopInfo) {
		this.shopInfo = shopInfo;
	}
	
}
