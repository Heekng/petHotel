package p01;

import java.awt.Font;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.OptionPaneUI;

class Pet implements Serializable {
	String petName;
	String userName;
	String userNumber;
	Calendar date;
	Pet(String petName, String userName, String userNumber, Calendar date) {
		this.petName = petName;
		this.userName = userName;
		this.userNumber = userNumber;
		this.date = date;
	}
}
public class petHotel{
	public static HashSet<Pet> petSet = new HashSet<>();
	static SimpleDateFormat simpleD = new SimpleDateFormat("yy/MM/dd");
	static Font myFont = new Font("맑은 고딕", Font.PLAIN, 14);
	static void regist() {//펫 등록
		UIManager.put("OptionPane.messageFont", myFont);
		String petName, userName, userNumber, exDate;
		petName = JOptionPane.showInputDialog("-----------신규 이용자 정보 등록-----------\n펫 이름을 입력해주세요.");
//		petName = JOptionPane.showInputDialog(null, "펫 이름을 입력해주세요.", "신규 이용자 정보 등록", 0);
		if(petName == null) return;
		userName = JOptionPane.showInputDialog("-----------신규 이용자 정보 등록-----------\n보호자 이름을 입력해주세요.");
		if(userName == null) return;
		userNumber = JOptionPane.showInputDialog("-----------신규 이용자 정보 등록-----------\n보호자 번호를 입력해주세요.( - 없이 입력)");
		if(userNumber == null) return;
		while(true) {
			if(userNumber.length() == 11 && numCheck(userNumber)) { //번호가 11자리이면 끝
				break;
			}else {
				userNumber = JOptionPane.showInputDialog("-----------신규 이용자 정보 등록-----------\n보호자 번호를 입력해주세요.( - 없이 입력)"
						+ "\n전화번호는 숫자 11자리로 입력해주세요.");			
				if(userNumber == null) return;
			}
		}
		exDate = JOptionPane.showInputDialog("-----------신규 이용자 정보 등록-----------\n퇴실날짜를 입력해주세요.(yyMMdd)");
		if(exDate == null) return;
		while(true) {
			if(exDate.length() == 6 && numCheck(exDate)) {
				break;
			}else {
				exDate = JOptionPane.showInputDialog("-----------신규 이용자 정보 등록-----------\n퇴실날짜를 입력해주세요.(yyMMdd)"
						+ "\n날짜는 숫자 6자리로 입력해주세요.");
				if(exDate == null) return;
			}
		}
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2000+Integer.parseInt(exDate.substring(0, 2)));
		date.set(Calendar.MONTH, Integer.parseInt(exDate.substring(2, 4))-1); //월은 0부터 시작
		date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(exDate.substring(4, 6)));
		date.set(Calendar.HOUR_OF_DAY, 12);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		Pet p = new Pet(petName, userName, userNumber, date);
		petSet.add(p);
		JOptionPane.showMessageDialog(null, "등록 완료되었습니다.");
		try {
			SaveDAO.saveData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void lookup() {//전체 조회
		UIManager.put("OptionPane.messageFont", myFont);
		String msg = "--------------------------전체  조회--------------------------\n"
				+ "펫이름 / 보호자명 / 보호자 전화번호 / 퇴실날짜 / 비고\n";
		Iterator<Pet> itr = petSet.iterator();
		if(!itr.hasNext()) {
			JOptionPane.showMessageDialog(null, "조회할 정보가 없습니다.");
		}else {
			while(itr.hasNext()) {
				String caution = "";
				Pet exPet = itr.next();
				String endDate = simpleD.format(exPet.date.getTime());
				exPet.date.add(Calendar.DATE, -3);
				//현재날짜받아옴
				Calendar now = Calendar.getInstance();
				now.set(Calendar.HOUR_OF_DAY, 13);
				now.set(Calendar.MINUTE, 0);
				now.set(Calendar.SECOND, 0);
				
				if(now.compareTo(exPet.date) == 1 || now.compareTo(exPet.date) == 0) {
					caution = "퇴실 안내 필요";
				}
				
				String msg2 = exPet.petName+" / "+exPet.userName+"   / "+exPet.userNumber+" / "+endDate
						+" / "+caution+"\n";
				msg += msg2;
				exPet.date.add(Calendar.DATE, 3);
			}
			JOptionPane.showMessageDialog(null, msg);
		}
	}
	static void extend() {//기간 연장
		UIManager.put("OptionPane.messageFont", myFont);
		String pNum, petName, msg;
		msg = "----------------------기간  연장----------------------\n"
				+ "조회하신 번호에 해당되는 펫은 다음과 같습니다.\n펫이름 / 보호자명 / 퇴실날짜\n";
		int cnt = 0;
		pNum = JOptionPane.showInputDialog("----------------------기간  연장----------------------\n"
				+ "보호자 전화번호를 입력해주세요.");
		if(pNum == null) return;
		while(true) {
			if(pNum.length() == 11 && numCheck(pNum)) {
				break;
			}else {
				pNum = JOptionPane.showInputDialog("----------------------기간  연장----------------------\n"
						+ "전화번호는 숫자 11자리로 입력해주세요.\n보호자 전화번호를 입력해주세요.");
				if(pNum == null) return;
			}
		}
		Iterator<Pet> itr = petSet.iterator();
		while(itr.hasNext()) {
			Pet exPet = itr.next();
			if(exPet.userNumber.equals(pNum)) { //번호가 일치할 때
				cnt++;
				msg += exPet.petName+" / "+exPet.userName+" / "+dayString(exPet.date);
			}
		}
		if(cnt == 0) {
			JOptionPane.showMessageDialog(null, "보호자 전화번호를 확인해주세요.");
		}else {
			JOptionPane.showMessageDialog(null, msg);
			boolean sw = false;
			petName = JOptionPane.showInputDialog("----------------------기간  연장----------------------\n"
					+ "기간을 연장할 펫의 이름을 입력해주세요.");
			if(petName == null) return;
			Iterator<Pet> itr2 = petSet.iterator();
			while(itr2.hasNext()) {
				Pet exPet = itr2.next();
				if(exPet.petName.equals(petName) && exPet.userNumber.equals(pNum)) {
					sw = true;
					String num = JOptionPane.showInputDialog("----------------------기간  연장----------------------\n"
							+ exPet.petName+"의 현재 퇴실 날짜는 "+dayString(exPet.date)+" 입니다.\n"
									+ "연장하실 일수를 입력해주세요.(숫자만 입력)");
					if(num == null) return;
					if(numCheck(num)) {
						int num2 = Integer.parseInt(num);
						exPet.date.add(Calendar.DATE, num2);
						try {
							SaveDAO.saveData();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "----------------------기간  연장----------------------\n"+exPet.petName+"의 연장된 퇴실 날짜는 "+dayString(exPet.date)+" 입니다.");
					}else {
						JOptionPane.showMessageDialog(null, "----------------------기간  연장----------------------\n"
								+ "연장일수는 숫자로만 입력 가능합니다.");
					}
				}
			}
			if(!sw) {
				JOptionPane.showMessageDialog(null, "정보를 찾을 수 없습니다.");
			}
		}
	}
	static void revice() {//수정
		UIManager.put("OptionPane.messageFont", myFont);
		String pNum, petName;
		String msg = "---------------------------정보  수정---------------------------\n"
				+ "조회하신 번호에 해당되는 펫은 다음과 같습니다.\n펫이름 / 보호자명 / 퇴실날짜\n";
		int cnt=0;
		pNum = JOptionPane.showInputDialog("---------------------------정보  수정---------------------------\n"
				+ "보호자 전화번호를 입력해주세요.");
		if(pNum == null) return;
		while(true) {
			if(pNum.length() == 11 && numCheck(pNum)) {
				break;
			}else {
				pNum = JOptionPane.showInputDialog("---------------------------정보  수정---------------------------\n"
						+ "전화번호는 숫자 11자리로 입력해주세요.\n보호자 전화번호를 입력해주세요.");
				if(pNum == null) return;
			}
		}
		Iterator<Pet> itr = petSet.iterator();
		while(itr.hasNext()) {
			Pet exPet = itr.next();
			if(exPet.userNumber.equals(pNum)) { //번호가 일치할 때
				cnt++;
				msg += exPet.petName+" / "+exPet.userName+" / "+dayString(exPet.date);
			}
		}
		if(cnt == 0) {
			JOptionPane.showMessageDialog(null, "보호자 전화번호를 확인해주세요.");
		}else {
			JOptionPane.showMessageDialog(null, msg);
			boolean sw = true;
			petName = JOptionPane.showInputDialog("--------------------------정보  수정---------------------------\n"
					+ "수정할 펫의 이름을 입력해주세요.");
			if(petName == null) return;
			Iterator<Pet> itr2 = petSet.iterator();
			while(itr2.hasNext()) {
				Pet exPet = itr2.next();
				if(exPet.petName.equals(petName) && exPet.userNumber.equals(pNum)) {
					sw = false;
					String petName2 = JOptionPane.showInputDialog("--------------------------정보  수정---------------------------\n"
							+ "펫 이름 입력(0 입력시 수정없음)");
					if(petName2 == null) return;
					if(!petName2.equals("0")) {
						exPet.petName = petName2;
					}
					String userName2 = JOptionPane.showInputDialog("--------------------------정보  수정---------------------------\n"
							+ "보호자명 입력(0 입력시 수정없음)");
					if(userName2 == null) return;
					if(!userName2.equals("0")) {
						exPet.userName = userName2;
					}
					String userNumber2 = JOptionPane.showInputDialog("--------------------------정보  수정---------------------------\n"
							+ "보호자 번호 입력( - 없이 입력, 0 입력시 수정없음)");
					if(userNumber2 == null) return;
					if(!userNumber2.equals("0")) {
						exPet.userNumber = userNumber2;
					}
					String exDate2 = JOptionPane.showInputDialog("--------------------------정보  수정---------------------------\n"
							+ "퇴실 날짜 입력(yyMMdd, 0 입력시 수정없음)");
					if(exDate2 == null) return;
					if(!exDate2.equals("0")) {
						while(true) {
							if(exDate2.length() == 6 && numCheck(exDate2)) {
								Calendar date2 = Calendar.getInstance();
								date2.set(Calendar.YEAR, 2000+Integer.parseInt(exDate2.substring(0, 2)));
								date2.set(Calendar.MONTH, Integer.parseInt(exDate2.substring(2, 4))-1); //월은 0부터 시작
								date2.set(Calendar.DAY_OF_MONTH, Integer.parseInt(exDate2.substring(4, 6)));
								date2.set(Calendar.HOUR_OF_DAY, 12);
								date2.set(Calendar.MINUTE, 0);
								date2.set(Calendar.SECOND, 0);
								exPet.date = date2;
								break;
							}else {
								exDate2 = JOptionPane.showInputDialog("--------------------------정보  수정---------------------------\n"
										+ "날짜는 숫자 6자리로 입력해주세요\n퇴실 날짜 입력(yyMMdd, 0 입력시 수정없음)");
								if(exDate2 == null) return;
							}
						}
					}
					JOptionPane.showMessageDialog(null, "수정 완료되었습니다.");
					try {
						SaveDAO.saveData();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(sw) {
				JOptionPane.showMessageDialog(null, "--------------------------정보  수정---------------------------\n"
						+ "전화번호에 일치하는 펫이 없습니다.");
			}
		}
	}
	static void delete() {//삭제
		UIManager.put("OptionPane.messageFont", myFont);
		String pNum;
		Pet rPet = null;
		boolean sw = true;
		String petName = JOptionPane.showInputDialog("---------------------------정보  삭제---------------------------"
				+ "\n삭제할 펫의 이름을 입력해주세요.");
		if(petName == null) return;
		pNum = JOptionPane.showInputDialog("---------------------------정보  삭제---------------------------\n"
				+ "보호자 전화번호를 입력해주세요.");
		if(pNum == null) return;
		while(true) {
			if(pNum.length() == 11 && numCheck(pNum)) {
				break;
			}else {
				pNum = JOptionPane.showInputDialog("---------------------------정보  삭제---------------------------\n"
						+ "전화번호는 숫자 11자리로 입력해주세요.\n보호자 전화번호를 입력해주세요.");
				if(pNum == null) return;
			}
		}
		Iterator<Pet> itr = petSet.iterator();
		while(itr.hasNext()) {
			Pet exPet = itr.next();
			if(exPet.petName.equals(petName) && exPet.userNumber.equals(pNum)) {
				sw = false;
				rPet = exPet;
				JOptionPane.showMessageDialog(null, "--------------정보  삭제--------------\n삭제되었습니다.");
			}
		}
		if(rPet != null) {
			petSet.remove(rPet);			
			try {
				SaveDAO.saveData();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sw) {
			JOptionPane.showMessageDialog(null, "조회되는 정보가 없습니다.");
		}
	}
	static String dayString(Calendar cal) { //날짜형식을 바꿔 출력하는 메서드
		SimpleDateFormat simpleD = new SimpleDateFormat("yy/MM/dd");
		return simpleD.format(cal.getTime());
	}
	static boolean numCheck(String a) { //숫자인지 확인하는 메서드
		char tmp;
		for (int i = 0; i < a.length(); i++) {
			tmp = a.charAt(i);
			if(!Character.isDigit(tmp)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		UIManager.put("OptionPane.messageFont", myFont);
		
		SaveDAO.returnData();
		String choice; //메뉴선택번호
		boolean sw = true; //while문 스위치
		while(sw) {
			choice = JOptionPane.showInputDialog("-----펫 호텔 관리 프로그램-----\n1. 펫 등록\n2. 전체 조회\n3. 기간 연장\n4. 수정\n5. 삭제\n6. 종료");
			if(choice == null) return;
			switch (choice) {
			case "1":
				regist();
				break;
			case "2":
				lookup();
				break;
			case "3":
				extend();
				break;
			case "4":
				revice();
				break;
			case "5":
				delete();
				break;
			case "6":
				sw = false;
				break;
			default:
				JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
				break;
			}
		}
	}
}
