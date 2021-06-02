package toll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
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

public class addpass {

	private JFrame frame;
	private JTextField vname;
	private JTextField regno;
	private JTextField aname;
	private JTextField applage;
	private JTextField addr;
	private JTextField cost;
	private JTextField passid;
	private JButton btnCancel;
	private JLabel lblNewLabel_1;
	JComboBox comboBoxcat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addpass window = new addpass();
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
	public addpass() {
		initialize();
		category();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void  category() {
		try {
			Connection con= null;
				con =connection.getDBconnection();
				Statement stmt = con.createStatement();
				String selectquery="select vcat from category";
				ResultSet rs=stmt.executeQuery(selectquery);
				while(rs.next())
				{
					comboBoxcat.addItem(rs.getString("vcat"));
				}
		}
		catch(Exception e)
		{
			
		}
	}
	private void initialize() {
		frame = new JFrame("Add Pass");
		frame.setBounds(110, 264, 1700, 760);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblPassId = new JLabel("Pass ID");
		lblPassId.setForeground(Color.BLACK);
		lblPassId.setFont(new Font("Droid Serif", Font.BOLD, 20));
		lblPassId.setBounds(98, 40, 322, 36);
		frame.getContentPane().add(lblPassId);
		
		passid = new JTextField();
		passid.setFont(new Font("URW Gothic L", Font.PLAIN, 18));
		passid.setColumns(10);
		passid.setBounds(98, 86, 589, 36);
		frame.getContentPane().add(passid);
		
		
		
		JLabel lblNewLabel = new JLabel("Vahicle Category");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(98, 148, 322, 36);
		lblNewLabel.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblVahicleName = new JLabel("Vahicle Name");
		lblVahicleName.setForeground(Color.BLACK);
		lblVahicleName.setBounds(98, 251, 322, 36);
		lblVahicleName.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblVahicleName);
		
		vname = new JTextField();
		vname.setBounds(98, 294, 589, 36);
		vname.setFont(new Font("URW Gothic L", Font.PLAIN, 18));
		vname.setColumns(10);
		frame.getContentPane().add(vname);
		
		JLabel lblVahicle = new JLabel("Vahicle Reg. Number");
		lblVahicle.setForeground(Color.BLACK);
		lblVahicle.setBounds(98, 354, 322, 36);
		lblVahicle.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblVahicle);
		
		regno = new JTextField();
		regno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int position=regno.getCaretPosition();
				regno.setText(regno.getText().toUpperCase());
				regno.setCaretPosition(position);
			}
		});
		regno.setBounds(98, 397, 589, 36);
		regno.setFont(new Font("URW Gothic L", Font.PLAIN, 18));
		regno.setColumns(10);
		frame.getContentPane().add(regno);
		
		JLabel lblValidityFrom = new JLabel("Validity From");
		lblValidityFrom.setForeground(Color.BLACK);
		lblValidityFrom.setBounds(98, 458, 322, 36);
		lblValidityFrom.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblValidityFrom);
		
		JLabel lblValidityTo = new JLabel("Validity To");
		lblValidityTo.setForeground(Color.BLACK);
		lblValidityTo.setBounds(528, 458, 322, 36);
		lblValidityTo.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblValidityTo);
		
		JLabel lblNameOfApplicant = new JLabel("Name of Applicant");
		lblNameOfApplicant.setForeground(Color.BLACK);
		lblNameOfApplicant.setBounds(971, 40, 322, 36);
		lblNameOfApplicant.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblNameOfApplicant);
		
		aname = new JTextField();
		aname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int position=aname.getCaretPosition();
				aname.setText(aname.getText().toUpperCase());
				aname.setCaretPosition(position);
			}
		});
	
		aname.setBounds(971, 86, 589, 36);
		aname.setFont(new Font("URW Gothic L", Font.PLAIN, 18));
		aname.setColumns(10);
		frame.getContentPane().add(aname);
		
		JLabel lblAgeOfApplicant = new JLabel("Age of Applicant");
		lblAgeOfApplicant.setForeground(Color.BLACK);
		lblAgeOfApplicant.setBounds(971, 143, 322, 36);
		lblAgeOfApplicant.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblAgeOfApplicant);
		
		applage = new JTextField();
		applage.setBounds(971, 186, 589, 36);
		applage.setFont(new Font("URW Gothic L", Font.PLAIN, 18));
		applage.setColumns(10);
		frame.getContentPane().add(applage);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.BLACK);
		lblGender.setBounds(971, 246, 322, 36);
		lblGender.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblGender);
		
		JLabel lblAddressOfApplicant = new JLabel("Address of Applicant");
		lblAddressOfApplicant.setForeground(Color.BLACK);
		lblAddressOfApplicant.setBounds(971, 355, 322, 36);
		lblAddressOfApplicant.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblAddressOfApplicant);
		
		addr = new JTextField();
		addr.setBounds(971, 397, 589, 36);
		addr.setFont(new Font("URW Gothic L", Font.PLAIN, 18));
		addr.setColumns(10);
		frame.getContentPane().add(addr);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setForeground(Color.BLACK);
		lblCost.setBounds(971, 458, 322, 36);
		lblCost.setFont(new Font("Droid Serif", Font.BOLD, 20));
		frame.getContentPane().add(lblCost);
		
		cost = new JTextField();
		cost.setBounds(971, 498, 589, 36);
		cost.setFont(new Font("URW Gothic L", Font.PLAIN, 18));
		cost.setColumns(10);
		frame.getContentPane().add(cost);
		comboBoxcat = new JComboBox();
			
		comboBoxcat.setBounds(98, 187, 589, 41);
		comboBoxcat.setFont(new Font("URW Gothic L", Font.PLAIN, 20));
		
		
		frame.getContentPane().add(comboBoxcat);
		
		JComboBox comboBoxgender = new JComboBox();
		comboBoxgender.setBounds(971, 289, 589, 41);
		comboBoxgender.setFont(new Font("URW Gothic L", Font.PLAIN, 20));
		comboBoxgender.addItem("Select");
		comboBoxgender.addItem("Male");
		comboBoxgender.addItem("Female");
		comboBoxgender.addItem("Other");
		frame.getContentPane().add(comboBoxgender);
		
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(398, 506, 289, 45);
		frame.getContentPane().add(dateChooser_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(73, 506, 289, 45);
		frame.getContentPane().add(dateChooser);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocalDate localDate = LocalDate.now();	
				
			
         	
         		String id=passid.getText();
         		String Name=vname.getText();
         		String reg=regno.getText();
         		String aplname=aname.getText();
         		String address=addr.getText();
         		String aplage=applage.getText();
         		String cost1=cost.getText();
         		String gender=comboBoxgender.getSelectedItem().toString();
         		String category=comboBoxcat.getSelectedItem().toString();
         		LocalDate d1=localDate;
         						
         		try
         		{
         			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			    	  String date=sdf.format(dateChooser.getDate());
			    	  SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
			    	  String date1=sdf1.format(dateChooser_1.getDate());
         			Connection con= null;
					con =connection.getDBconnection();
				Statement stmt=con.createStatement();
         		int result=stmt.executeUpdate("insert into pass(pid,category,vname,regno,vfrom,vto,aname,age,gender,address,cost)"
						+"values('"+id+"','"+category+"','"+Name+"','"+reg+"','"+date+"','"+date1+"','"+aplname+"','"+aplage+"','"+gender+"','"+address+"','"+cost1+"')");
				
					
					
					if(result==1)
						JOptionPane.showMessageDialog(null,"Record Insert Successfully");
					else
						JOptionPane.showMessageDialog(null,"fail");
         		
         		
         		
				
			
			}

         		catch (Exception e) {
		              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			
				
				
				}
		});
		btnAdd.setBounds(528, 612, 186, 41);
		frame.getContentPane().add(btnAdd);
		for(int i=2020;i<=2030;i++)
	
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==btnCancel)
				{
					frame.setVisible(false);
				}
			}
		});
		btnCancel.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		btnCancel.setBounds(883, 612, 186, 41);
		frame.getContentPane().add(btnCancel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1700, 760);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		

		

		lblNewLabel_1.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		
	}
}
