package toll;

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

import java.util.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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

import com.toedter.calendar.JDateChooser;

public class report {

	private JFrame frame,frm2;
	JTable table2;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report window = new report();
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
	public report() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Report Pass");
		frame.setBounds(110, 264, 1700, 760);
		frame.getContentPane().setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(39, 27, 231, 39);
		frame.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(356, 27, 231, 39);
		frame.getContentPane().add(dateChooser_1);
		
		textField = new JTextField();
		textField.setBounds(49, 83, 221, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(366, 78, 221, 30);
		frame.getContentPane().add(textField_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				 textField.setText(sdf.format(dateChooser.getDate()));
				 
				 SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
				 textField_1.setText(sdf1.format(dateChooser_1.getDate()));

			}
		});
		btnSubmit.setBounds(676, 24, 103, 25);
		frame.getContentPane().add(btnSubmit);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				

				  if(e.getSource()==btnNewButton)//display
					{
					  String[] columnNames2 = {"Pass ID"," Category","Vehicle Name","Vehicle Reg. No","Valid From","Valid To","Applicant Name","Age","Gender","Address","Cost"};

					    String pid = "",category="",vname="",regno="",vfrom="",vto="",aname="",age="",gender="",address="",cost=""; 
					frm2=new JFrame("Pass Information");
					frm2.setFont(new Font("Droid Serif", Font.PLAIN, 40));

					frm2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					frm2.getContentPane().setLayout(new BorderLayout());
					        DefaultTableModel model2 = new DefaultTableModel();
					        model2.setColumnIdentifiers(columnNames2);
					        table2 = new JTable();
							table2.setFont(new Font("Droid Serif", Font.PLAIN, 16));


					        table2.setModel(model2);
					        table2.setRowHeight(30);
					        table2.setRowHeight(3, 60);
							table2.setBorder(new LineBorder(new Color(0, 0, 0), -1));
							

							TableColumnModel columnModel = table2.getColumnModel();
							columnModel.getColumn(0).setPreferredWidth(30);
							columnModel.getColumn(1).setPreferredWidth(130);
							columnModel.getColumn(2).setPreferredWidth(80);
							columnModel.getColumn(3).setPreferredWidth(100);
							columnModel.getColumn(4).setPreferredWidth(100);
							columnModel.getColumn(5).setPreferredWidth(100);
							columnModel.getColumn(6).setPreferredWidth(200);
							columnModel.getColumn(7).setPreferredWidth(50);
							columnModel.getColumn(8).setPreferredWidth(50);
							columnModel.getColumn(9).setPreferredWidth(140);
							columnModel.getColumn(10).setPreferredWidth(70);


					

					        JScrollPane scroll2 = new JScrollPane(table2);


					        scroll2.setHorizontalScrollBarPolicy(
					                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

					        scroll2.setVerticalScrollBarPolicy(
					                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					      try {
					    	    ResultSet rs;
					    	    Statement st;
					    	    PreparedStatement ps;
					    		Connection con= null;
								con =connection.getDBconnection();
							Statement stmt=con.createStatement();
					            String query="select * from pass where vfrom between(?,?)";
							     PreparedStatement stmt1=((Connection) con).prepareStatement(query);
							   //  stmt.setInt(1,Integer.parseInt(textField.getText()));
							     stmt1.setString(1, textField.getText());
							     stmt1.setString(2, textField_1.getText());
							     ResultSet rs1=stmt1.executeQuery();



						            while (rs1.next()) {
						                pid = rs1.getString(1);
						                category = rs1.getString(2);
						                vname = rs1.getString(3);
						                regno = rs1.getString(4);
						                vfrom = rs1.getString(5);
						                vto = rs1.getString(6);
						                aname = rs1.getString(7);
						                age = rs1.getString(8);
						                gender = rs1.getString(9);
						                address = rs1.getString(10);
						                cost = rs1.getString(11);
						                model2.addRow(new Object[]{pid,category,vname,regno,vfrom,vto,aname,age,gender,address,cost});          

					            }  
					            
					frm2.getContentPane().add(scroll2);

					frm2.setVisible(true);
					frm2.setBounds(160, 544, 1600, 430);
					}


			         		catch (Exception ae) {
					              JOptionPane.showMessageDialog(null, ae);
					        }
					}
				 
			
			}
		});
		btnNewButton.setBounds(686, 61, 103, 25);
		frame.getContentPane().add(btnNewButton);
	
	}
}
