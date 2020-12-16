package DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class Pet implements Serializable{
	private String petName; //���̸�
	private LocalDate enterDate; //�Խǳ�¥
	private LocalDate exitDate; //��ǳ�¥
	private int roomNum; //ȣ��
	public Pet(String petName, LocalDate enterDate, LocalDate exitdate, int roomNum) {
		this.petName = petName;
		this.enterDate = enterDate;
		this.exitDate = exitdate;
		this.roomNum = roomNum;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public LocalDate getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(LocalDate enterDate) {
		this.enterDate = enterDate;
	}
	public LocalDate getExitDate() {
		return exitDate;
	}
	public void setExitDate(LocalDate exitDate) {
		this.exitDate = exitDate;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	
}
