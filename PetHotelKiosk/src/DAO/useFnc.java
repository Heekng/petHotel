package DAO;

import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;

public class useFnc {
	static Scanner sc = new Scanner(System.in);
	static int numCheck(String num) { //�������� Ȯ���ϰ� ���̰� n���� Ȯ���ϴ� �޼ҵ�
		//�����̸� ���ڸ� ����, ���ڰ� �ƴϸ� -1����
		boolean sw = true;
		for (int i = 0; i < num.length(); i++) {
			if(Character.isDigit(num.charAt(i))) {
				continue;
			}else {
				sw = false;
				break;
			}
		}
		if(!sw) return -1;//���ڰ� �ƴϴ�.
		else return Integer.parseInt(num);
	}
	/*
	static int numCheck(String num, int n) { //���̰� n��ŭ���� Ȯ���ϴ� �Լ�
		if(numCheck(num) != -1) { //�����̸�
			if(num.length() == n) return numCheck(num);
			else return -2; //���̰� ���� ������ -2����
		}else {
			return -1;
		}
	}
	static int inputNum(int n) {
		while(true) {
			int num = numCheck(sc.next(), n);
			if(num == -1 || num == -2) {
				System.out.println("����"+n+"�ڸ��� �Է����ּ���.");
				System.out.print("�Է�: ");
			}else {
				return num;
			}
		}		
	}
	*/
	static LocalDate strToDate(String date) {
		int year = 2000+Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4));
		int day = Integer.parseInt(date.substring(4, 6));
		LocalDate reDate = LocalDate.of(year, month, day);
		return reDate;
	}
	public static String dateToStr(LocalDate date) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMdd");
		String before = date.format(dateTimeFormatter);
		int month = Integer.parseInt(before.substring(2, 4));
		String newMonth;
		if(month < 10) {
			newMonth = "0"+String.valueOf(month);
		}else{
			newMonth = String.valueOf(month);
		}
		String newStr = before.substring(0, 2)+newMonth+before.substring(4, 6);
		return newStr;
	}
	static String customPtrn(String Guid, String pattern, String caution) {
		String getTxt;
		System.out.print(Guid);//////////////���ڸ� �Է�
		while(true) {
			getTxt = sc.next();
			if(Pattern.matches(pattern, getTxt)) {
				break;
			}else {
				System.out.print(caution);
			}
		}
		return getTxt;
	}
	
	static boolean dayCheck(LocalDate endDate, int num) {
		LocalDate exDate = endDate.minusDays(num);
		LocalDate nowDate = LocalDate.now();
		if(exDate.isBefore(nowDate) || exDate.isEqual(nowDate)) {
			return true;
		}else {
			return false;
		}
	}
	public static ImageIcon setImage(int x, int y, String z) {
		ImageIcon image = new ImageIcon(z);
		Image img = image.getImage();
		Image changeImg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		return changeIcon;
	}
	
}