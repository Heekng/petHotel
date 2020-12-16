package DTO;

import java.io.Serializable;

public class Day implements Serializable{ //날짜의 방정보
	private boolean roomArr[][] = new boolean[5][5]; //해당날짜의 방 예약되면 true
	
	public Day() {
		
	}
	public boolean[][] getRoomArr() {
		return roomArr;
	}
	public void setRoomArr(boolean[][] roomArr) {
		this.roomArr = roomArr;
	}
	
}
