package com.goodteacher.im.teacher.bean;

import cn.bmob.v3.BmobObject;

/**
 * ѧ���ĳ�ֵ��¼
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
     * ��ֵ���
     */
    private float amount;
   
    /**
     * ��ֵ�û�
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