package DTO;

import java.io.Serializable;
import java.util.HashSet;

public class Customer implements Serializable{//��
	private int password; //4�ڸ� ��й�ȣ
	private HashSet<Pet> pet = new HashSet<>(); //���� �� set
	private HashSet<Pet> exitPet = new HashSet<>(); //����� ��
	
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public HashSet<Pet> getPet() {
		return pet;
	}
	public void setPet(HashSet<Pet> pet) {
		this.pet = pet;
	}
	public HashSet<Pet> getExitPet() {
		return exitPet;
	}
	public void setExitPet(HashSet<Pet> exitPet) {
		this.exitPet = exitPet;
	}
	
}
