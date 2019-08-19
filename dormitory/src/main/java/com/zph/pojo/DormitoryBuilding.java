package com.zph.pojo;

import java.util.List;

public class DormitoryBuilding {
	private int id;
	private String name;
	//每层房间数
	private int layerRoomNumber;
	//剩余可住房间数
	private int surplusRoom;
	//宿舍楼栋类型：0为男生宿舍，1为女生宿舍，2为教职工宿舍
	private int type;
	//层数
	private int layerNumber;
	//区数
	private int areaNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSurplusRoom() {
		return surplusRoom;
	}
	public void setSurplusRoom(int surplusRoom) {
		this.surplusRoom = surplusRoom;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLayerRoomNumber() {
		return layerRoomNumber;
	}
	public void setLayerRoomNumber(int layerRoomNumber) {
		this.layerRoomNumber = layerRoomNumber;
	}
	public int getLayerNumber() {
		return layerNumber;
	}
	public void setLayerNumber(int layerNumber) {
		this.layerNumber = layerNumber;
	}
	public int getAreaNumber() {
		return areaNumber;
	}
	public void setAreaNumber(int areaNumber) {
		this.areaNumber = areaNumber;
	}
	
}