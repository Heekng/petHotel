package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.useFnc;

public class CusCancleView extends MainView{
	public JButton backBt;
	public JButton midButton[] = new JButton[10];
	public static int numN = 0;

	public CusCancleView(ArrayList<String[]> arr, int phoneNum) {
		setTitle("���� ���");
		String title[] = {"���̸�", "���ȣ", "�Խǳ�¥", "��ǳ�¥"};
		Object data[][] = new Object[10][4];
		//���ֱ�
		for (int i = 0; i < arr.size(); i++) {
			data[i] = arr.get(i);
		}
		JPanel topPn = new JPanel();
		ImageIcon image = useFnc.setImage(500, 100, "./Image/������Ҹ���.png");
		JLabel topLb = new JLabel(image);
		topPn.add(topLb);
		
		
		JPanel userPn = new JPanel();
		JLabel userLb = new JLabel("���� ����� ���� �������ּ���.");
		userLb.setFont(new Font("���� ����", Font.BOLD, 25));
		userPn.add(userLb);
		
		JPanel midPn = new JPanel();
		midPn.setLayout(new BoxLayout(midPn, BoxLayout.X_AXIS));

		JPanel midButtonPn = new JPanel();
		midButtonPn.setLayout(new BoxLayout(midButtonPn, BoxLayout.Y_AXIS));
		JButton emptyBt = new JButton("��ư"){
			{
				setSize(150, 22); 
				setMaximumSize(getSize()); 
				setEnabled(false);
				setOpaque(true);
				setBackground(Color.WHITE);
			}
		};
		midButtonPn.add(emptyBt);
		for (int i = 0; i < midButton.length; i++) {
			midButton[i] = new JButton() {
				{
					setSize(150, 51); 
					setMaximumSize(getSize()); 
					setBackground(Color.WHITE);
					setOpaque(true);
				}
			};
			midButton[i].setText(i+1+"�� ����");
			if(i >= arr.size()) {
				midButton[i].setEnabled(false);
			}
			midButtonPn.add(midButton[i]);
		}

		midPn.add(midButtonPn);

		JPanel listPn = new JPanel();
		DefaultTableModel dtm = new DefaultTableModel(data, title);
		JTable table = new JTable(dtm);

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(40);


		JScrollPane sp = new JScrollPane(table);
		listPn.setBackground(Color.PINK);
		midPn.add(sp);

		JPanel buttonPn = new JPanel();
		ImageIcon exitImage = useFnc.setImage(120, 45, "./Image/������.png");
		backBt = new JButton(exitImage);
		backBt.setContentAreaFilled(false);
		backBt.setBorderPainted(false);
		backBt.setFocusPainted(false);
		buttonPn.add(backBt);

		add(topPn);
		add(userPn);
		add(midPn);
		add(buttonPn);

		setVisible(true);
	}
}