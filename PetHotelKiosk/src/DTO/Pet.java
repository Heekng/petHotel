package DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class Pet implements Serializable{
	private String petName; //펫이름
	private LocalDate enterDate; //입실날짜
	private LocalDate exitDate; //퇴실날짜
	private int roomNum; //호수
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
