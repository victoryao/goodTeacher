package com.goodteacher.im.teacher.bean;

import cn.bmob.v3.BmobObject;

/**
 * 学生的充值记录
 * 
 * @author jfsys
 *
 */
public class RechargeRecord extends BmobObject {
   
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 充值金额
     */
    private float amount;
   
    /**
     * 充值用户
     */
    private String userId;

  
   
   
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}