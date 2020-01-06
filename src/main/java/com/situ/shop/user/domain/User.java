package com.situ.shop.user.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.situ.shop.base.BaseClass;
@Alias("User")
public class User extends BaseClass implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer userClazz;//用户类型 0.商家 1.买家
	private String userName;//用户名称
	private String userCode;//用户账号
	private String userPass;//用户密码
	private Long userTlp;//用户手机
	private Integer lock;//是否锁定
	private String lastIp;//最后登陆的ip
	private Date lastTime;//最后的登陆时间
	public Integer getUserClazz() {
		return userClazz;
	}
	public void setUserClazz(Integer userClazz) {
		this.userClazz = userClazz;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Long getUserTlp() {
		return userTlp;
	}
	public void setUserTlp(Long userTlp) {
		this.userTlp = userTlp;
	}
	public Integer getPass() {
		return lock;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public Integer getLock() {
		return lock;
	}
	public void setLock(Integer lock) {
		this.lock = lock;
	}
	@Override
	public String toString() {
		return "User [userClazz=" + userClazz + ", userName=" + userName + ", userCode=" + userCode + ", userPass="
				+ userPass + ", userTlp=" + userTlp + ", lock=" + lock + ", lastIp=" + lastIp + ", lastTime=" + lastTime
				+ "]";
	}
	
}
