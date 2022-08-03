package ftm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ForgotPass extends JFrame {
	
	private Container c;
	private JLabel logoLbl,lbl1,lbl2;
	private ImageIcon logo, icon;
	private Font fnt1;
	
	ForgotPass(){
		initComponents();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(3);
		this.setTitle("Password Recovery");
		this.setBounds(300,50,375,600);
		this.setLayout(null);
		this.setResizable(false);
		
		icon = new ImageIcon(getClass().getResource("logoBlack.png"));
		this.setIconImage(icon.getImage());
		
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLACK);
		
		fnt1 = new Font("Montserrat",Font.BOLD,20);
		
		logo = new ImageIcon(getClass().getResource("logo.png"));
		logoLbl = new JLabel(logo);
		logoLbl.setBounds(140,0,92,50);
		c.add(logoLbl);
		
		lbl1 = new JLabel("THIS SECTION WILL BE");
		lbl1.setBounds(55,170,260,24);
		lbl1.setFont(fnt1);
		lbl1.setForeground(Color.WHITE);
		c.add(lbl1);
		
		lbl2 = new JLabel("AVAILABLE SOON!");
		lbl2.setBounds(85,200,205,24);
		lbl2.setFont(fnt1);
		lbl2.setForeground(Color.WHITE);
		c.add(lbl2);
		
		
	}

	public static void main(String[] args) {
		ForgotPass f = new ForgotPass();
		f.setVisible(true);

	}

}
