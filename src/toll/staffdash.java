package toll;

import java.awt.EventQueue;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class staffdash {

	private JFrame frame,frm;
	JTable table;JLabel lblClock;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffdash window = new staffdash();
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
	public staffdash() {
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
		panel.setBounds(375, 26, 1262, 113);
		frame.getContentPane().add(panel);
		panel.setBackground(new Color(0, 0, 0, 50));

		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("URW Chancery L", Font.BOLD, 99));
		lblWelcome.setForeground(Color.BLACK);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(12, 12, 1238, 88);
		panel.add(lblWelcome);

		 lblClock = new JLabel("");
		 lblClock.setForeground(Color.BLACK);
		 lblClock.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		 lblClock.setBounds(12, 12, 338, 42);
		 frame.getContentPane().add(lblClock);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 151, 1853, 841);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("Button.border"));
		tabbedPane.addTab("", null, panel_1, null);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(47, 0, 497, 31);
		panel_1.add(menuBar);
		
		JMenuItem mntmAddReceipt = new JMenuItem("Add Receipt");
		mntmAddReceipt.setBackground(new Color(224, 255, 255));
		mntmAddReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			addreceipt.main(null);
			}
		});
		mntmAddReceipt.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(mntmAddReceipt);
		
		JMenuItem mntmDetailOfReceipt = new JMenuItem("Detail of Receipt");
		mntmDetailOfReceipt.setBackground(new Color(224, 255, 255));
		mntmDetailOfReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				
				  if(ae.getSource()==mntmDetailOfReceipt)//display
					{
					  String[] columnNames = {"Staff ID","Lane No","Receipt ID","Vehicle Category","Vehicle Name","Owner Name","Vehicle No","Vehicle City","Trip","Cost","Date"};

					    String staffid = "",laneno="",receiptid="",vcategory="",vehiclename="",ownername="",vehicleno="",vehiclecity="",trip="",cost="",date=""; 
					frm=new JFrame("Receipt Information");
					frm.setFont(new Font("Droid Serif", Font.PLAIN, 40));

					frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					frm.getContentPane().setLayout(new BorderLayout());
					        DefaultTableModel model = new DefaultTableModel();
					        model.setColumnIdentifiers(columnNames);
					        table = new JTable();
							table.setFont(new Font("Droid Serif", Font.PLAIN, 16));


					        table.setModel(model);
					        table.setRowHeight(40);
					        table.setRowHeight(3, 60);
							
							table.setBorder(new LineBorder(new Color(0, 0, 0), 1));

							TableColumnModel columnModel = table.getColumnModel();
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

					        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

					        table.setFillsViewportHeight(true);

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
					    		Statement stmt = con.createStatement();

					            rs = stmt.executeQuery("select * from receipt");

					            while (rs.next()) {
					                staffid = rs.getString(1);
					                laneno = rs.getString(2);
					                receiptid = rs.getString(3);
					                vcategory = rs.getString(4);
					                vehiclename = rs.getString(5);
					                ownername = rs.getString(6);
					                vehicleno = rs.getString(7);
					                vehiclecity = rs.getString(8);
					                trip = rs.getString(9);
					                cost = rs.getString(10);
					                date = rs.getString(11);

					                model.addRow(new Object[]{staffid,laneno,receiptid,vcategory,vehiclename,ownername,vehicleno,vehiclecity,trip,cost,date});          

					            }  
					            
					frm.getContentPane().add(scroll);

					frm.setVisible(true);
					frm.setBounds(110, 294, 1700, 740);
					}

					catch (Exception e) {
					              JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
					        }
					}
				
				
			//receiptdetail.main(null);
			}
		});
		
		JSeparator separator = new JSeparator();
		menuBar.add(separator);
		mntmDetailOfReceipt.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(mntmDetailOfReceipt);
		
		JMenuItem menuItem = new JMenuItem("Delete Receipt");
		menuItem.setBackground(new Color(224, 255, 255));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletereceipt.main(null);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		menuBar.add(separator_1);
		menuItem.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar.add(menuItem);
		
		JLabel label = new JLabel("Toll Tax Management Sysytem @2020");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Dialog", Font.BOLD, 17));
		label.setBounds(530, 757, 739, 45);
		panel_1.add(label);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 0, 30));
		panel_2.setBounds(380, 177, 1165, 475);
		panel_1.add(panel_2);
		
		JLabel label_3 = new JLabel("  Toll  Tax  Management   System....");
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("URW Chancery L", Font.BOLD, 55));
		label_3.setBounds(54, 63, 1054, 342);
		panel_2.add(label_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(img));
		label_2.setBounds(0, 0, 1858, 814);
		panel_1.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 1920, 1080);
		Image img1=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		
		JButton button = new JButton("Log Out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			toll.main(null);
			}
		});
		button.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		button.setBounds(1811, 12, 103, 25);
		frame.getContentPane().add(button);
		label_1.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(label_1);
	}
}
