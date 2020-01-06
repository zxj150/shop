package com.situ.shop.address.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.shop.base.BaseClass;
@Alias("Address")
public class Address extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userid;//用户id
	private Long provinceCode;//省code
	private Long cityCode;//市code
	private Long districtCode;//区code
	private String detailedAddress;//详细地址
	private Long zipCode;//邮编
	private Long consigneeTlp;//收货人电话
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Long getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(Long provinceCode) {
		this.provinceCode = provinceCode;
	}
	public Long getCityCode() {
		return cityCode;
	}
	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}
	public Long getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(Long districtCode) {
		this.districtCode = districtCode;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public Long getConsigneeTlp() {
		return consigneeTlp;
	}
	public void setConsigneeTlp(Long consigneeTlp) {
		this.consigneeTlp = consigneeTlp;
	}
	
	
}
