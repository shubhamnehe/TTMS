package toll;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class dashboard1 {

	private JFrame frame;
	JFrame frm,frm1,frm2;
	Connection con=null;
	private JTable table,table1,table2;
	
	private JScrollPane scrollPane,scrollPane1,scrollPane2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard1 window = new dashboard1();
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
	public dashboard1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(110, 250, 1700, 760);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(317, 287, 362, 106);
		panel.setBackground(new Color(0, 0, 0, 50));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnStaff = new JButton("Total Staff");
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
				
				  if(ae.getSource()==btnStaff)//display
					{
					  String[] columnNames = {"Staff ID","Staff Name","Mobile Number","Email","Address","Gender","Date of Birth","Date of Join"};

					    String staffid = "",sname="",mobileno="",email="",address="",gender="",dateofbirth="",dateofjoin=""; 
					frm=new JFrame("Staff Information");
					frm.setFont(new Font("Droid Serif", Font.PLAIN, 40));

					frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					frm.getContentPane().setLayout(new BorderLayout());
					        DefaultTableModel model = new DefaultTableModel();
					        model.setColumnIdentifiers(columnNames);
					        table = new JTable();
							table.setFont(new Font("Droid Serif", Font.PLAIN, 16));


					        table.setModel(model);
							table.setBorder(new LineBorder(new Color(0, 0, 0), 1));
							   table.setModel(model);
						        table.setRowHeight(40);
						        table.setRowHeight(3, 60);
						    	TableColumnModel columnModel1 = table.getColumnModel();
								columnModel1.getColumn(0).setPreferredWidth(10);
								columnModel1.getColumn(1).setPreferredWidth(130);
								columnModel1.getColumn(2).setPreferredWidth(80);
								columnModel1.getColumn(3).setPreferredWidth(200);
								columnModel1.getColumn(4).setPreferredWidth(100);
								columnModel1.getColumn(5).setPreferredWidth(30);
								columnModel1.getColumn(6).setPreferredWidth(50);
								columnModel1.getColumn(7).setPreferredWidth(50);

					        JScrollPane scroll = new JScrollPane(table);


					        scroll.setHorizontalScrollBarPolicy(
					                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

					        scroll.setVerticalScrollBarPolicy(
					                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					      try {
					    	  Connection con;
					    	    ResultSet rs;
					    	    Statement st;
					    	    PreparedStatement ps;
					    	  Class.forName("org.postgresql.Driver");

					            con = DriverManager.getConnection("jdbc:postgresql://localhost/ttms","postgres","");

					    
					           
					            st = con.createStatement();

					            rs = st.executeQuery("select staffid,sname,mobileno,email,address,gender,dateofbirth,dateofjoin from staff");

					            while (rs.next()) {
					                staffid = rs.getString(1);
					                sname = rs.getString(2);
					                mobileno = rs.getString(3);
					                email = rs.getString(4);
					                address = rs.getString(5);
					                gender = rs.getString(6);
					                dateofbirth = rs.getString(7);
					                dateofjoin = rs.getString(8);
					                model.addRow(new Object[]{staffid,sname,mobileno,email,address,gender,dateofbirth,dateofjoin});          

					            }  
					            
					frm.getContentPane().add(scroll);

					frm.setVisible(true);
					frm.setBounds(110, 264, 1700, 760);
					}

					catch (Exception e) {
					              JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
					        }
					}
				
				
							
			}
		});
		btnStaff.setFont(new Font("URW Gothic L", Font.ITALIC, 30));
		btnStaff.setBounds(12, 12, 338, 82);
		panel.add(btnStaff);
		Image img1=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1000, 299, 362, 106);
		panel_1.setBackground(new Color(0, 0, 0, 50));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnTotalVehicleCategory = new JButton("Vehicle Category");
		btnTotalVehicleCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			
			
			

				  if(e.getSource()==btnTotalVehicleCategory)//display
					{
					  

					  String[] columnNames2 = {"ID","Vehicle Category","Date of Creation","Cost"};
					  
					    String id = "",vcat = "",date="",cost=""; 
					frm2=new JFrame("Category Information");
					frm2.setFont(new Font("Droid Serif", Font.PLAIN, 40));

					frm2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					frm2.getContentPane().setLayout(new BorderLayout());
					        DefaultTableModel model2 = new DefaultTableModel();
					        model2.setColumnIdentifiers(columnNames2);
					        table2 = new JTable();
					  
							table2.setFont(new Font("Droid Serif", Font.PLAIN, 16));
							   table2.setModel(model2);
						        table2.setRowHeight(40);
						        table2.setRowHeight(3, 100);

						
							table2.setBorder(new LineBorder(new Color(0, 0, 0), 1));

							TableColumnModel columnModel = table2.getColumnModel();
							columnModel.getColumn(0).setPreferredWidth(5);
							columnModel.getColumn(1).setPreferredWidth(400);
							columnModel.getColumn(2).setPreferredWidth(400);
							columnModel.getColumn(3).setPreferredWidth(400);
							

					      //  table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

					        //table2.setFillsViewportHeight(true);

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

					            rs = stmt.executeQuery("select * from category");

					            while (rs.next()) {
					                id = rs.getString(1);
					                vcat = rs.getString(2);
					                date = rs.getString(3);
					                cost = rs.getString(4);
					                model2.addRow(new Object[]{id,vcat,date,cost});          

					            } 
					        

					            
					frm2.getContentPane().add(scroll2);

					frm2.setVisible(true);
					frm2.setBounds(110, 264, 1700, 760);
					}

					catch (Exception ea) {
					              JOptionPane.showMessageDialog(null, ea, "Error", JOptionPane.ERROR_MESSAGE);
					        }
					}
				
				
				
			
			
			
			
			
			
			
			
			}
		});
		btnTotalVehicleCategory.setFont(new Font("URW Gothic L", Font.ITALIC, 25));
		btnTotalVehicleCategory.setBounds(12, 12, 338, 82);
		panel_1.add(btnTotalVehicleCategory);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1000, 517, 362, 106);
		panel_2.setBackground(new Color(0, 0, 0, 50));
		panel_2.setLayout(null);
		frame.getContentPane().add(panel_2);
		
		JButton btnTotalPass = new JButton("Total Pass");
		btnTotalPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
			
				  if(a.getSource()==btnTotalPass)//display
					{
					  String[] columnNames1 = {"Pass ID"," Category","Vehicle Name","Vehicle Reg. No","Valid From","Valid To","Applicant Name","Age","Gender","Address","Cost"};

					    String pid = "",category="",vname="",regno="",vfrom="",vto="",aname="",age="",gender="",address="",cost=""; 
					frm1=new JFrame("Staff Information");
					frm1.setFont(new Font("Droid Serif", Font.PLAIN, 40));

					frm1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					frm1.getContentPane().setLayout(new BorderLayout());
					        DefaultTableModel model1 = new DefaultTableModel();
					        model1.setColumnIdentifiers(columnNames1);
					        table1 = new JTable();
							table1.setFont(new Font("Droid Serif", Font.PLAIN, 16));


					        table1.setModel(model1);

					        table1.setRowHeight(40);
					        table1.setRowHeight(3, 60);
							table1.setBorder(new LineBorder(new Color(0, 0, 0), 1));


							TableColumnModel columnModel = table1.getColumnModel();
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


					        JScrollPane scroll1 = new JScrollPane(table1);


					        scroll1.setHorizontalScrollBarPolicy(
					                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

					        scroll1.setVerticalScrollBarPolicy(
					                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					      try {
					    	    ResultSet rs;
					    	    Statement st;
					    	    PreparedStatement ps;
					    		Connection con= null;
								con =connection.getDBconnection();
							Statement stmt=con.createStatement();

					            rs = stmt.executeQuery("select * from pass");

					            while (rs.next()) {
					                pid = rs.getString(1);
					                category = rs.getString(2);
					                vname = rs.getString(3);
					                regno = rs.getString(4);
					                vfrom = rs.getString(5);
					                vto = rs.getString(6);
					                aname = rs.getString(7);
					                age = rs.getString(8);
					                gender = rs.getString(9);
					                address = rs.getString(10);
					                cost = rs.getString(11);
					                model1.addRow(new Object[]{pid,category,vname,regno,vfrom,vto,aname,age,gender,address,cost});          

					            }  
					            
					frm1.getContentPane().add(scroll1);

					frm1.setVisible(true);
					frm1.setBounds(110, 264, 1700, 760);
					}

					catch (Exception e) {
					              JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
					        }
					}
				
				
				
				
				
				//passdetail.main(null);
			}
		});
		btnTotalPass.setFont(new Font("URW Gothic L", Font.ITALIC, 25));
		btnTotalPass.setBounds(12, 12, 338, 82);
		panel_2.add(btnTotalPass);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(317, 517, 362, 106);
		panel_3.setBackground(new Color(0, 0, 0, 50));
		panel_3.setLayout(null);
		frame.getContentPane().add(panel_3);
		
		JButton btnTotalReceipt = new JButton("Total Receipt");
		btnTotalReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  if(e.getSource()==btnTotalReceipt)//display
					{
					  String[] columnNames2 = {"Staff ID","Receipt ID"," Lane No","Vehicle Category","Vehicle Name","Owner Name","Vehicle No","Vehicle City","Trip","Cost","Date"};

					    String staffid = "",receiptid="",laneno="",vcategory="",vehiclename="",ownername="",vehiclecity="",vehicleno="",trip="",cost="",date=""; 
					frm2=new JFrame("Receipt Information");
					frm2.setFont(new Font("Droid Serif", Font.PLAIN, 40));

					frm2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					frm2.getContentPane().setLayout(new BorderLayout());
					        DefaultTableModel model2 = new DefaultTableModel();
					        model2.setColumnIdentifiers(columnNames2);
					        table2 = new JTable();
							table2.setFont(new Font("Droid Serif", Font.PLAIN, 16));


					        table2.setModel(model2);
							table2.setBorder(new LineBorder(new Color(0, 0, 0), 1));

							  table2.setRowHeight(40);
						        table2.setRowHeight(3, 60);

						        TableColumnModel columnModel = table2.getColumnModel();
								columnModel.getColumn(0).setPreferredWidth(30);
								columnModel.getColumn(1).setPreferredWidth(40);
								columnModel.getColumn(2).setPreferredWidth(80);
								columnModel.getColumn(3).setPreferredWidth(100);
								columnModel.getColumn(4).setPreferredWidth(100);
								columnModel.getColumn(5).setPreferredWidth(200);
								columnModel.getColumn(6).setPreferredWidth(100);
								columnModel.getColumn(7).setPreferredWidth(150);
								columnModel.getColumn(8).setPreferredWidth(150);
								columnModel.getColumn(9).setPreferredWidth(40);
								columnModel.getColumn(10).setPreferredWidth(110);


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

					            rs = stmt.executeQuery("select * from receipt");

					            while (rs.next()) {
					                staffid = rs.getString(1);
					                receiptid = rs.getString(3);
					                laneno = rs.getString(2);
					                vcategory = rs.getString(4);
					                vehiclename = rs.getString(5);
					                ownername = rs.getString(6);
					                vehicleno = rs.getString(7);
					                vehiclecity = rs.getString(8);
					                trip = rs.getString(9);
					                cost = rs.getString(10);
					                date = rs.getString(11);
					                model2.addRow(new Object[]{staffid,receiptid,laneno,vcategory,vehiclename,ownername,vehicleno,vehiclecity,trip,cost,date});          

					            }  
					            
					frm2.getContentPane().add(scroll2);

					frm2.setVisible(true);
					frm2.setBounds(110, 264, 1700, 760);
					}

					catch (Exception ea) {
					              JOptionPane.showMessageDialog(null, ea, "Error", JOptionPane.ERROR_MESSAGE);
					        }
					}
				
				
				
				
				//receiptdetail.main(null);
			}
		});
		btnTotalReceipt.setFont(new Font("URW Gothic L", Font.ITALIC, 25));
		btnTotalReceipt.setBounds(12, 12, 338, 82);
		panel_3.add(btnTotalReceipt);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(416, 63, 806, 106);
		panel_4.setBackground(new Color(0, 0, 0, 50));
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboard.setFont(new Font("URW Chancery L", Font.ITALIC, 65));
		lblDashboard.setForeground(Color.BLACK);
		lblDashboard.setBounds(12, 12, 782, 82);
		panel_4.add(lblDashboard);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1700, 760);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		frame.getContentPane().add(label);
	}
}
