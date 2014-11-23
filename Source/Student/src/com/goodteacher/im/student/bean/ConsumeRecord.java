package com.goodteacher.im.student.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.*;

/***
 * ѧ�������Ѽ�¼�����Ѽ�¼��¼��ÿ��ͨ�������������
 * @author jfsys
 *
 */


public class ConsumeRecord extends BmobObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * ���ѽ��
     */
    private Float amount;
    /**
     * ͨ��ʱ��
     */
    private Integer length;
    /**
     * ������ID
     */
    private String userId;    
    /**
     * ��ʦID
     */    
    private String teacherId;
    
    /**
     * ͨ����ʼʱ��
     */
    private BmobDate beginTime;
    /**
     * ͨ������ʱ��
     */
    private BmobDate endTime;
    
    /**
     * �����Ǽ������5��
     */
    private Integer starlevel;
    /**
     * ��������
     */
    private String appraise;
    
    /**
     * ����������ʦ��ͨ������
     */
    
    private Float price;
    

	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	public BmobDate getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(BmobDate beginTime) {
		this.beginTime = beginTime;
	}
	public BmobDate getEndTime() {
		return endTime;
	}
	public void setEndTime(BmobDate endTime) {
		this.endTime = endTime;
	}
	public Integer getStarlevel() {
		return starlevel;
	}
	public void setStarlevel(Integer starlevel) {
		this.starlevel = starlevel;
	}
	public String getAppraise() {
		return appraise;
	}
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
}