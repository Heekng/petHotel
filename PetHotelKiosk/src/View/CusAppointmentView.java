package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.useFnc;

public class CusAppointmentView extends MainView{
	public JTextField petNameTf;
	public JTextField enterDateTf, exitDateTf;
	public JButton enterDateBt, exitDateBt, inputBt, exitBt;
	public CusAppointmentView() {
		setTitle("펫 호텔 예약");
		
		JPanel topPn = new JPanel();
		ImageIcon image = useFnc.setImage(490, 330, "./Image/호텔예약메인.png");
		JLabel imageLb = new JLabel(image);
		topPn.add(imageLb);
		
		JPanel petNamePn = new JPanel();
		JLabel petNameLb = new JLabel("펫 이름  ");
		petNamePn.add(petNameLb);
		petNameTf = new JTextField(8);
		petNamePn.add(petNameTf);
		
		JPanel enterDatePn = new JPanel();
		JLabel enterDateLb = new JLabel("입실날짜[년월일 6자리]");
		enterDatePn.add(enterDateLb);
		enterDateTf = new JTextField(8);
		enterDatePn.add(enterDateTf);
		enterDateBt = new JButton("날짜 선택");
		enterDateBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CalandarView cal = new CalandarView();
				for (int i = 0; i < cal.dateButs.length; i++) {
					for (int j = 0; j < cal.dateButs[i].length; j++) {
						cal.dateButs[i][j].addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int k=0,l=0;
								for(int i=0 ; i<6 ; i++){
									for(int j=0 ; j<7 ; j++){
										if(e.getSource() == cal.dateButs[i][j]){ 
											k=i;
											l=j;
										}
									}
								}
								if(!(k ==0 && l == 0)) cal.calDayOfMon = cal.calDates[k][l];
								String realYear, realMonth, realDay;
								if(cal.calYear%100 < 10) realYear = "0"+(cal.calYear%100);
								else realYear = ""+(cal.calYear%100);
								if(cal.calMonth+1 < 10) realMonth = "0" +(cal.calMonth+1);
								else realMonth = "" +(cal.calMonth+1);
								if(cal.calDayOfMon < 10) realDay = "0" + (cal.calDayOfMon);
								else realDay = "" + (cal.calDayOfMon);
								
								String time = realYear+realMonth+realDay;
								
								enterDateTf.setText(time);
								cal.mainFrame.dispose();
							}
						});
					}
				}
				cal.mainFrame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						cal.mainFrame.dispose();
					}
				});
			}
		});
		enterDatePn.add(enterDateBt);
		
		JPanel exitDatePn = new JPanel();
		JLabel exitDateLb = new JLabel("퇴실날짜[년월일 6자리]");
		exitDatePn.add(exitDateLb);
		exitDateTf = new JTextField(8);
		exitDatePn.add(exitDateTf);
		exitDateBt = new JButton("날짜 선택");
		exitDateBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CalandarView cal = new CalandarView();
				for (int i = 0; i < cal.dateButs.length; i++) {
					for (int j = 0; j < cal.dateButs[i].length; j++) {
						cal.dateButs[i][j].addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int k=0,l=0;
								for(int i=0 ; i<6 ; i++){
									for(int j=0 ; j<7 ; j++){
										if(e.getSource() == cal.dateButs[i][j]){ 
											k=i;
											l=j;
										}
									}
								}
								if(!(k ==0 && l == 0)) cal.calDayOfMon = cal.calDates[k][l];
								String realYear, realMonth, realDay;
								if(cal.calYear%100 < 10) realYear = "0"+(cal.calYear%100);
								else realYear = ""+(cal.calYear%100);
								if(cal.calMonth+1 < 10) realMonth = "0" +(cal.calMonth+1);
								else realMonth = "" +(cal.calMonth+1);
								if(cal.calDayOfMon < 10) realDay = "0" + (cal.calDayOfMon);
								else realDay = "" + (cal.calDayOfMon);
								
								String time = realYear+realMonth+realDay;
								
								exitDateTf.setText(time);
								cal.mainFrame.dispose();
								setVisible(true);
							}
						});
					}
				}
				cal.mainFrame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						cal.mainFrame.dispose();
					}
				});
			}
		});
		exitDatePn.add(exitDateBt);
		
		JPanel buttonPn = new JPanel();
		ImageIcon image1 = useFnc.setImage(120, 72, "./Image/예약.png");
		inputBt = new JButton(image1);
		inputBt.setContentAreaFilled(false);
		inputBt.setBorderPainted(false);
		inputBt.setFocusPainted(false);
		buttonPn.add(inputBt);
		ImageIcon image2 = useFnc.setImage(120, 72, "./Image/나가기.png");
		exitBt = new JButton(image2);
		exitBt.setContentAreaFilled(false);
		exitBt.setBorderPainted(false);
		exitBt.setFocusPainted(false);
		buttonPn.add(exitBt);
		
		add(topPn);
		add(petNamePn);
		add(enterDatePn);
		add(exitDatePn);
		add(buttonPn);
		
		setVisible(true);
	}
	public void review() {
		setVisible(false);
		setVisible(true);
	}
}
