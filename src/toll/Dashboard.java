package toll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class Dashboard {

	private JFrame frame;
	JPanel panel;
	JFrame frm,frm1,frm2,frm3,frm4;
	Connection con=null;
	private JTable table,table1,table2,table3,table4;
	private JLabel lblClock,lbl;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3,textField_4,textField_5,textField_6,textField_7,textField_8,textField_9,textField_10,textField_11;

	private JScrollPane scrollPane,scrollPane1,scrollPane2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
					int month=cal.get(Calendar.MONTH);
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
	public Dashboard() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	

		
		JPanel panel = new JPanel();
		panel.setBounds(400, 12, 1159, 66);
		panel.setBackground(new Color(0, 0, 0, 50));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TTMS");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(12, 12, 1090, 42);
		lblNewLabel.setFont(new Font("URW Chancery L", Font.BOLD, 55));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(40, 110, 1850, 847);
		tabbedPane.setBackground(new Color(0, 0, 0, 50));
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		
		tabbedPane.addTab("", null, panel_1, null);
		panel_1.setBackground(new Color(0, 0, 0, 50));
		panel_1.setLayout(null);
		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(352, 19, 0, 2);
		panel_1.add(separator_13);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(307, 12, 1313, 31);
		panel_1.add(menuBar);
		
		JMenuItem mntmDashboard = new JMenuItem("Dashboard");
		mntmDashboard.setBackground(new Color(224, 255, 255));
		mntmDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dashboard1.main(null);
			}
		});
		mntmDashboard.setForeground(Color.BLACK);
		mntmDashboard.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(mntmDashboard);
		
		JSeparator separator = new JSeparator();
		menuBar.add(separator);
		
		JMenu mnStaff = new JMenu("      Staff     ");
		mnStaff.setBackground(new Color(224, 255, 255));
		mnStaff.setForeground(Color.BLACK);
		mnStaff.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(mnStaff);
		
		JMenuItem mntmAddStaff = new JMenuItem("Add Staff");
		mntmAddStaff.setBackground(new Color(224, 255, 255));
		mntmAddStaff.setFont(new Font("Dialog", Font.BOLD, 17));
		mntmAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				addstaff.main(null);
			}
		});
		mnStaff.add(mntmAddStaff);
		
		JSeparator separator_6 = new JSeparator();
		mnStaff.add(separator_6);
		
		JMenuItem staffdetails1 = new JMenuItem("Staff Details");
		staffdetails1.setBackground(new Color(224, 255, 255));
		staffdetails1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				
				  if(ae.getSource()==staffdetails1)//display
					{
					  String[] columnNames = {"Staff ID","Staff Name","Mobile Number","Email","Address","Gender","Date of Birth","Date of Join"};

					    String staffid = "",sname="",mobileno="",email="",address="",gender="",dateofbirth="",dateofjoin=""; 
					frm=new JFrame("Staff Information");
					frm.setFont(new Font("Droid Serif", Font.PLAIN, 40));
					frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					frm.getContentPane().setLayout(new BorderLayout());
				/*	JLabel lbl = new JLabel("");
					Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
					lbl.setIcon(new ImageIcon(img));
					lbl.setBounds(0, 0, 1700, 760);
					lbl.setBackground(new Color(0, 0, 0, 50));

					frm.getContentPane().add(lbl);
				 	*/
					        DefaultTableModel model = new DefaultTableModel();
					        model.setColumnIdentifiers(columnNames);
					        table = new JTable();
					        table.setRowHeight(40);
					        table.setRowHeight(3, 60);
							table.setFont(new Font("Droid Serif", Font.PLAIN, 16));
							
					        table.setModel(model);
							table.setBorder(new LineBorder(new Color(0, 0, 0), 1));



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
					    	    ResultSet rs;
					    	    Statement st;
					    	    PreparedStatement ps;
					    		Connection con= null;
								con =connection.getDBconnection();
							Statement stmt=con.createStatement();
					            rs = stmt.executeQuery("select staffid,sname,mobileno,email,address,gender,dateofbirth,dateofjoin"
					            		+ " from staff");

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
				
				
				
				
			//staffdetails.main(null);
			}
		});
		staffdetails1.setFont(new Font("Dialog", Font.BOLD, 17));
		mnStaff.add(staffdetails1);
		
		JSeparator separator_14 = new JSeparator();
		mnStaff.add(separator_14);
		
		JMenuItem mntmManageStaff = new JMenuItem("Manage Staff");
		mntmManageStaff.setBackground(new Color(224, 255, 255));
		mntmManageStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			managestaff.main(null);
			}
		});
		mntmManageStaff.setFont(new Font("Dialog", Font.BOLD, 17));
		mnStaff.add(mntmManageStaff);
		
		JSeparator separator_16 = new JSeparator();
		mnStaff.add(separator_16);
		
		JMenuItem mntmDeleteStaff = new JMenuItem("Delete Staff");
		mntmDeleteStaff.setBackground(new Color(224, 255, 255));
		mntmDeleteStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				deletestaff.main(null);
			}
		});
		mntmDeleteStaff.setFont(new Font("Dialog", Font.BOLD, 17));
		mnStaff.add(mntmDeleteStaff);
		
		JSeparator separator_1 = new JSeparator();
		menuBar.add(separator_1);
		
		JMenu mnVehicleCategory = new JMenu("Vehicle Category");
		mnVehicleCategory.setBackground(new Color(224, 255, 255));
		mnVehicleCategory.setForeground(Color.BLACK);
		mnVehicleCategory.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(mnVehicleCategory);
		

		JMenuItem mntmModifyCategory = new JMenuItem("Category Details");
		mntmModifyCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				  if(e.getSource()==mntmModifyCategory)//display
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
		mntmModifyCategory.setBackground(new Color(224, 255, 255));
		mntmModifyCategory.setFont(new Font("Dialog", Font.BOLD, 17));
		mnVehicleCategory.add(mntmModifyCategory);
		
		JSeparator separator_18 = new JSeparator();
		mnVehicleCategory.add(separator_18);
	
		JSeparator separator_2 = new JSeparator();
		menuBar.add(separator_2);
		
		JMenu mnPass = new JMenu("      Pass     ");
		mnPass.setBackground(new Color(224, 255, 255));
		mnPass.setForeground(Color.BLACK);
		mnPass.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(mnPass);
		
		JMenuItem mntmAddPass = new JMenuItem("Add Pass");
		mntmAddPass.setBackground(new Color(224, 255, 255));
		mntmAddPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) 
			{
				addpass.main(null);
			}
		});
		mntmAddPass.setFont(new Font("Dialog", Font.BOLD, 17));
		mnPass.add(mntmAddPass);
		
		JSeparator separator_8 = new JSeparator();
		mnPass.add(separator_8);
		
		JMenuItem mntmEditPass = new JMenuItem("Pass Detail");
		mntmEditPass.setBackground(new Color(224, 255, 255));
		mntmEditPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
			
				
				  if(a.getSource()==mntmEditPass)//display
					{
					
					  String[] columnNames11 = {"Pass ID"," Category","Vehicle Name","Vehicle Reg. No","Valid From","Valid To","Applicant Name","Age","Gender","Address","Cost"};

					    String pid = "",category="",vname="",regno="",vfrom="",vto="",aname="",age="",gender="",address="",cost=""; 
					frm1=new JFrame("Pass Information");
					frm1.setFont(new Font("Droid Serif", Font.PLAIN, 40));

					frm1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					frm1.getContentPane().setLayout(new BorderLayout());
					        DefaultTableModel model1 = new DefaultTableModel();
					        model1.setColumnIdentifiers(columnNames11);
					        

							textField_1 = new JTextField();
							textField_1.setVisible(false);
							textField_1.setBounds(86, 200, 698, 45);
							textField_1.setForeground(Color.BLACK);
							textField_1.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_1);
							
							
							textField_2 = new JTextField();
							textField_2.setVisible(false);

							textField_2.setBounds(86, 250, 698, 45);
							textField_2.setForeground(Color.BLACK);
							textField_2.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_2);
							
							
							textField_3 = new JTextField();
							textField_3.setVisible(false);

							textField_3.setBounds(86, 300, 698, 45);
							textField_3.setForeground(Color.BLACK);
							textField_3.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_3);
							
							textField_4 = new JTextField();
							textField_4.setVisible(false);

							textField_4.setBounds(86, 350, 698, 45);
							textField_4.setForeground(Color.BLACK);
							textField_4.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_4);


							textField_5 = new JTextField();
							textField_5.setVisible(false);

							textField_5.setBounds(86, 400, 698, 45);
							textField_5.setForeground(Color.BLACK);
							textField_5.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_5);
							
							textField_6 = new JTextField();
							textField_6.setVisible(false);

							textField_6.setBounds(86, 450, 698, 45);
							textField_6.setForeground(Color.BLACK);
							textField_6.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_6);
							
							
							textField_7 = new JTextField();
							textField_7.setVisible(false);

							textField_7.setBounds(86, 500, 698, 45);
							textField_7.setForeground(Color.BLACK);
							textField_7.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_7);
							
							
							textField_8 = new JTextField();
							textField_8.setVisible(false);

							textField_8.setBounds(86, 550, 698, 45);
							textField_8.setForeground(Color.BLACK);
							textField_8.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_8);
							
							
							textField_9 = new JTextField();
							textField_9.setVisible(false);

							textField_9.setBounds(86, 600, 698, 45);
							textField_9.setForeground(Color.BLACK);
							textField_9.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_9);
							
							
							textField_10 = new JTextField();
							textField_10.setVisible(false);

							textField_10.setBounds(86, 650, 698, 45);
							textField_10.setForeground(Color.BLACK);
							textField_10.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_10);
							
							textField_11 = new JTextField();
							textField_11.setVisible(false);

							textField_11.setBounds(86, 700, 698, 45);
							textField_11.setForeground(Color.BLACK);
							textField_11.setBackground(Color.WHITE);
							frm1.getContentPane().add(textField_11);
							
					
						
					        table1 = new JTable();

							table1.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									int i=table1.getSelectedRow();
							        TableModel model=table1.getModel();
							        textField_1.setText(model.getValueAt(i, 0).toString());
							        textField_2.setText(model.getValueAt(i, 1).toString());
							        textField_3.setText(model.getValueAt(i, 2).toString());
							        textField_4.setText(model.getValueAt(i, 3).toString());
							        textField_5.setText(model.getValueAt(i, 4).toString());
							        textField_6.setText(model.getValueAt(i, 5).toString());
							        textField_7.setText(model.getValueAt(i, 6).toString());
							        textField_8.setText(model.getValueAt(i, 7).toString());
							        textField_9.setText(model.getValueAt(i, 8).toString());
							        textField_10.setText(model.getValueAt(i, 9).toString());
							        textField_11.setText(model.getValueAt(i, 10).toString());

								}
							});

							
					    	JButton	btnprint = new JButton("Print");
				        	btnprint.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) 
								{
									try {
										textField_1.print();
										
									}
									catch (Exception e1) {
							              JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
							        }
								}
							});
				        	btnprint.setFont(new Font("Droid Serif", Font.PLAIN, 16));
				        	btnprint.setBounds(1550, 650, 100, 30);
							frm1.getContentPane().add(btnprint);
							
							
						
					        table1.setRowHeight(40);
					        table1.setRowHeight(3, 60);
							table1.setFont(new Font("Droid Serif", Font.PLAIN, 16));


					        table1.setModel(model1);

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

					   //     table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

					     //   table1.setFillsViewportHeight(true);

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

			private void setJTableColumnsWidth(JTable table, int i, int j, int k, int l, int m) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mntmEditPass.setFont(new Font("Dialog", Font.BOLD, 17));
		mnPass.add(mntmEditPass);
		
	        
	        
		JMenuItem mntmDeletePass = new JMenuItem("Delete Pass");
		mntmDeletePass.setBackground(new Color(224, 255, 255));
		mntmDeletePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			deletepass.main(null);
			
			}
		});
		
		JSeparator separator_15 = new JSeparator();
		mnPass.add(separator_15);
		mntmDeletePass.setFont(new Font("Dialog", Font.BOLD, 17));
		mnPass.add(mntmDeletePass);
		
		JSeparator separator_3 = new JSeparator();
		menuBar.add(separator_3);
		
		JMenuItem mntmDetailOfReceipt = new JMenuItem("Detail of Receipt");
		mntmDetailOfReceipt.setBackground(new Color(224, 255, 255));
		mntmDetailOfReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				  if(e.getSource()==mntmDetailOfReceipt)//display
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
						        table2.setRowHeight(40);
						        table2.setRowHeight(3, 60);

						
							table2.setBorder(new LineBorder(new Color(0, 0, 0), 1));

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
				
				
				
				
				
				//	receiptdetail.main(null);
			}
		});
		mntmDetailOfReceipt.setForeground(Color.BLACK);
		mntmDetailOfReceipt.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(mntmDetailOfReceipt);
		
		JSeparator separator_4 = new JSeparator();
		menuBar.add(separator_4);
		
		JMenuItem mntmSearch = new JMenuItem("   Search Pass ");
		mntmSearch.setBackground(new Color(224, 255, 255));
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchpass.main(null);
			}
		});
		mntmSearch.setFont(new Font("Dialog", Font.BOLD, 20));
		mntmSearch.setForeground(Color.BLACK);
		menuBar.add(mntmSearch);
		
		JMenuItem mntmSearchReaceopt = new JMenuItem("Search Receipt");
		mntmSearchReaceopt.setBackground(new Color(224, 255, 255));
		mntmSearchReaceopt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			searchreceipt.main(null);
			}
		});
		
		JSeparator separator_17 = new JSeparator();
		menuBar.add(separator_17);
		mntmSearchReaceopt.setFont(new Font("Dialog", Font.BOLD, 20));
		mntmSearchReaceopt.setForeground(Color.BLACK);
		menuBar.add(mntmSearchReaceopt);
		
		JSeparator separator_5 = new JSeparator();
		menuBar.add(separator_5);
		
		JMenu mnReportPass = new JMenu("Report Pass");
		mnReportPass.setBackground(new Color(224, 255, 255));
		mnReportPass.setForeground(Color.BLACK);
		mnReportPass.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(mnReportPass);
		
		JMenuItem mntmCount = new JMenuItem("Count");
		mntmCount.setBackground(new Color(224, 255, 255));
		mntmCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  if(e.getSource()==mntmCount)//display
					{
					  String[] columnNames3 = {"Vehicle Category"," Count","Total"};

					    String staffid = "",category="",count="",sum=""; 
					frm3=new JFrame("pass Information");
					frm3.setFont(new Font("Droid Serif", Font.PLAIN, 40));

					frm3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					frm3.getContentPane().setLayout(new BorderLayout());
					        DefaultTableModel model3 = new DefaultTableModel();
					        model3.setColumnIdentifiers(columnNames3);
					        table3 = new JTable();
					        
						
							
							textField_2 = new JTextField();
							textField_2.setFont(new Font("Droid Serif", Font.PLAIN, 20));
							textField_2.setBounds(1550, 680, 130, 30);
							textField_2.setForeground(Color.BLACK);
							textField_2.setBackground(Color.WHITE);
							textField_2.setEditable(false);
							frm3.getContentPane().add(textField_2);
							
							
							lbl=new JLabel("Total :");
								lbl.setFont(new Font("Droid Serif", Font.PLAIN, 20));
						    	lbl.setBounds(1480, 680, 100, 30);
								frm3.getContentPane().add(lbl);
							table3.setFont(new Font("Droid Serif", Font.PLAIN, 16));


					        table3.setModel(model3);
					        table3.setRowHeight(40);
					        table3.setRowHeight(3, 60);

							table3.setBorder(new LineBorder(new Color(0, 0, 0), 1));


					        table3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

					      

					        JScrollPane scroll3 = new JScrollPane(table3);


					        scroll3.setHorizontalScrollBarPolicy(
					                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

					        scroll3.setVerticalScrollBarPolicy(
					                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					      try {
					    	    ResultSet rs;
					    	    Statement st;
					    	    PreparedStatement ps;
					    		Connection con= null;
								con =connection.getDBconnection();
							Statement stmt=con.createStatement();

					            rs = stmt.executeQuery("select category,count(*),sum(cost) from pass group by category");

					            while (rs.next()) {
					                //staffid = rs.getString(1);
					                category = rs.getString(1);
					                count = rs.getString(2);
					                sum = rs.getString(3);
					              
					                model3.addRow(new Object[]{category,count,sum});          

					            }  
					            
					frm3.getContentPane().add(scroll3);

					frm3.setVisible(true);
					frm3.setBounds(110, 264, 1700, 760);
					}

					catch (Exception ea) {
					              JOptionPane.showMessageDialog(null, ea, "Error", JOptionPane.ERROR_MESSAGE);
					        }
					

							try
				     		{
								Connection con= null;
								con =connection.getDBconnection();
								Statement stmt = con.createStatement();
								ResultSet rs=stmt.executeQuery("select sum(cost) from pass");
							if(rs.next())
							{
				         		
								String total=rs.getString(1);
							
								
								textField_2.setText(total);
								
								
								//staffidtxt.setText(id);
							}
						
						}

			         		catch (Exception ae) {
					              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
					        }
					
					}
				  
				
			//count.main(null);
			}
		});
		mntmCount.setFont(new Font("Dialog", Font.BOLD, 17));
		mnReportPass.add(mntmCount);
		
		JSeparator separator_9 = new JSeparator();
		mnReportPass.add(separator_9);
		
	
		JSeparator separator_11 = new JSeparator();
		menuBar.add(separator_11);
		
		JMenu mnReportsOfReceipt = new JMenu("   Report Receipt  ");
		mnReportsOfReceipt.setBackground(new Color(224, 255, 255));
		mnReportsOfReceipt.setForeground(Color.BLACK);
		mnReportsOfReceipt.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(mnReportsOfReceipt);
		
		JMenuItem mntmCount_1 = new JMenuItem("Count");
		mntmCount_1.setBackground(new Color(224, 255, 255));
		mntmCount_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a1) {
				  if(a1.getSource()==mntmCount_1)//display
					{

				
				  String[] columnNames4 = {" Vehicle Category","Count","Total"};

				    String vcategory="",count="",sum=""; 
				frm4=new JFrame("Receipt Information");
				frm4.setFont(new Font("Droid Serif", Font.PLAIN, 40));

				frm4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frm4.getContentPane().setLayout(new BorderLayout());
				        DefaultTableModel model4 = new DefaultTableModel();
				        model4.setColumnIdentifiers(columnNames4);
				        table4 = new JTable();
				
				    	 lbl=new JLabel("Total");
				 		lbl.setFont(new Font("Droid Serif", Font.PLAIN, 20));
				    	lbl.setBounds(1480, 680, 100, 30);
						frm4.getContentPane().add(lbl);
					
					//receiptcount.main(null);
						textField_2 = new JTextField();
						textField_2.setFont(new Font("Droid Serif", Font.PLAIN, 20));
						textField_2.setBounds(1550, 680, 130, 30);
						textField_2.setForeground(Color.BLACK);
						textField_2.setBackground(Color.WHITE);
						textField_2.setEditable(false);

						frm4.getContentPane().add(textField_2);

						table4.setFont(new Font("Droid Serif", Font.PLAIN, 16));


				        table4.setModel(model4);
				        table4.setRowHeight(40);
				        table4.setRowHeight(3, 60);

						table4.setBorder(new LineBorder(new Color(0, 0, 0), 1));


				        table4.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

				        table4.setFillsViewportHeight(true);

				        JScrollPane scroll4 = new JScrollPane(table4);


				        scroll4.setHorizontalScrollBarPolicy(
				                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

				        scroll4.setVerticalScrollBarPolicy(
				                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				      try {
				    	    ResultSet rs;
				    	    Statement st;
				    	    PreparedStatement ps;
				    		Connection con= null;
							con =connection.getDBconnection();
						Statement stmt=con.createStatement();
				            rs = stmt.executeQuery("select vcategory,count(*),sum(cost) from receipt group by vcategory");

				            while (rs.next()) {
				                vcategory = rs.getString(1);
				                count = rs.getString(2);
				                sum = rs.getString(3);
				              
				                model4.addRow(new Object[]{vcategory,count,sum});          

				            }  
				            
				frm4.getContentPane().add(scroll4);

				frm4.setVisible(true);
				frm4.setBounds(110, 264, 1700, 760);
				}

				catch (Exception ea) {
				              JOptionPane.showMessageDialog(null, ea, "Error", JOptionPane.ERROR_MESSAGE);
				        }
				      
				  	
						try
			     		{
							Connection con= null;
							con =connection.getDBconnection();
							Statement stmt = con.createStatement();
							ResultSet rs=stmt.executeQuery("select sum(cost) from receipt");
						if(rs.next())
						{
			         		
							String total=rs.getString(1);
						
							
							textField_2.setText(total);
							
							
							//staffidtxt.setText(id);
						}
					
					}

		         		catch (Exception ae) {
				              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
				        }
				}
		
			}
		});
		
    		mntmCount_1.setFont(new Font("Dialog", Font.BOLD, 17));
		mnReportsOfReceipt.add(mntmCount_1);
		
		JSeparator separator_10 = new JSeparator();
		mnReportsOfReceipt.add(separator_10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(362, 135, 1165, 475);
		panel_2.setBackground(new Color(0, 0, 0, 30));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTollTaxManagement = new JLabel("  Toll  Tax  Management   System....");
		lblTollTaxManagement.setForeground(Color.BLACK);
		lblTollTaxManagement.setBounds(54, 63, 1054, 342);
		lblTollTaxManagement.setFont(new Font("URW Chancery L", Font.BOLD, 55));
		lblTollTaxManagement.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblTollTaxManagement);
		Image img1=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		
		JLabel label_2 = new JLabel("Toll Tax Management Sysytem @2020");
		label_2.setBounds(586, 763, 739, 45);
		panel_1.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JLabel label_1 = 
				new JLabel("");
		label_1.setBounds(0, 0, 1845, 820);
		Image img11=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img11));
		panel_1.add(label_1);
		
		JLabel label = new JLabel("");
		Image img111=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.RED);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toll.main(null);
				frame.setVisible(false);
			}
		});
		btnLogOut.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		btnLogOut.setBounds(1817, 4, 103, 25);
		frame.getContentPane().add(btnLogOut);
		
		 lblClock = new JLabel("clock");
		 lblClock.setForeground(Color.BLACK);
		lblClock.setBounds(12, 0, 338, 42);
		frame.getContentPane().add(lblClock);
		label.setIcon(new ImageIcon(img111));
		label.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(label);
	}
	}


