package DTO;

import java.io.Serializable;

public class Day implements Serializable{ //��¥�� ������
	private boolean roomArr[][] = new boolean[5][5]; //�ش糯¥�� �� ����Ǹ� true
	
	public Day() {
		
	}
	public boolean[][] getRoomArr() {
		return roomArr;
	}
	public void setRoomArr(boolean[][] roomArr) {
		this.roomArr = roomArr;
	}
	
}
