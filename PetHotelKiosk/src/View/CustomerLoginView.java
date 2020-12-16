package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.useFnc;

public class CustomerLoginView extends MainView{
	public JButton loginBt, exitBt, joinBt;
	public JTextField loginTf;
	public JPasswordField passwordPf;
	public CustomerLoginView() {
		setTitle("���� �α���");
		
		JPanel topPn = new JPanel();
		ImageIcon image = useFnc.setImage(500, 450, "./Image/�����α���1.png");
		JLabel topLb = new JLabel(image);
		topPn.setBackground(Color.WHITE);
		topPn.add(topLb);
		
		JPanel loginPn = new JPanel();
		JLabel loginLb = new JLabel("��ȭ��ȣ: 010");
		loginPn.setBackground(Color.WHITE);
		loginPn.add(loginLb);
		loginTf = new JTextField(8);
		loginTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(loginTf.getText().length() >= 8) e.consume();
			}
		});
		loginPn.add(loginTf);
		
		JPanel passwordPn = new JPanel();
		passwordPn.setBackground(Color.WHITE);
		JLabel passwordLb = new JLabel("��й�ȣ      ");
		passwordPn.add(passwordLb);
		passwordPf = new JPasswordField(8);
		passwordPn.add(passwordPf);
		
		JPanel buttonPn = new JPanel();
		buttonPn.setBackground(Color.WHITE);
		buttonPn.setLayout(new FlowLayout());
		ImageIcon loginImage = useFnc.setImage(120, 72, "./Image/�α��ι�ư.png");
		loginBt = new JButton(loginImage);
		loginBt.setContentAreaFilled(false);
		loginBt.setBorderPainted(false);
		loginBt.setFocusPainted(false);
		buttonPn.add(loginBt);
		
		ImageIcon joinImage = useFnc.setImage(120, 72, "./Image/�ű԰���.png");
		joinBt = new JButton(joinImage);
		joinBt.setContentAreaFilled(false);
		joinBt.setBorderPainted(false);
		joinBt.setFocusPainted(false);
		buttonPn.add(joinBt);
		
		ImageIcon exitImage = useFnc.setImage(120, 72, "./Image/������.png");
		exitBt = new JButton(exitImage);
		exitBt.setContentAreaFilled(false);
		exitBt.setBorderPainted(false);
		exitBt.setFocusPainted(false);
		buttonPn.add(exitBt);
		
		add(topPn);
		add(loginPn);
		add(passwordPn);
		add(buttonPn);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new CustomerLoginView();
	}
}