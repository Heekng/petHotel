package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class LookUpView extends MainView{
	public String data[][] = new String[21][6];

	public int phoneNum;
	public JButton backBt, numBt, allBt;
	public JPanel listPn;
	public JTextField numTf;
	JTable table;
	JScrollPane sp;
	String title[] = {"전화번호", "펫이름", "방번호", "입실날짜", "퇴실날짜", "알림"};
	
	public LookUpView() {
		setTitle("고객 조회");
		JPanel choicePn = new JPanel();
		choicePn.setLayout(new FlowLayout());
		
		JPanel topPn = new JPanel();
		JLabel topLb = new JLabel("전체 고객 조회");
		topLb.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		topPn.add(topLb);
		
		numTf = new JTextField(8);
		numTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(numTf.getText().length() >= 8) e.consume();
			}
		});
		choicePn.add(numTf);
		numBt = new JButton("전화번호 조회");
		choicePn.add(numBt);
		allBt = new JButton("전체 조회");
		choicePn.add(allBt);
		
		listPn = new JPanel();
		table = new JTable(data, title);
		table.setRowHeight(19);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		sp = new JScrollPane(table);
		listPn.add(sp);
		
		JPanel buttonPn = new JPanel();
		backBt = new JButton("뒤로 가기");
		buttonPn.add(backBt);
		
		add(topPn);
		add(choicePn);
		add(listPn);
		add(buttonPn);
		
		setVisible(true);
	}
	public void review() {
		table = new JTable(data, title);
		table.setRowHeight(19);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		sp = new JScrollPane(table);
		listPn.removeAll();
		listPn.add(sp);
		listPn.setVisible(false);
		listPn.setVisible(true);
		
		
	}
}
