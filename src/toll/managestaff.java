package toll;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;

public class managestaff {

	private JFrame frame;
	private JTextField staffnametxt;
	private JTextField staffidtxt;
	private JTextField mobilenotxt;
	private JTextField emailtxt;
	private JTextField addresstxt;
	private JPasswordField passtxt;
	private JTextField usernametxt;
	private JComboBox comboday,comboyear,combomonth,combogender;
	private JButton btngenerate;
	private JButton btnCancel;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managestaff window = new managestaff();
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
	public managestaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Update Staff");
		frame.setBounds(110, 264, 1700, 760);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		staffnametxt = new JTextField();
		staffnametxt.setForeground(Color.BLACK);
		staffnametxt.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		staffnametxt.setColumns(10);
		staffnametxt.setBackground(Color.WHITE);
		staffnametxt.setBounds(82, 80, 698, 45);
		frame.getContentPane().add(staffnametxt);
		
		JLabel label_1 = new JLabel("Staff Name");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Dialog", Font.BOLD, 24));
		label_1.setBounds(87, 26, 287, 35);
		frame.getContentPane().add(label_1);
		
		staffidtxt = new JTextField();
		staffidtxt.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		staffidtxt.setEditable(false);
		staffidtxt.setForeground(Color.BLACK);
		staffidtxt.setColumns(10);
		staffidtxt.setBackground(Color.WHITE);
		staffidtxt.setBounds(82, 180, 698, 42);
		frame.getContentPane().add(staffidtxt);
		
		JLabel label_2 = new JLabel("Mobile Number");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Dialog", Font.BOLD, 24));
		label_2.setBounds(86, 234, 287, 35);
		frame.getContentPane().add(label_2);
		
		mobilenotxt = new JTextField();
		mobilenotxt.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		mobilenotxt.setForeground(Color.BLACK);
		mobilenotxt.setColumns(10);
		mobilenotxt.setBackground(Color.WHITE);
		mobilenotxt.setBounds(82, 280, 698, 45);
		frame.getContentPane().add(mobilenotxt);
		
		JLabel label_3 = new JLabel("E-mail");
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("Dialog", Font.BOLD, 24));
		label_3.setBounds(88, 336, 287, 35);
		frame.getContentPane().add(label_3);
		
		emailtxt = new JTextField();
		emailtxt.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		emailtxt.setForeground(Color.BLACK);
		emailtxt.setColumns(10);
		emailtxt.setBackground(Color.WHITE);
		emailtxt.setBounds(82, 387, 698, 45);
		frame.getContentPane().add(emailtxt);
		
		JLabel label_4 = new JLabel("Address");
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("Dialog", Font.BOLD, 24));
		label_4.setBounds(87, 444, 287, 35);
		frame.getContentPane().add(label_4);
		
		addresstxt = new JTextField();
		addresstxt.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		addresstxt.setForeground(Color.BLACK);
		addresstxt.setColumns(10);
		addresstxt.setBackground(Color.WHITE);
		addresstxt.setBounds(82, 490, 698, 45);
		frame.getContentPane().add(addresstxt);
		
		JLabel label_5 = new JLabel("Password");
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("Dialog", Font.BOLD, 24));
		label_5.setBounds(905, 125, 287, 35);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Gender");
		label_6.setForeground(new Color(0, 0, 0));
		label_6.setFont(new Font("Dialog", Font.BOLD, 24));
		label_6.setBounds(911, 445, 287, 35);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Date of Birth");
		label_7.setForeground(new Color(0, 0, 0));
		label_7.setFont(new Font("Dialog", Font.BOLD, 24));
		label_7.setBounds(905, 281, 287, 35);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Username");
		label_8.setForeground(new Color(0, 0, 0));
		label_8.setFont(new Font("Dialog", Font.BOLD, 24));
		label_8.setBounds(905, 28, 287, 35);
		frame.getContentPane().add(label_8);
		
		passtxt = new JPasswordField();
		passtxt.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		passtxt.setForeground(Color.BLACK);
		passtxt.setBackground(Color.WHITE);
		passtxt.setBounds(901, 180, 698, 42);
		frame.getContentPane().add(passtxt);
		
		usernametxt = new JTextField();
		usernametxt.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		usernametxt.setForeground(Color.BLACK);
		usernametxt.setColumns(10);
		usernametxt.setBackground(Color.WHITE);
		usernametxt.setBounds(901, 74, 698, 45);
		frame.getContentPane().add(usernametxt);
		
		combogender = new JComboBox();
		combogender.setModel(new DefaultComboBoxModel(new String[] {"Select", "Male", "Female", "Other"}));
		combogender.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		combogender.setBounds(905, 490, 698, 45);
		frame.getContentPane().add(combogender);
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(903, 344, 289, 45);
		frame.getContentPane().add(dateChooser);
		
		
		JButton button = new JButton("UPDATE");
		button.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
         		String id=staffidtxt.getText();
         		String name=staffnametxt.getText();
         		String mobno=mobilenotxt.getText();
         		String email=emailtxt.getText();
         		String address=addresstxt.getText();
         		String username=usernametxt.getText();
         		String  pass=passtxt.getText();
         		String gender=combogender.getSelectedItem().toString();
         		
         		//System.out.println(date);
         		
         		try
         		{
         			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			    	  String date=sdf.format(dateChooser.getDate());
         			Connection con= null;
					con =connection.getDBconnection();
				Statement stmt=con.createStatement();
					int result = stmt.executeUpdate("update staff set staffid='"+id+"',sname='"+name+"',mobileno='"+mobno+"',email='"+email+"',address='"+address+"',username='"+username+"',password='"+pass+"',gender='"+gender+"',dateofbirth='"+date+"' where sname='"+name+"' and staffid='"+id+"' ");
					
					
					if(result==1)
						JOptionPane.showMessageDialog(null,"Record Update Successfully");
					else
						JOptionPane.showMessageDialog(null,"fail");
         		
         		
         		
				
			
			}
			catch(Exception ke)
			{
				ke.printStackTrace();
			}
			
			
			
					 		
			 		
			 	}
			 });
	
	     
	     button.setBounds(572, 616, 194, 45);
			frame.getContentPane().add(button);
		
			
			 btngenerate = new JButton("Generate Info");
			 btngenerate.setForeground(new Color(0, 0, 0));
			btngenerate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					String id1=staffnametxt.getText();
					//String mob1=staffnametxt.getText();
	         		
					//System.out.println(id1);
					try
		     		{
						Connection con= null;
						con =connection.getDBconnection();
						Statement stmt = con.createStatement();
						ResultSet rs=stmt.executeQuery("select staffid,mobileno,address,email,username,password,gender,dateofbirth from staff where sname= '"+id1+"'");
					if(rs.next())
					{
		         		
						String id=rs.getString(1);
						String mobno=rs.getString(2);
						String adderss=rs.getString(3);
						String email=rs.getString(4);
						String username=rs.getString(5);
						String pass=rs.getString(6);
						String gender=rs.getString(7);
						
						staffidtxt.setText(id);
						mobilenotxt.setText(mobno);
						addresstxt.setText(adderss);
						emailtxt.setText(email);
						usernametxt.setText(username);
						passtxt.setText(pass);
						combogender.setSelectedItem(gender);
						
						//staffidtxt.setText(id);
					}
				
				}

	         		catch (Exception e) {
			              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
			        }
					}
				
			});
			btngenerate.setFont(new Font("Droid Serif", Font.PLAIN, 15));
			btngenerate.setBounds(82, 137, 171, 24);
			frame.getContentPane().add(btngenerate);
			
			btnCancel = new JButton("CANCEL");
			btnCancel.setFont(new Font("Droid Serif", Font.PLAIN, 16));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==btnCancel)
					{
						frame.setVisible(false);
					}
				}
			});
			btnCancel.setBounds(906, 616, 194, 45);
			frame.getContentPane().add(btnCancel);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(0, 0, 1700, 760);
			Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
			frame.getContentPane().add(lblNewLabel);
			
			
		
	}
}
