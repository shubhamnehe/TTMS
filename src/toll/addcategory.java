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

public class addcategory {

	private JFrame frame;
	JComboBox gender ;
	JComboBox chckbxday,chckbxmonth,chckbxyear;
	private JTextField textField_5;
	private JTextField dob;
	 JTextField staffid1;
	 JButton btnAdd,btnCancel;
	 private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addcategory window = new addcategory();
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
	public addcategory() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Category");
		frame.setBounds(110, 250, 1700, 760);
		frame.getContentPane().setLayout(null);
		//Statement s=null;
		
		JLabel lblStaffId = new JLabel("Vehicle Category");
		lblStaffId.setBounds(525, 179, 287, 35);
		lblStaffId.setForeground(Color.BLACK);
		lblStaffId.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(lblStaffId);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setForeground(Color.BLACK);
		lblCost.setBounds(529, 291, 287, 35);
		lblCost.setFont(new Font("Dialog", Font.BOLD, 24));
		frame.getContentPane().add(lblCost);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		textField_5.setBounds(525, 337, 698, 45);
		textField_5.setForeground(Color.BLACK);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		frame.getContentPane().add(textField_5);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(525, 103, 698, 45);
		frame.getContentPane().add(textField);
				
		 btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		btnAdd.setBounds(589, 497, 170, 45);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocalDate localDate = LocalDate.now();	
			
				//txtid.setVisible(false);
				//btngenerate.setVisible(false);
		

				
			
         		String id=textField.getText();
         
         		String cat=staffid1.getText();
         	
         		String cost=textField_5.getText();
         	
         		LocalDate d1=localDate;
         		
         		//System.out.println(date);
        
         		{
         		try
         		{
         			
         			Connection con= null;
					con =connection.getDBconnection();
				Statement stmt=con.createStatement();
         		int result=stmt.executeUpdate("insert into category(id,vcat,date,cost)"
						+"values('"+id+"','"+cat+"','"+d1+"','"+cost+"')");
				
					
					
					if(result==1)
					
						JOptionPane.showMessageDialog(null,"Record Insert Successfully");
					 staffid1.setText("");
					 textField_5.setText("");
					 textField.setText("");
				
				
			
			}
         		catch (Exception e) {
		              JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		        }
			
			
			
			
		
			
			
			
		}
			}
		});
		
		frame.getContentPane().add(btnAdd);
		
		
		
				
			
			
	   
		
		staffid1 = new JTextField();
		staffid1.setForeground(Color.BLACK);
		staffid1.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		staffid1.setColumns(10);
		staffid1.setBackground(Color.WHITE);
		staffid1.setBounds(519, 222, 698, 45);
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
		btnCancel.setBounds(1002, 497, 170, 45);
		frame.getContentPane().add(btnCancel);
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 1700, 760);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		
	
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Dialog", Font.BOLD, 24));
		lblId.setBounds(531, 60, 287, 35);
		frame.getContentPane().add(lblId);
		label_1.setIcon(new ImageIcon(img));
		frame.getContentPane().add(label_1);		
	  
	}
}
	

	
	





