package com.situ.shop.list.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.shop.base.BaseClass;

@Alias("Lists")
public class Lists extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	 private String listName;
	 private Integer activeFlag;
	 private Long parentListIp;
	 private Integer listGroup;
	 private String listInfo;
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Integer getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Long getParentListIp() {
		return parentListIp;
	}
	public void setParentListIp(Long parentListIp) {
		this.parentListIp = parentListIp;
	}
	public String getListInfo() {
		return listInfo;
	}
	public void setListInfo(String listInfo) {
		this.listInfo = listInfo;
	}
	
	
	public Integer getListGroup() {
		return listGroup;
	}
	public void setListGroup(Integer listGroup) {
		this.listGroup = listGroup;
	}
	@Override
	public String toString() {
		return "Lists [listName=" + listName + ", activeFlag=" + activeFlag + ", parentListIp=" + parentListIp
				+ ", listGroup=" + listGroup + ", listInfo=" + listInfo + "]";
	}
	
	
	 
}
