package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RoomView extends JFrame{
	
	JPanel roomPn;
	public JButton roomBtn[][] = new JButton[5][5];
	
	public RoomView(boolean [][] roomArr) {
		setTitle("방 조회");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		
		roomPn = new JPanel();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				roomBtn[i][j] = new JButton();
				roomBtn[i][j].setBorderPainted(false);
				roomBtn[i][j].setBackground(Color.WHITE);
				roomBtn[i][j].setOpaque(true);
				roomBtn[i][j].setText(101+(i*100)+j+"호"); //방번호
				if(roomArr[i][j]) roomBtn[i][j].setEnabled(false);
				
				roomPn.add(roomBtn[i][j]);
			}
		}
		roomPn.setLayout(new GridLayout(0, 5, 2, 2));
		roomPn.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
	
		add(roomPn);
		
		setVisible(true);
	}
}
