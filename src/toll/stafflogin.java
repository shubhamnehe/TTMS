package toll;

import java.awt.EventQueue;
import staffreset.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import toll.login.demo1;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class stafflogin {

	private JFrame frame;
	private JTextField usertxt;
	private JPasswordField passtxt;
	JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stafflogin window = new stafflogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void clock()
	{
		Thread clock=new Thread()
		{
			public  void run()
			{
				try {
					for(;;){
					Calendar cal=new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH+2);
					int year=cal.get(Calendar.YEAR);
					int date = year+month+day;

					int second=cal.get(Calendar.SECOND);
					int minute=cal.get(Calendar.MINUTE);
					int hour=cal.get(Calendar.HOUR);
				
					 lblClock.setText("Time  "+hour+":"+minute+":"+second+"  Date  "+year+"/"+month+"/"+day);
				//System.out.println(month);
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
			clock.start();	
		}
	/**
	 * Create the application.
	 */
	public stafflogin() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 0, 30));
		panel.setBounds(534, 287, 846, 543);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("STAFF LOGIN");
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("URW Chancery L", Font.BOLD, 40));
		label.setBounds(161, 28, 492, 84);
		panel.add(label);
		
		JLabel lblEnterUsernameid = new JLabel("Enter Username/ID");
		lblEnterUsernameid.setForeground(Color.BLACK);
		lblEnterUsernameid.setFont(new Font("Droid Serif", Font.BOLD, 20));
		lblEnterUsernameid.setBounds(243, 155, 301, 41);
		panel.add(lblEnterUsernameid);
		
		usertxt = new JTextField();
		usertxt.setColumns(10);
		usertxt.setBounds(243, 208, 301, 41);
		usertxt.addKeyListener(new demo1());

		panel.add(usertxt);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Droid Serif", Font.BOLD, 20));
		label_2.setBounds(243, 261, 301, 41);
		panel.add(label_2);
		
		passtxt = new JPasswordField();
		passtxt.setBounds(243, 314, 301, 41);
		passtxt.addKeyListener(new demo1());

		panel.add(passtxt);
		
		JButton button = new JButton("Login");
		button.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) 
			{
				
	
				}
			
		});
		button.setBounds(204, 426, 140, 41);
		button.addKeyListener(new demo1());

		panel.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_1)
				{
					toll.main(null);
					frame.setVisible(false);
				}
			}
		});
		button_1.setBounds(468, 426, 140, 41);
		panel.add(button_1);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setForeground(Color.BLUE);
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Reset.main(null);
			}
		});
		lblForgotPassword.setFont(new Font("Droid Serif", Font.BOLD, 20));

		lblForgotPassword.setBounds(661, 507, 173, 24);
		panel.add(lblForgotPassword);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 0, 50));
		panel_1.setBounds(401, 79, 1138, 141);
		frame.getContentPane().add(panel_1);
		
		JLabel label_3 = new JLabel("Toll Tax Management System");
		label_3.setForeground(Color.BLACK);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("URW Chancery L", Font.BOLD, 50));
		label_3.setBounds(12, 12, 1114, 117);
		panel_1.add(label_3);
		
		 lblClock = new JLabel("");
		 lblClock.setForeground(new Color(0, 0, 0));
		 lblClock.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		 lblClock.setBounds(12, 12, 338, 42);
		 frame.getContentPane().add(lblClock);
		
		JLabel label_4 = new JLabel("Toll Tax Management Sysytem @2020");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Dialog", Font.BOLD, 17));
		label_4.setBounds(641, 940, 739, 45);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		label_5.setIcon(new ImageIcon(img));
		label_5.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(label_5);
	}

class demo1 extends KeyAdapter
{
public void keyReleased(KeyEvent ke)
	
	{
		if(ke.getSource()==usertxt)
		{
		if(ke.getKeyText(ke.getKeyCode())=="Enter")
		{
			passtxt.requestFocus();
		}
		}
		else if(ke.getSource()==passtxt)
		{
			
			
				if(ke.getKeyText(ke.getKeyCode()) == "Enter")
				{
					 int flag=0;	
					 String uname,uname1,id,id1;
						String passwd,passwd1;
						
						uname=usertxt.getText();
						passwd=passtxt.getText();
					
					uname=usertxt.getText();
					id=usertxt.getText();
					passwd=passtxt.getText();
						try
						{
							Connection con= null;
							con =connection.getDBconnection();
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery("select staffid,username,password from staff");
						while(rs.next())
						{
							uname1 = rs.getString("username");
							passwd1 = rs.getString("password");
							 id1=rs.getString("staffid");
						
						if(uname.equals(uname1)||id.equals(id1)&&passwd.equals(passwd1))
						{
							flag=1;
							JOptionPane.showMessageDialog(null,"login success");
							staffdash.main(null);
frame.setVisible(false);
							break;
		
							
						}
						}
						if(flag==0)
						{
							
							JOptionPane.showMessageDialog(null,"login fail");
							 usertxt.setText("");
							 passtxt.setText("");
						}
						
						}

		         		catch (Exception e) {
				              JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
				        }

				}
		}
	}
}
}
