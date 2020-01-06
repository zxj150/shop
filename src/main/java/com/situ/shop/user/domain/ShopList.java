package com.situ.shop.user.domain;

import java.io.Serializable;

import com.situ.shop.base.BaseClass;

public class ShopList extends BaseClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long rowId;
	private String listName;//目录名称
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}

}
