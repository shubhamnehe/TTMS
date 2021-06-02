package toll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.xml.crypto.Data;

import java.awt.Font;
import java.awt.Image;
import java.util.*;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;

import java.awt.EventQueue;
import java.awt.EventQueue;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import net.proteanit.*;
import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class addstaff {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtgmailcom;
	private JTextField textField_4;
	JComboBox gender ;
	JComboBox chckbxday,chckbxmonth,chckbxyear;
	private JPasswordField passwordField_1;
	private JTextField textField_5;
	private JTextField dob;
	 JTextField staffid1;
	 JButton btnAdd,btnCancel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addstaff window = new addstaff();
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
	public addstaff() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Staff");
		frame.setBounds(110, 250, 1700, 760);
		frame.getContentPane().setLayout(null);
		//Statement s=null;
		
		JLabel lblStaffId = new JLabel("Staff ID");
		lblStaffId.setBounds(92, 23, 287, 35);
		lblStaffId.setForeground(Color.BLACK);
		lblStaffId.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(lblStaffId);
		
		JLabel lblStaffName = new JLabel("Staff Name");
		lblStaffName.setForeground(Color.BLACK);
		lblStaffName.setBounds(91, 131, 287, 35);
		lblStaffName.setFont(new Font("Dialog", Font.BOLD, 24));
		
		frame.getContentPane().add(lblStaffName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		textField_1.setBounds(86, 175, 698, 42);
		textField_1.setForeground(Color.BLACK);
		textField_1.setBackground(Color.WHITE);
		
		textField_1.setColumns(10);
		
		frame.getContentPane().add(textField_1);
		
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setForeground(Color.BLACK);
		lblMobileNumber.setBounds(90, 229, 287, 35);
		lblMobileNumber.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(lblMobileNumber);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		textField_2.setBounds(86, 275, 698, 45);
		textField_2.setForeground(Color.BLACK);
		textField_2.setBackground(Color.WHITE);
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(92, 331, 287, 35);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(lblEmail);
	

		txtgmailcom = new JTextField();
		txtgmailcom.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		txtgmailcom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		txtgmailcom.setBounds(86, 382, 698, 45);
		txtgmailcom.setForeground(Color.BLACK);
		txtgmailcom.setBackground(Color.WHITE);
		txtgmailcom.setColumns(10);
		frame.getContentPane().add(txtgmailcom);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setBounds(91, 439, 287, 35);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		textField_4.setBounds(86, 485, 698, 45);
		textField_4.setForeground(Color.BLACK);
		textField_4.setBackground(Color.WHITE);
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(909, 120, 287, 35);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(lblPassword);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.BLACK);
		lblGender.setBounds(915, 440, 287, 35);
		lblGender.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(lblGender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.BLACK);
		lblDateOfBirth.setBounds(909, 276, 287, 35);
		lblDateOfBirth.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel label = new JLabel("Username");
		label.setForeground(Color.BLACK);
		label.setBounds(909, 23, 287, 35);
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(label);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		passwordField_1.setBounds(905, 175, 698, 42);
		passwordField_1.setForeground(Color.BLACK);
		passwordField_1.setBackground(Color.WHITE);
		frame.getContentPane().add(passwordField_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		textField_5.setBounds(905, 69, 698, 45);
		textField_5.setForeground(Color.BLACK);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		frame.getContentPane().add(textField_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(909, 343, 347, 45);
		frame.getContentPane().add(dateChooser);
		
		
		JComboBox chckbxgender = new JComboBox();
		chckbxgender.setBounds(909, 485, 698, 45);
		chckbxgender.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		chckbxgender.setModel(new DefaultComboBoxModel(new String[] {"Select", "Male", "Female", "Other"}));
		frame.getContentPane().add(chckbxgender);
		Image img1=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		
		 btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		btnAdd.setBounds(360, 621, 170, 45);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocalDate localDate = LocalDate.now();	
				staffid1.setVisible(true);
				//txtid.setVisible(false);
				//btngenerate.setVisible(false);
		

				
			
         
         		String id=staffid1.getText();
         		String name=textField_1.getText();
         		String mobno=textField_2.getText();
         		String email=txtgmailcom.getText();
         		String address=textField_4.getText();
         		String username=textField_5.getText();
         		String  pass=passwordField_1.getText();
         		String gender=chckbxgender.getSelectedItem().toString();
         		LocalDate d1=localDate;
         		
         		//System.out.println(date);
        
         		if((!Pattern.matches("(0/91)?[7-9][0-9]{9}", textField_2.getText())))
				{
					JOptionPane.showMessageDialog(null,"Please Enter Valid Mobile Number","Invalid Mobile Number",JOptionPane.ERROR_MESSAGE);
				}
         		else
         		
         		
         		
         		if((!Pattern.matches("^[a-zA-Z0-9]+[@]{1}[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txtgmailcom.getText())))
				{
					JOptionPane.showMessageDialog(null,"Please Enter Valid Email ID","Invalid Email ID",JOptionPane.ERROR_MESSAGE);
				}
         		else
         		{
         		try
         		{
         			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			    	  String date=sdf.format(dateChooser.getDate());
         			Connection con= null;
					con =connection.getDBconnection();
				Statement stmt=con.createStatement();
         		int result=stmt.executeUpdate("insert into staff(staffid,sname,mobileno,email,address,username,password,gender,dateofbirth,dateofjoin)"
						+"values('"+id+"','"+name+"','"+mobno+"','"+email+"','"+address+"','"+username+"','"+pass+"','"+gender+"','"+date+"','"+d1+"')");
				
					
					
					if(result==1)
					
						JOptionPane.showMessageDialog(null,"Record Insert Successfully");
					 staffid1.setText("");
					 textField_1.setText("");
					 textField_2.setText("");
					 txtgmailcom.setText("");
					 textField_4.setText("");
					 textField_5.setText("");
					 passwordField_1.setText("");
				
				
			
			}
         		catch (Exception e) {
		              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			
			
			
			
		
			
			
			
		}
			}
		});
		
		frame.getContentPane().add(btnAdd);
		
		
		
				
			
			
	     		
	     	
		
	
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				managestaff.main(null);
				/*LocalDate localDate = LocalDate.now();	
				
				txtid.setVisible(true);
				btngenerate.setVisible(true);
				String x=chckbxday.getSelectedItem().toString();
				String q=null;
				if(x.equals("1")  )
				{
					q="0"+1;
				}else if(x.equals("2"))
				{
					q="0"+2;
				}else if(x.equals("3"))
				{
					q="0"+3;
				}else if(x.equals("4"))
				{
					q="0"+4;
				}else if(x.equals("5"))
				{
					q="0"+5;
				}else if(x.equals("6"))
				{
					q="0"+6;
				}else if(x.equals("7"))
				{
					q="0"+7;
				}else if(x.equals("8"))
				{
					q="0"+8;
				}else if(x.equals("9"))
				{
					q="0"+9;
				}
				
				
			
         		String day=chckbxday.getSelectedItem().toString();
         		if((day.contentEquals("1"))||(day.contentEquals("2"))||(day.contentEquals("3"))||(day.contentEquals("4"))||(day.contentEquals("5"))||(day.contentEquals("6"))||(day.contentEquals("7"))||(day.contentEquals("8"))||(day.contentEquals("9")))
         		day="0"+day;
         		String month=chckbxmonth.getSelectedItem().toString();
         		String year=chckbxyear.getSelectedItem().toString();
         		String date=year+day+month;
         		String id=txtid.getText();
         		String name=textField_1.getText();
         		String mobno=textField_2.getText();
         		String email=textField_3.getText();
         		String address=textField_4.getText();
         		String username=textField_5.getText();
         		String  pass=passwordField_1.getText();
         		String gender=chckbxgender.getSelectedItem().toString();
         		LocalDate d1=localDate;
         		
         		//System.out.println(date);
         		
         		try
         		{
         			Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/ttms","postgres","");
					Statement stmt=con.createStatement();
					int result = stmt.executeUpdate("update staff set staffid='"+id+"',sname='"+name+"',mobileno='"+mobno+"',email='"+email+"',address='"+address+"',username='"+username+"',password='"+pass+"',gender='"+gender+"',dateofbirth='"+date+"',dateofjoin='"+d1+"' where sname='"+name+"' and staffid='"+id+"' ");
					
					
					if(result==1)
						JOptionPane.showMessageDialog(null,"Record Update Successfully");
					else
						JOptionPane.showMessageDialog(null,"fail");
         		
         		
         		
				
			
			}
			catch(Exception ke)
			{
				ke.printStackTrace();
			}
			
			
			
			*/
			
				
				
			}
		});
		btnUpdate.setBounds(699, 621, 170, 45);
		frame.getContentPane().add(btnUpdate);
		
		staffid1 = new JTextField();
		staffid1.setForeground(Color.BLACK);
		staffid1.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		staffid1.setColumns(10);
		staffid1.setBackground(Color.WHITE);
		staffid1.setBounds(86, 55, 698, 45);
		//staffid1.setVisible(false);
		frame.getContentPane().add(staffid1);
		
		 btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancel)
				{
					frame.setVisible(false);
				}
			}
		});
		btnCancel.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		btnCancel.setBounds(1030, 621, 170, 45);
		frame.getContentPane().add(btnCancel);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 1700, 760);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img));
		frame.getContentPane().add(label_1);
		
	  
	}
}
	

	
	





