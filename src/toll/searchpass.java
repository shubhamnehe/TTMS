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
import javax.swing.UIManager;

public class searchpass {

	private JFrame frame,frm2;
	private JTextField textField;
JTable table2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchpass window = new searchpass();
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
	public searchpass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Search Pass");
		frame.setBounds(110, 250, 1700, 760);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 50));
		panel.setBounds(249, 5, 1187, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("       Search Pass");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Droid Serif", Font.BOLD, 27));
		lblNewLabel.setBounds(12, 10, 1163, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search By  Applicant Name / Vehicle Reg. Number");
		lblNewLabel_1.setForeground(UIManager.getColor("CheckBox.foreground"));
		lblNewLabel_1.setBounds(248, 88, 1057, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		textField.setBounds(249, 133, 1187, 44);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				  if(e.getSource()==btnSearch)//display
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
					            String query="select * from pass where aname=? or regno=? ";
							     PreparedStatement stmt1=((Connection) con).prepareStatement(query);
							   //  stmt.setInt(1,Integer.parseInt(textField.getText()));
							     stmt1.setString(1, textField.getText());
							     stmt1.setString(2, textField.getText());
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
					              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
					        }
					}
				
				
			
			}
			
		});
		btnSearch.setBounds(768, 194, 176, 38);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 1700, 760);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel_2);
		table2 = new JTable();

	}
}
