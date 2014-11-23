package com.goodteacher.im.student.bean;

import cn.bmob.v3.BmobObject;

/***
 * ���п���Ϣ�������Ҫ�Ǹ���ʦ�õģ�ѧ���汾��ʱ����Ҫ
 * ��ǰ�汾�ǣ�ÿ����ʦ��һ�����п���
 * 
 * ��ʦ�����п���Ϣ���������ͬʱϵͳ�����п�Ҳ����������û�����һ������������û���
 * @author jfsys
 *
 */


public class BankCard extends BmobObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * ���п���
     */
    private String cardNumber;
    /**
     * ��������
     */
    private String bankName;
    /**
     * �����˺��е���ʵ����
     */
    private String realName;
    /**
     * ����
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