package com.goodteacher.im.teacher.bean;
import cn.bmob.v3.BmobObject;

/***
 * 学生的账户信息
 * @author jfsys
 *
 */
public class Account extends BmobObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Float amount; //充值或者消费金额
	private Boolean flag; //true：充值，false：消费
	private String 	userId;//用户ID
	private Float newvalue; //最新账号余额
	private Float oldvalue; //上次账号余额
	
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public Float getNewvalue() {
		return newvalue;
	}
	public void setNewvalue(Float newvalue) {
		this.newvalue = newvalue;
	}
	public Float getOldvalue() {
		return oldvalue;
	}
	public void setOldvalue(Float oldvalue) {
		this.oldvalue = oldvalue;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
