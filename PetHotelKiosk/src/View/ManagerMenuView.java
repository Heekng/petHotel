package View;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.useFnc;

public class ManagerMenuView extends MainView{
	public JButton button1, button2, button3, button4, button5, button6;
	public ManagerMenuView() {
		setTitle("������ �޴�");
		
		JPanel imagePn = new JPanel();
		ImageIcon image = useFnc.setImage(490, 330, "./Image/�����ڸ޴�.png");
		JLabel imageLb = new JLabel(image);
		imagePn.add(imageLb);
		
		JPanel buttonPn = new JPanel(new GridLayout(2, 3));
		
		ImageIcon image1 = useFnc.setImage(180, 100, "./Image/����ȸ��ư.png");
		button1 = new JButton(image1);
		buttonPn.add(button1);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		
		ImageIcon image2 = useFnc.setImage(180, 100, "./Image/���ó����ư.png");
		button2 = new JButton(image2);
		buttonPn.add(button2);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		
		ImageIcon image3 = useFnc.setImage(180, 100, "./Image/����������ư.png");
		button3 = new JButton(image3);
		buttonPn.add(button3);
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button3.setFocusPainted(false);
		
		ImageIcon image4 = useFnc.setImage(180, 100, "./Image/�����ں�й�ȣ������ư.png");
		button4 = new JButton(image4);
		buttonPn.add(button4);
		button4.setContentAreaFilled(false);
		button4.setBorderPainted(false);
		button4.setFocusPainted(false);
		
		ImageIcon image5 = useFnc.setImage(180, 100, "./Image/��ǳ�����ȸ��ư.png");
		button5 = new JButton(image5);
		buttonPn.add(button5);
		button5.setContentAreaFilled(false);
		button5.setBorderPainted(false);
		button5.setFocusPainted(false);
		
		ImageIcon image6 = useFnc.setImage(180, 100, "./Image/������.png");
		button6 = new JButton(image6);
		buttonPn.add(button6);
		button6.setContentAreaFilled(false);
		button6.setBorderPainted(false);
		button6.setFocusPainted(false);
		
		add(imagePn);
		add(buttonPn);
		
		setVisible(true);
	}
}
