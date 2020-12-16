package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.useFnc;

public class CustomerMenuView extends MainView{
	public JButton button1, button2, button3, button4, button5;
	public CustomerMenuView() {
		super();
		setTitle("고객 메뉴");
		
		JPanel imagePn = new JPanel();
		
		ImageIcon image = useFnc.setImage(490, 330, "./Image/고객메뉴.png");
		JLabel imageLb = new JLabel(image);
		imagePn.setBackground(Color.WHITE);
		imagePn.add(imageLb, BorderLayout.NORTH);
		
		JPanel buttonPn = new JPanel(new GridLayout(2, 2));
		buttonPn.setBackground(Color.WHITE);
		buttonPn.setPreferredSize(new Dimension(500, 250));
		
		ImageIcon image1 = useFnc.setImage(200, 100, "./Image/호텔예약.png");
		button1 = new JButton(image1);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		buttonPn.add(button1);

		
		
		ImageIcon image2 = useFnc.setImage(200, 100, "./Image/예약조회.png");
		button2 = new JButton(image2);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		buttonPn.add(button2);
		
		
		ImageIcon image3 = useFnc.setImage(200, 100, "./Image/예약연장.png");
		button3 = new JButton(image3);
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button3.setFocusPainted(false);
		buttonPn.add(button3);
		
		
		ImageIcon image4 = useFnc.setImage(200, 100, "./Image/예약취소.png");
		button4 = new JButton(image4);
		button4.setContentAreaFilled(false);
		button4.setBorderPainted(false);
		button4.setFocusPainted(false);
		buttonPn.add(button4);
		
		JPanel exitBtPn = new JPanel(new GridLayout(1,1));
		exitBtPn.setBackground(Color.WHITE);
		exitBtPn.setPreferredSize(new Dimension(500, 150));
		
		ImageIcon image5 = useFnc.setImage(200, 80, "./Image/나가기.png");
		button5 = new JButton(image5);
		button5.setContentAreaFilled(false);
		button5.setBorderPainted(false);
		button5.setFocusPainted(false);
		
		exitBtPn.add(button5);
		
		add(imagePn);
		add(buttonPn);
		add(exitBtPn);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new CustomerMenuView();
	}
}
