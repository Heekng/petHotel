package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ChangePasswordView extends MainView{
	
	public JPasswordField nowTf, changeTf, reChangeTf;
	public JButton changeBt, exitBt;
	
	public ChangePasswordView() {
		setTitle("������ ��й�ȣ ����");
		setSize(400, 300);
		
		JPanel userPn = new JPanel();
		JLabel userLb = new JLabel("�����й�ȣ�� ������ ��й�ȣ�� �Է����ּ���.");
		userPn.add(userLb);
		
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dimen2 = getSize();
		int x = (dimen.width - dimen2.width)/2;
		int y= (dimen.height - dimen2.height)/2;
		setLocation(x, y);
		
		JPanel nowPn = new JPanel(new FlowLayout());
		JLabel nowLb = new JLabel("���� ��й�ȣ");
		nowPn.add(nowLb);
		nowTf = new JPasswordField(8);
		nowPn.add(nowTf);
		
		JPanel changePn = new JPanel(new FlowLayout());
		JLabel changeLb = new JLabel("���� ��й�ȣ");
		changePn.add(changeLb);
		changeTf = new JPasswordField(8);
		changePn.add(changeTf);
		
		JPanel reChangePn = new JPanel(new FlowLayout());
		JLabel reChangeLb = new JLabel("���� ��й�ȣ Ȯ��");
		reChangePn.add(reChangeLb);
		reChangeTf = new JPasswordField(8);
		reChangePn.add(reChangeTf);
		
		JPanel buttonPn = new JPanel();
		changeBt = new JButton("����");
		buttonPn.add(changeBt);
		exitBt = new JButton("������");
		buttonPn.add(exitBt);
		
		add(userPn);
		add(nowPn);
		add(changePn);
		add(reChangePn);
		add(buttonPn);
		
		setVisible(true);
	}
}