package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AllExitPetView extends MainView{
	JPanel listPn, outlistPn;
	JScrollPane sp;
	ArrayList<String[]> getData;
	public JButton exitBt;
	String title[] = {"고객번호", "펫이름", "방번호", "입실날짜", "퇴실날짜"};
	public AllExitPetView(ArrayList<String[]> data) {
		setTitle("퇴실내역 조회");
		
		getData = data;
		int size;
		if(getData.size() < 13) {
			size = 13;
		}else {
			size = getData.size();
		}
		String[][] arr = getData.toArray(new String[size][5]);
		
		JPanel topPn = new JPanel();
		JLabel topLb = new JLabel("지금까지의 퇴실내역입니다.");
		topPn.add(topLb);
		
		JPanel choicePn = new JPanel(new FlowLayout());
		JTextField numTf = new JTextField(8);
		choicePn.add(numTf);
		JButton searchBt = new JButton("검색");
		searchBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String num = numTf.getText();
				search(num);
			}
		});
		choicePn.add(searchBt);
		
		outlistPn = new JPanel();
		DefaultTableModel dtm = new DefaultTableModel(arr, title);
		JTable table = new JTable(dtm);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(30);
		sp = new JScrollPane(table);
		outlistPn.add(sp);
		
		JPanel buttonPn = new JPanel();
		exitBt = new JButton("나가기");
		buttonPn.add(exitBt);
		
		add(topPn);
		add(choicePn);
		add(outlistPn);
		add(buttonPn);
		
		setVisible(true);
	}
	public void search(String num) {
		ArrayList<String[]> tmpArraylist = new ArrayList<>();
		for (int i = 0; i < getData.size(); i++) {
			if(getData.get(i)[0].equals(num)) {
				tmpArraylist.add(getData.get(i));
			}
		}
		int size;
		if(tmpArraylist.size() < 13) {
			size = 13;
		}else {
			size = getData.size();
		}
		String [][] arr = tmpArraylist.toArray(new String[size][5]);
		DefaultTableModel dtm = new DefaultTableModel(arr, title);
		JTable table = new JTable(dtm);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(30);
		JScrollPane sp1 = new JScrollPane(table);
		outlistPn.remove(sp);
		outlistPn.add(sp1);
		outlistPn.setVisible(false);
		outlistPn.setVisible(true);
	}
}
