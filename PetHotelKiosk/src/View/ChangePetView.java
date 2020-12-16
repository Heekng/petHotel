package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.useFnc;
import DTO.Pet;

public class ChangePetView extends MainView{
	public JTextField phoneNumTf;
	public JButton searchBt, backBt;
	public ButtonGroup buttonGroup;
	public int userPhoneNum = 0;
	public JScrollPane sp;
	JPanel midPn, tablePn;
	public JButton midButton[] = new JButton[10];
	public String data[][] = new String [10][4];
	public Pet [] petArr = new Pet[10];
	public JRadioButton changeRb, deleteRb;
	String title[] = {"펫이름", "방번호", "입실날짜", "퇴실날짜"};
	public ChangePetView() {
		
		
		setTitle("회원 정보 수정/삭제");
		
		JPanel userPn = new JPanel();
		JLabel userLb = new JLabel("전화번호로 조회 후 선택하여 수정/삭제");
		userLb.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		userPn.add(userLb);
		
		JPanel topPn = new JPanel(new FlowLayout());
		phoneNumTf = new JTextField(8);
		topPn.add(phoneNumTf);
		searchBt = new JButton("조회");
		topPn.add(searchBt);
		buttonGroup = new ButtonGroup();
		changeRb = new JRadioButton("수정");
		deleteRb = new JRadioButton("삭제");
		buttonGroup.add(changeRb);
		topPn.add(changeRb);
		buttonGroup.add(deleteRb);
		topPn.add(deleteRb);
		changeRb.setSelected(true);
		
		midPn = new JPanel();
		midPn.setLayout(new BoxLayout(midPn, BoxLayout.X_AXIS));
		
		JPanel midButtonPn = new JPanel();
		midButtonPn.setLayout(new BoxLayout(midButtonPn, BoxLayout.Y_AXIS));
		JButton emptyBt = new JButton("버튼") {
			{
				setSize(150, 24);
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
					setSize(150, 48);
					setMaximumSize(getSize());
					setBackground(Color.WHITE);
					setOpaque(true);
					setEnabled(false);
				}
			};
			midButton[i].setText(i+1+"번 선택");
			midButtonPn.add(midButton[i]);
		}
		midPn.add(midButtonPn);
		
		DefaultTableModel dtm = new DefaultTableModel(data, title);
		JTable table = new JTable(dtm);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(42);
		sp = new JScrollPane(table);
		midPn.add(sp);
		
		JPanel buttonPn = new JPanel();
		backBt = new JButton("나가기");
		buttonPn.add(backBt);
		
		add(userPn);
		add(topPn);
		add(midPn);
		add(buttonPn);
		
		setVisible(true);
	}
	public void review(HashSet<Pet> petSet) {
		for (int i = 0; i < petSet.size(); i++) {
			midButton[i].setEnabled(true);
		}
		Iterator<Pet> itr = petSet.iterator();
		int num = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = "";
			}
		}
		while(itr.hasNext()) {
			Pet tmpPet = itr.next();
			petArr[num] = tmpPet;
			String arr [] = {
					tmpPet.getPetName(),
					""+tmpPet.getRoomNum(),
					useFnc.dateToStr(tmpPet.getEnterDate()),
					useFnc.dateToStr(tmpPet.getExitDate())
			};
			data[num++] = arr;
		}
		DefaultTableModel dtm = new DefaultTableModel(data, title);
		JTable table = new JTable(dtm);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(42);
		JScrollPane sp2 = new JScrollPane(table);
		midPn.remove(sp);
		midPn.add(sp2);
		midPn.setVisible(false);
		midPn.setVisible(true);
	}
}
