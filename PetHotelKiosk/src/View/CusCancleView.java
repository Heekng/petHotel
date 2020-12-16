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
		setTitle("예약 취소");
		String title[] = {"펫이름", "방번호", "입실날짜", "퇴실날짜"};
		Object data[][] = new Object[10][4];
		//값넣기
		for (int i = 0; i < arr.size(); i++) {
			data[i] = arr.get(i);
		}
		JPanel topPn = new JPanel();
		ImageIcon image = useFnc.setImage(500, 100, "./Image/예약취소메인.png");
		JLabel topLb = new JLabel(image);
		topPn.add(topLb);
		
		
		JPanel userPn = new JPanel();
		JLabel userLb = new JLabel("예약 취소할 펫을 선택해주세요.");
		userLb.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		userPn.add(userLb);
		
		JPanel midPn = new JPanel();
		midPn.setLayout(new BoxLayout(midPn, BoxLayout.X_AXIS));

		JPanel midButtonPn = new JPanel();
		midButtonPn.setLayout(new BoxLayout(midButtonPn, BoxLayout.Y_AXIS));
		JButton emptyBt = new JButton("버튼"){
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
			midButton[i].setText(i+1+"번 선택");
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
		ImageIcon exitImage = useFnc.setImage(120, 45, "./Image/나가기.png");
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
