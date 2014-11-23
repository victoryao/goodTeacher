package com.goodteacher.im.student.bean;

import cn.bmob.v3.BmobObject;

/***
 * 银行卡信息，这个主要是给教师用的，学生版本暂时不需要
 * 当前版本是，每个老师绑定一张银行卡。
 * 
 * 老师的银行卡信息保存在这里，同时系统的银行卡也绑定在这个表，用户就是一个特殊的内置用户。
 * @author jfsys
 *
 */


public class BankCard extends BmobObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 银行卡号
     */
    private String cardNumber;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 户主账号中的真实姓名
     */
    private String realName;
    /**
     * 户主
     */
    private String userId;

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
   
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
}