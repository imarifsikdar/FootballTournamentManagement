package ftm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PlayerList extends JFrame {
	
	private Container c;
	private JLabel logoLbl,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	private ImageIcon logo, icon;
	private Font fnt1,fnt2,fnt3;
	private Cursor cursor;
	private JTextField tf;
	private JButton btnSearch;
	private String cloumnNames[] = {"SL","Player Name"}; //"P1","P2","P3","P4","P5","P7","P8","P9","P10","P11"
	private JTable table;
	private JScrollPane scroll;
	
	PlayerList(){
		initComponents();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(3);
		this.setTitle("Team Information");
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
		fnt3 = new Font("Montserrat",Font.BOLD,10);
		
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		logo = new ImageIcon(getClass().getResource("logo.png"));
		logoLbl = new JLabel(logo);
		logoLbl.setBounds(140,0,92,50);
		c.add(logoLbl);
		
		lbl1 = new JLabel("HOME");
		lbl1.setBounds(23,78,48,17);
		lbl1.setFont(fnt2);
		lbl1.setForeground(Color.GRAY);
		lbl1.setCursor(cursor);
		c.add(lbl1);
		
		lbl2 = new JLabel("TOURNAMENT");
		lbl2.setBounds(83,78,115,17);
		lbl2.setFont(fnt2);
		lbl2.setForeground(Color.GRAY);
		lbl2.setCursor(cursor);
		c.add(lbl2);
		
		lbl3 = new JLabel("TEAM REGISTRATION");
		lbl3.setBounds(200,78,155,17);
		lbl3.setFont(fnt2);
		lbl3.setForeground(Color.GRAY);
		lbl3.setCursor(cursor);
		c.add(lbl3);
		
		lbl4 = new JLabel("Player List");
		lbl4.setForeground(Color.WHITE);
		lbl4.setBounds(125,100,195,24);
		lbl4.setFont(fnt1);
		c.add(lbl4);
		
		tf = new JTextField("Enter a Team Name");
		tf.setBounds(25,130,300,17);
		tf.setForeground(Color.WHITE);
		tf.setFont(fnt2);
		tf.setBackground(Color.BLACK);
		tf.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tf);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(250,160,70,17);
		btnSearch.setFocusPainted(false);
		btnSearch.setCursor(cursor);
		btnSearch.setFont(fnt3);
		btnSearch.setBackground(Color.WHITE);
		c.add(btnSearch);
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(cloumnNames);
		
		table = new JTable();
		table.setModel(model);
		table.setFont(fnt2);
		table.setBackground(Color.WHITE);
		table.setRowHeight(17);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(27);
		table.getColumnModel().getColumn(1).setPreferredWidth(282);
		
		
		scroll = new JScrollPane(table);
		scroll.setBounds(25,190,312,350);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		c.add(scroll);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String teamName = tf.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ftm","root", "");
					
					Statement stn = cn.createStatement();
					
					String sql = "select * from teaminfo where TeamName='"+teamName+"'";
					
					ResultSet rs = stn.executeQuery(sql);
					if(rs.next()) {
						String sl = rs.getString("SL");
						String p1 = rs.getString("P1");
						String p2 = rs.getString("P2");
						String p3 = rs.getString("P3");
						String p4 = rs.getString("P4");
						String p5 = rs.getString("P5");
						String p6 = rs.getString("P6");
						String p7 = rs.getString("P7");
						String p8 = rs.getString("P8");
						String p9 = rs.getString("P9");
						String p10 = rs.getString("P10");
						String p11 = rs.getString("P11");
						
						model.addRow(new Object[] {"1",p1});
						model.addRow(new Object[] {"2",p2});
						model.addRow(new Object[] {"3",p3});
						model.addRow(new Object[] {"4",p4});
						model.addRow(new Object[] {"5",p5});
						model.addRow(new Object[] {"6",p6});
						model.addRow(new Object[] {"7",p7});
						model.addRow(new Object[] {"8",p8});
						model.addRow(new Object[] {"9",p9});
						model.addRow(new Object[] {"10",p10});
						model.addRow(new Object[] {"11",p11});
					}
					else {
						System.out.println("No Info");
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		lbl1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				AppHome newFrame1 = new AppHome();
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
		
		lbl2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				Tournament newFrame1 = new Tournament();
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
		
		lbl3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				TeamReg newFrame1 = new TeamReg();
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
		PlayerList f = new PlayerList();
		f.setVisible(true);

	}

}
