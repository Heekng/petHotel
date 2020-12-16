package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Enumeration;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class MainView extends JFrame{
	public static Font mmFont = new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 17);

	public MainView() {
		setGlobalFont(mmFont);
		setTitle("≈∏¿Ã∆≤∏Ì");
		setSize(500, 700);
		setResizable(false);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		

		setFont(mmFont);

		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dimen2 = getSize();
		int x = (dimen.width - dimen2.width)/2;
		int y= (dimen.height - dimen2.height)/2;
		setLocation(x, y);
	}
	
	public static void setGlobalFont( Font font ) {  
		Enumeration keys = UIManager.getDefaults().keys();  
		while (keys.hasMoreElements() ) {  
			Object key = keys.nextElement();  
			Object value = UIManager.get( key );  
			if ( value instanceof Font ) {  
				UIManager.put( key, font );  
			}  
		}  
	}
}