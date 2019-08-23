package com.zph.pojo;

import java.util.List;

public class Dormitory {
	private int id;
	private int bid;
	private String name;
	//剩余可住房间数，默认学生为4，教职工为1
	private int surplusBed;
	//所属楼栋
	private DormitoryBuilding dormitoryBuilding;
	//入住学生
	private List<Student> students;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSurplusBed() {
		return surplusBed;
	}
	public void setSurplusBed(int surplusBed) {
		this.surplusBed = surplusBed;
	}
	public DormitoryBuilding getDormitoryBuilding() {
		return dormitoryBuilding;
	}
	public void setDormitoryBuilding(DormitoryBuilding dormitoryBuilding) {
		this.dormitoryBuilding = dormitoryBuilding;
	}
	
}
