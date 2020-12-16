package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.useFnc;

public class CusLookupView extends MainView{
	public JButton backBt;
	public CusLookupView(ArrayList<String[]> arr, int phoneNum) {
		setTitle("���� ��ȸ");
		setBackground(Color.WHITE);
		String title[] = {"���̸�", "���ȣ", "�Խǳ�¥", "��ǳ�¥"};
		int size;
		if(arr.size() < 10) {
			size = 10;
		}else {
			size = arr.size();
		}
		String data[][] = new String[size][4];
		//���ֱ�
		for (int i = 0; i < arr.size(); i++) {
			data[i] = arr.get(i);
		}
		
		JPanel topPn = new JPanel();
		ImageIcon topImage = useFnc.setImage(500, 300, "./Image/������ȸ����.png");
		JLabel topLb = new JLabel(topImage);
		topPn.add(topLb);
		
		JPanel userPn = new JPanel();
		userPn.setBackground(Color.WHITE);
		JLabel userLb = new JLabel(phoneNum+"���� ���������Դϴ�.");
		userLb.setFont(new Font("���� ����", Font.BOLD, 25));
		userPn.add(userLb);
		
		JPanel listPn = new JPanel();
		listPn.setBackground(Color.WHITE);
		
		JTable table = new JTable(data, title);
		table.setRowHeight(19);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		JScrollPane sp = new JScrollPane(table);
		listPn.add(sp);
		
		JPanel buttonPn = new JPanel();
		buttonPn.setBackground(Color.WHITE);
		ImageIcon buttonIcon = useFnc.setImage(100, 60, "./Image/������.png");
		backBt = new JButton(buttonIcon);
		backBt.setContentAreaFilled(false);
		backBt.setBorderPainted(false);
		backBt.setFocusPainted(false);
		buttonPn.add(backBt);
		
		add(topPn);
		add(userPn);
		add(listPn);
		add(buttonPn);
		
		setVisible(true);
	}
	
}