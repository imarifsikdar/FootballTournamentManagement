package ftm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent; 
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogIn extends JFrame {
	
	private Container c;
	private JLabel logoLbl,lbl1,lbl2,lbl3,lbl4;
	private JTextField tf;
	private JPasswordField pf;
	private JButton btnAdLog;
	private ImageIcon logo, icon;
	private Font fnt1,fnt2,fnt3;
	private Cursor cursor;
	
	AdminLogIn(){
		initComponents();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(3);
		this.setTitle("Admin LogIn");
		this.setBounds(300,50,375,600);
		this.setLayout(null);
		this.setResizable(false);
		
		icon = new ImageIcon(getClass().getResource("logoBlack.png"));
		this.setIconImage(icon.getImage());
		
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLACK);
		
		fnt1 = new Font("Montserrat",Font.BOLD,20);
		fnt2 = new Font("Montserrat",Font.PLAIN,13);
		fnt3 = new Font("Montserrat",Font.BOLD,16);
		
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		logo = new ImageIcon(getClass().getResource("logo.png"));
		logoLbl = new JLabel(logo);
		logoLbl.setBounds(140,0,92,50);
		c.add(logoLbl);
		
		lbl1 = new JLabel("Admin");
		lbl1.setForeground(Color.WHITE);
		lbl1.setBounds(152,155,70,24);
		lbl1.setFont(fnt1);
		c.add(lbl1);
		
		lbl2 = new JLabel("Username: ");
		lbl2.setForeground(Color.WHITE);
		lbl2.setBounds(34,262,80,17);
		lbl2.setFont(fnt2);
		c.add(lbl2);
		
		tf = new JTextField();
		tf.setBounds(120,262,221,17);
		tf.setForeground(Color.WHITE);
		tf.setFont(fnt2);
		tf.setBackground(Color.BLACK);
		tf.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tf);
		
		lbl3 = new JLabel("Password: ");
		lbl3.setForeground(Color.WHITE);
		lbl3.setBounds(34,312,75,17);
		lbl3.setFont(fnt2);
		c.add(lbl3);
		
		pf = new JPasswordField();
		pf.setBounds(120,312,221,17);
		pf.setForeground(Color.WHITE);
		pf.setFont(fnt2);
		pf.setBackground(Color.BLACK);
		pf.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(pf);
		
		btnAdLog = new JButton("Login");
		btnAdLog.setBounds(104,379,166,31);
		btnAdLog.setFocusPainted(false);
		btnAdLog.setCursor(cursor);
		btnAdLog.setFont(fnt3);
		btnAdLog.setBackground(Color.WHITE);
		c.add(btnAdLog);
		
		lbl4 = new JLabel("Forgot Password?");
		lbl4.setBounds(121,442,128,17);
		lbl4.setForeground(Color.WHITE);
		lbl4.setFont(fnt2);
		lbl4.setCursor(cursor);
		Font lbl4Fnt = lbl4.getFont();
		Map attributes = lbl4Fnt.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lbl4.setFont(lbl4Fnt.deriveFont(attributes));
		c.add(lbl4);
		
		
		btnAdLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = "arif_sikdar";
				String pass = "alhamdulillah1,2";
						if(tf.getText().equals(username) && pf.getText().equals(pass)) {
							AdminSection newFrame = new AdminSection();
							dispose();
							newFrame.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "You have entered wrong Password or Email!");
							tf.setText("");
							pf.setText("");
						}
			}
		});
		
		lbl4.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				ForgotPass newFrame1 = new ForgotPass();
				dispose();
				newFrame1.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		
	}
	

	public static void main(String[] args) {
		AdminLogIn f1 = new AdminLogIn();
		f1.setVisible(true);

	}

}
