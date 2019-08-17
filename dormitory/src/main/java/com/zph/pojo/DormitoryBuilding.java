package com.zph.pojo;

public class DormitoryBuilding {
	private int id;
	private String name;
	//总房间数
	private int roomNumber;
	//剩余可住房间数
	private int surplusRooms;
	//宿舍楼栋类型：0为男生宿舍，1为女生宿舍，2为教职工宿舍
	private int type;
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
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getSurplusRooms() {
		return surplusRooms;
	}
	public void setSurplusRooms(int surplusRooms) {
		this.surplusRooms = surplusRooms;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}