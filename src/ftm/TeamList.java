package ftm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TeamList extends JFrame {
	
	private Container c;
	private JLabel logoLbl,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	private ImageIcon logo, icon;
	private Font fnt1,fnt2,fnt3;
	private Cursor cursor;
	private String cloumnNames[] = {"SL","Team Name"};
	private JTable table;
	private JScrollPane scroll;
	
	TeamList(){
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
		fnt3 = new Font("Montserrat",Font.BOLD,16);
		
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
		
		lbl4 = new JLabel("Team Information");
		lbl4.setForeground(Color.WHITE);
		lbl4.setBounds(87,108,195,24);
		lbl4.setFont(fnt1);
		c.add(lbl4);
		
		lbl5 = new JLabel("See Player List");
		lbl5.setBounds(110,500,110,17);
		lbl5.setForeground(Color.WHITE);
		lbl5.setFont(fnt2);
		c.add(lbl5);
		
		lbl6 = new JLabel("Here");
		lbl6.setBounds(215,500,128,17);
		lbl6.setForeground(Color.WHITE);
		lbl6.setFont(fnt2);
		lbl6.setCursor(cursor);
		Font lbl6Fnt = lbl6.getFont();
		Map attributes1 = lbl6Fnt.getAttributes();
		attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lbl6.setFont(lbl6Fnt.deriveFont(attributes1));
		c.add(lbl6);
		
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
		scroll.setBounds(25,140,312,350);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		c.add(scroll);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ftm","root", "");
			
			Statement stn = cn.createStatement();
			
			String sql = "select * from teaminfo";
			
			ResultSet rs = stn.executeQuery(sql);
			while(rs.next()) {
				String sl = rs.getString("SL");
				String tName = rs.getString("TeamName");
				model.addRow(new Object[] {sl,tName});
			}
		
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable target = (JTable)e.getSource();
				System.out.println(""+target);
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
		
		lbl6.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				PlayerList newFrame1 = new PlayerList();
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
		TeamList f = new TeamList();
		f.setVisible(true);

	}

}
