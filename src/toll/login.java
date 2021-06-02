package toll;

import java.awt.Color;
import reset.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;

public class login {

	private JFrame frame;
	JTextField textField,passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(371, 90, 1138, 141);
		panel.setBackground(new Color(0, 0, 0, 50));
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Toll Tax Management System");
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("URW Chancery L", Font.BOLD, 50));
		label.setBounds(12, 12, 1114, 117);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(530, 330, 846, 543);
		panel_1.setBackground(new Color(0, 0, 0, 30));
		frame.getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("LOGIN");
		label_1.setForeground(Color.BLACK);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("URW Chancery L", Font.BOLD, 40));
		label_1.setBounds(161, 28, 492, 84);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("User Name");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		label_2.setBounds(243, 155, 301, 41);
		panel_1.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(243, 208, 301, 41);
		textField.addKeyListener(new demo1());
		panel_1.add(textField);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		label_3.setBounds(243, 261, 301, 41);
		panel_1.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(243, 314, 301, 41);
		passwordField.addKeyListener(new demo1());
		panel_1.add(passwordField);
		
		JButton button = new JButton("Login");
		button.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
			
	
				}
			
		});
		button.setBounds(204, 426, 140, 41);
		button.addKeyListener(new demo1());
		panel_1.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==button_1)
				{
					toll.main(null);
					frame.setVisible(false);
				}
			}
		});
		button_1.setBounds(468, 426, 140, 41);
		panel_1.add(button_1);
		
		JLabel label_6 = new JLabel("Forgot Password");
		Font font=label_6.getFont();
		Map attribute=font.getAttributes();
		attribute.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
		label_6.setFont(font.deriveFont(attribute));
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		Reset.main(null);
			}
		});
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("Droid Serif", Font.BOLD, 20));
		label_6.setBounds(673, 507, 173, 24);
		panel_1.add(label_6);
		
		JLabel label_4 = new JLabel("Toll Tax Management Sysytem @2020");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Dialog", Font.BOLD, 17));
		label_4.setBounds(581, 932, 739, 45);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		label_5.setIcon(new ImageIcon(img));
		label_5.setBounds(12, 0, 1920, 1080);
		frame.getContentPane().add(label_5);
	}


public class demo1 extends KeyAdapter
{
public void keyReleased(KeyEvent ke)
	
	{
		if(ke.getSource()==textField)
		{
		if(ke.getKeyText(ke.getKeyCode())=="Enter")
		{
			passwordField.requestFocus();
		}
		}
		else if(ke.getSource()==passwordField)
		{
			 int flag=0;	
				String uname1,usname;
				String pass,pwrd;
				
				uname1=textField.getText();
			    pass=passwordField.getText();
			
				if(ke.getKeyText(ke.getKeyCode()) == "Enter")
				{
				try
				
				{
					Connection con= null;
					con =connection.getDBconnection();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from login1");
				while(rs.next())
				{
					usname = rs.getString("username");
					 pwrd = rs.getString("password");
				
				
				if(uname1.equals(usname)&&pass.equals(pwrd))
				{
					flag=1;
					JOptionPane.showMessageDialog(null,"login success");
					frame.setVisible(false);
					Dashboard.main(null);
		
					break;

					
				}
				}
				if(flag==0)
				{
					
					JOptionPane.showMessageDialog(null,"login fail");
					 textField.setText("");
					 passwordField.setText("");
				}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}
		}
	}
}
}