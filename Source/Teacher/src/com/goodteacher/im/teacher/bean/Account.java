package com.goodteacher.im.teacher.bean;
import cn.bmob.v3.BmobObject;

/***
 * ѧ�����˻���Ϣ
 * @author jfsys
 *
 */
public class Account extends BmobObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Float amount; //��ֵ�������ѽ��
	private Boolean flag; //true����ֵ��false������
	private String 	userId;//�û�ID
	private Float newvalue; //�����˺����
	private Float oldvalue; //�ϴ��˺����
	
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
