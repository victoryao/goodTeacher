package com.goodteacher.im.student.bean;

import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.datatype.BmobRelation;


/** 重载BmobChatUser对象：若还有其他需要增加的属性可在此添加
  * @ClassName: TextUser
  * @Description: TODO
  * @author smile
  * @date 2014-5-29 下午6:15:45
  */
public class User extends BmobChatUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * //显示数据拼音的首字母
	 */
	private String sortLetters;
	
	/**
	 * //性别-true-男
	 */
	private boolean sex; //性别
	
	private BmobRelation blogs;
		
	private String lang; //对外教是母语，对学生是想学习的语言
	
	private String phone;//电话号码
	
	private Integer age; //年龄，暂时先简单填写一个年龄字段，将来考虑用出生日期进行计算
	
	
	private String nationality;//国籍
	
	private String city;//当前居住城市，对于外教是指在中国的居住城市
	
	private String school;//外教或者学生当前在中国就读的学校。
	
	private String role;
	
	/**
	 * 是否是老师
	 */
	private boolean isTeacher;
	
	/**
	 * 地理坐标
	 */
	private BmobGeoPoint location;//
	
	
	
	public BmobRelation getBlogs() {
		return blogs;
	}
	public void setBlogs(BmobRelation blogs) {
		this.blogs = blogs;
	}
	public BmobGeoPoint getLocation() {
		return location;
	}
	public void setLocation(BmobGeoPoint location) {
		this.location = location;
	}
	public boolean getSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getSortLetters() {
		return sortLetters;
	}
	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isTeacher() {
		return isTeacher;
	}
	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
