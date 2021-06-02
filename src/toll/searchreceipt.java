package toll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class searchreceipt {

	private JFrame frame,frm2;
	private JTextField textField;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchreceipt window = new searchreceipt();
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
	public searchreceipt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Search Receipt");
		frame.setBounds(110, 250, 1700, 760);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 50));
		panel.setBounds(249, 5, 1187, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("       Search Receipt");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Droid Serif", Font.BOLD, 27));
		lblNewLabel.setBounds(12, 10, 1163, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search By Owner Name / Vehicle Reg. number");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(248, 88, 1057, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		textField.setBounds(249, 133, 1187, 44);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				  if(e.getSource()==btnSearch)//display
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
					        table2.setRowHeight(30);
					        table2.setRowHeight(3, 60);
							table2.setFont(new Font("Droid Serif", Font.PLAIN, 16));


					        table2.setModel(model2);
					        
							table2.setBorder(new LineBorder(new Color(0, 0, 0), -1));
						//	table2.setColumnModel(null);
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

					       // table2.setFillsViewportHeight(true);

					        JScrollPane scroll2 = new JScrollPane(table2);


					        scroll2.setHorizontalScrollBarPolicy(
					                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

					        scroll2.setVerticalScrollBarPolicy(
					                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					      try {
					    	    ResultSet rs;
					    	    Statement st;
					    		Connection con= null;
								con =connection.getDBconnection();
							Statement stmt=con.createStatement();
					            String query="select * from receipt where ownername=? or vehicleno=? ";
							     PreparedStatement stmt1=con.prepareStatement(query);
							  stmt1.setString(1, textField.getText());
							   stmt1.setString(2, textField.getText());
							  // stmt1.setInt(1, Integer.parseInt(textField.getText()));
							   ResultSet rs1=stmt1.executeQuery();


					            while (rs1.next()) {
					                staffid = rs1.getString(1);
					                receiptid = rs1.getString(3);
					                laneno = rs1.getString(2);
					                vcategory = rs1.getString(4);
					                vehiclename = rs1.getString(5);
					                ownername = rs1.getString(6);
					                vehicleno = rs1.getString(7);
					                vehiclecity = rs1.getString(8);
					                trip = rs1.getString(9);
					                cost = rs1.getString(10);
					                date = rs1.getString(11);
					                model2.addRow(new Object[]{staffid,receiptid,laneno,vcategory,vehiclename,ownername,vehicleno,vehiclecity,trip,cost,date});          

					            }  
					            
					frm2.getContentPane().add(scroll2);

					frm2.setVisible(true);
					frm2.setBounds(160, 544, 1600, 430);
					}


			         		catch (Exception ae) {
					              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
					        }
					}
				
				
			
			
			}
			
		});
		btnSearch.setBounds(768, 194, 176, 38);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(lblNewLabel_2);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));

		//JScrollPane scrollPane = new JScrollPane();
	//	scrollPane.setBounds(153, 379, 1010, 244);
		//frame.getContentPane().add(scrollPane);
		
		table2 = new JTable();
		//scrollPane.setViewportView(table2);
	}
}
