package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.useFnc;

public class startView extends MainView{
	public static JFrame startMenuJf;
	public JButton customerBt, managerBt;
	public startView() {
		setTitle("�� ȣ�� Ű����ũ");
		
		JPanel imagePn = new JPanel();
		imagePn.setPreferredSize(new Dimension(500, 460));
		imagePn.setBackground(new Color(190, 163, 112));
		
		ImageIcon changeIcon = useFnc.setImage(480, 460, "./Image/Ű����ũ����.png");
		JLabel mainImage = new JLabel(changeIcon);
		imagePn.add(mainImage);
		Dimension x = imagePn.getPreferredSize();
		Dimension y = mainImage.getPreferredSize();
		
		
		JPanel buttonPn = new JPanel(new GridLayout(1, 2));
		buttonPn.setBackground(Color.WHITE);
		buttonPn.setPreferredSize(new Dimension(500, 200));
		ImageIcon button1Icon = useFnc.setImage(250, 200, "./Image/�����޴���ư.png");
		customerBt = new JButton(button1Icon);
		customerBt.setContentAreaFilled(false); //��ư ���� ��� ǥ��
		customerBt.setBackground(Color.WHITE);
		customerBt.setBorderPainted(false);
		customerBt.setFocusPainted(false);
		buttonPn.add(customerBt);
		
		ImageIcon button2Icon = useFnc.setImage(250, 200, "./Image/�����ڸ޴���ư.png");
		managerBt = new JButton(button2Icon);
		managerBt.setContentAreaFilled(false); //��ư ���� ��� ǥ��
		managerBt.setBackground(Color.WHITE);
		managerBt.setBorderPainted(false);
		managerBt.setFocusPainted(false);
		buttonPn.add(managerBt);
		
		add(imagePn);
		add(buttonPn);
		
		setVisible(true);
		
	}
}