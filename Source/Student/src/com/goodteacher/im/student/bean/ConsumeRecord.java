package com.goodteacher.im.student.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.*;

/***
 * 学生的消费记录，消费记录记录了每次通话的消费情况。
 * @author jfsys
 *
 */


public class ConsumeRecord extends BmobObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 消费金额
     */
    private Float amount;
    /**
     * 通话时长
     */
    private Integer length;
    /**
     * 消费者ID
     */
    private String userId;    
    /**
     * 老师ID
     */    
    private String teacherId;
    
    /**
     * 通话开始时间
     */
    private BmobDate beginTime;
    /**
     * 通话结束时间
     */
    private BmobDate endTime;
    
    /**
     * 评价星级，最高5星
     */
    private Integer starlevel;
    /**
     * 评价内容
     */
    private String appraise;
    
    /**
     * 本次消费老师的通话单价
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