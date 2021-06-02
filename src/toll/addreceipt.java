package toll;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;

public class addreceipt {

	private JFrame frame;
	private JTextField vname;
	private JTextField oname;
	private JTextField regno;
	private JTextField vcity;
	private JTextField txtcost;
	private JTextField rid;
	private JComboBox combocat,combolane,combotrip;
	private JLabel lblStaffId;
	private JTextField staffid;
	private JButton btnCancel;
	private JLabel label;
	static int cost24567;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addreceipt window = new addreceipt();
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
	public addreceipt() {
		initialize();
		category();
	}
public void  category() {
	try {
		Connection con= null;
			con =connection.getDBconnection();
			Statement stmt = con.createStatement();
			String selectquery="select vcat from category";
			ResultSet rs=stmt.executeQuery(selectquery);
			while(rs.next())
			{
				combocat.addItem(rs.getString("vcat"));
			}
	}
	catch(Exception e)
	{
		
	}
}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Receipt");
		frame.setBounds(110, 274, 1700, 760);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVehicleCategory = new JLabel("Vehicle Category");
		lblVehicleCategory.setFont(new Font("Dialog", Font.BOLD, 21));
		lblVehicleCategory.setForeground(Color.BLACK);
		lblVehicleCategory.setBounds(112, 22, 628, 45);
		frame.getContentPane().add(lblVehicleCategory);
		
		 combocat = new JComboBox();
		 combocat.addPopupMenuListener(new PopupMenuListener() {
		 	public void popupMenuCanceled(PopupMenuEvent arg0) {
	 			
			
		 	}
		 	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
		 		String id1=(String) combocat.getSelectedItem();
				//String mob1=staffnametxt.getText();
         		
				//System.out.println(id1);
				try
	     		{
					Connection con= null;
					con =connection.getDBconnection();
					Statement stmt = con.createStatement();
					ResultSet rs=stmt.executeQuery("select cost from category where vcat= '"+id1+"'");
				if(rs.next())
				{
	         		
					
					String cat=rs.getString(1);
					
				
				txtcost.setText(cat);
				}
	 			
	 		}

         		catch (Exception e) {
		              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		 	}
		 	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
		 	}
		 });
		 combocat.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		combocat.setBounds(112, 68, 628, 45);
		frame.getContentPane().add(combocat);
		
		 combolane = new JComboBox();
		 combolane.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		 combolane.setModel(new DefaultComboBoxModel(new String[] {"Lane no-1", "Lane no-2", "Lane no-3", "Lane no-4"}));
		combolane.setBounds(112, 181, 628, 45);
		frame.getContentPane().add(combolane);
		
		JLabel lblNameOfLane = new JLabel("Name of Lane");
		lblNameOfLane.setForeground(Color.BLACK);
		lblNameOfLane.setFont(new Font("Dialog", Font.BOLD, 21));
		lblNameOfLane.setBounds(112, 135, 628, 45);
		frame.getContentPane().add(lblNameOfLane);
		
		JLabel lblVehicleName = new JLabel("Vehicle Name");
		lblVehicleName.setForeground(Color.BLACK);
		lblVehicleName.setFont(new Font("Dialog", Font.BOLD, 21));
		lblVehicleName.setBounds(112, 242, 628, 45);
		frame.getContentPane().add(lblVehicleName);
		
		vname = new JTextField();
		vname.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		vname.setBounds(112, 299, 628, 45);
		frame.getContentPane().add(vname);
		vname.setColumns(10);
		
		oname = new JTextField();
		oname.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		oname.setColumns(10);
		oname.setBounds(112, 416, 628, 45);
		frame.getContentPane().add(oname);
		
		JLabel lblOwnerName = new JLabel("Owner Name");
		lblOwnerName.setForeground(Color.BLACK);
		lblOwnerName.setFont(new Font("Dialog", Font.BOLD, 21));
		lblOwnerName.setBounds(112, 359, 628, 45);
		frame.getContentPane().add(lblOwnerName);
		
		regno = new JTextField();
		regno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int position=regno.getCaretPosition();
				regno.setText(regno.getText().toUpperCase());
				regno.setCaretPosition(position);
			}
		});
		regno.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		regno.setColumns(10);
		regno.setBounds(112, 530, 628, 45);
		frame.getContentPane().add(regno);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setForeground(Color.BLACK);
		lblVehicleNumber.setFont(new Font("Dialog", Font.BOLD, 21));
		lblVehicleNumber.setBounds(112, 473, 628, 45);
		frame.getContentPane().add(lblVehicleNumber);
		
		vcity = new JTextField();
		vcity.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		vcity.setColumns(10);
		vcity.setBounds(913, 299, 663, 45);
		frame.getContentPane().add(vcity);
		
		JLabel lblVehicleCity = new JLabel("Vehicle City");
		lblVehicleCity.setForeground(Color.BLACK);
		lblVehicleCity.setFont(new Font("Dialog", Font.BOLD, 21));
		lblVehicleCity.setBounds(913, 242, 663, 45);
		frame.getContentPane().add(lblVehicleCity);
		
		txtcost = new JTextField();
		txtcost.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		txtcost.setColumns(10);
		txtcost.setBounds(913, 530, 663, 45);
		frame.getContentPane().add(txtcost);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setForeground(Color.BLACK);
		lblCost.setFont(new Font("Dialog", Font.BOLD, 21));
		lblCost.setBounds(913, 473, 663, 45);
		frame.getContentPane().add(lblCost);
		
		combotrip = new JComboBox();
		combotrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String abc=combocat.getSelectedItem().toString();
				String xyz=combotrip.getSelectedItem().toString();
				
				float cost=0;
				if(abc.contentEquals("Four Wheeler"))
				{
				if(xyz.contentEquals("One Way Trip"))
				{
					cost24567=0;
					try {
						Connection con= null;
							con =connection.getDBconnection();
							Statement stmt = con.createStatement();
							String selectquery="select cost from category where vcat='"+abc+"' ";
							ResultSet rs=stmt.executeQuery(selectquery);
							if(rs.next())
							{
						    cost24567=rs.getInt("cost");
						    txtcost.setText(""+cost24567);

							}
					}
					catch(Exception e)
					{
					  System.out.print(e);
					}
				}
				else if(abc.contentEquals("Four Wheeler"))
				{
					if(xyz.contentEquals("Two Way Trip"))
					{
						cost24567=cost24567*2;
					    txtcost.setText(""+cost24567);

					}
				}
					
				}
				
				if(abc.contentEquals("Two Wheeler"))
				{
				if(xyz.contentEquals("One Way Trip"))
				{
					cost24567=0;
					try {
						Connection con= null;
							con =connection.getDBconnection();
							Statement stmt = con.createStatement();
							String selectquery="select cost from category where vcat='"+abc+"' ";
							ResultSet rs=stmt.executeQuery(selectquery);
							if(rs.next())
							{
						    cost24567=rs.getInt("cost");
						    txtcost.setText(""+cost24567);

							}
					}
					catch(Exception e)
					{
					  System.out.print(e);
					}
				}
				else if(abc.contentEquals("Two Wheeler"))
				{
					if(xyz.contentEquals("Two Way Trip"))
					{
						cost24567=cost24567*2;
					    txtcost.setText(""+cost24567);

					}
				}
					
				}
				if(abc.contentEquals("Three Wheeler"))
				{
				if(xyz.contentEquals("One Way Trip"))
				{
					cost24567=0;
					try {
						Connection con= null;
							con =connection.getDBconnection();
							Statement stmt = con.createStatement();
							String selectquery="select cost from category where vcat='"+abc+"' ";
							ResultSet rs=stmt.executeQuery(selectquery);
							if(rs.next())
							{
						    cost24567=rs.getInt("cost");
						    txtcost.setText(""+cost24567);

							}
					}
					catch(Exception e)
					{
					  System.out.print(e);
					}
				}
				else if(abc.contentEquals("Three Wheeler"))
				{
					if(xyz.contentEquals("Two Way Trip"))
					{
						cost24567=cost24567*2;
					    txtcost.setText(""+cost24567);

					}
				}
					
				}
				
				
				if(abc.contentEquals("Six Wheeler"))
				{
				if(xyz.contentEquals("One Way Trip"))
				{
					cost24567=0;
					try {
						Connection con= null;
							con =connection.getDBconnection();
							Statement stmt = con.createStatement();
							String selectquery="select cost from category where vcat='"+abc+"' ";
							ResultSet rs=stmt.executeQuery(selectquery);
							if(rs.next())
							{
						    cost24567=rs.getInt("cost");
						    txtcost.setText(""+cost24567);

							}
					}
					catch(Exception e)
					{
					  System.out.print(e);
					}
				}
				else if(abc.contentEquals("Six Wheeler"))
				{
					if(xyz.contentEquals("Two Way Trip"))
					{
						cost24567=cost24567*2;
					    txtcost.setText(""+cost24567);

					}
				}
					
				}
				
				if(abc.contentEquals("Ten Wheeler"))
				{
				if(xyz.contentEquals("One Way Trip"))
				{
					cost24567=0;
					try {
						Connection con= null;
							con =connection.getDBconnection();
							Statement stmt = con.createStatement();
							String selectquery="select cost from category where vcat='"+abc+"' ";
							ResultSet rs=stmt.executeQuery(selectquery);
							if(rs.next())
							{
						    cost24567=rs.getInt("cost");
						    txtcost.setText(""+cost24567);

							}
					}
					catch(Exception e)
					{
					  System.out.print(e);
					}
				}
				else if(abc.contentEquals("Ten Wheeler"))
				{
					if(xyz.contentEquals("Two Way Trip"))
					{
						cost24567=cost24567*2;
					    txtcost.setText(""+cost24567);

					}
				}
					
				}
				
				
				
				if(abc.contentEquals("Heavy Vehicle"))
				{
				if(xyz.contentEquals("One Way Trip"))
				{
					cost24567=0;
					try {
						Connection con= null;
							con =connection.getDBconnection();
							Statement stmt = con.createStatement();
							String selectquery="select cost from category where vcat='"+abc+"' ";
							ResultSet rs=stmt.executeQuery(selectquery);
							if(rs.next())
							{
						    cost24567=rs.getInt("cost");
						    txtcost.setText(""+cost24567);

							}
					}
					catch(Exception e)
					{
					  System.out.print(e);
					}
				}
				else if(abc.contentEquals("Heavy Vehicle"))
				{
					if(xyz.contentEquals("Two Way Trip"))
					{
						cost24567=cost24567*2;
					    txtcost.setText(""+cost24567);

					}
				}
					
				}
			}
		});
		combotrip.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		combotrip.setModel(new DefaultComboBoxModel(new String[] {"One Way Trip", "Two Way Trip"}));
		combotrip.setBounds(913, 416, 663, 45);
		frame.getContentPane().add(combotrip);
		
		
		JLabel lblTrip = new JLabel("Trip");
		lblTrip.setForeground(Color.BLACK);
		lblTrip.setFont(new Font("Dialog", Font.BOLD, 21));
		lblTrip.setBounds(913, 359, 663, 45);
		frame.getContentPane().add(lblTrip);
		
		
		JLabel lblRid = new JLabel("Receipt ID");
		lblRid.setForeground(Color.BLACK);
		lblRid.setFont(new Font("Dialog", Font.BOLD, 21));
		lblRid.setBounds(913, 124, 663, 45);
		frame.getContentPane().add(lblRid);
		
		rid = new JTextField();
		rid.setColumns(10);
		rid.setBounds(913, 181, 663, 45);
		frame.getContentPane().add(rid);
		
		lblStaffId = new JLabel("Staff ID");
		lblStaffId.setForeground(Color.BLACK);
		lblStaffId.setFont(new Font("Dialog", Font.BOLD, 21));
		lblStaffId.setBounds(913, 11, 663, 45);
		frame.getContentPane().add(lblStaffId);
		
		staffid = new JTextField();
		staffid.setFont(new Font("Droid Serif", Font.PLAIN, 20));
		staffid.setColumns(10);
		staffid.setBounds(913, 68, 663, 45);
		frame.getContentPane().add(staffid);
		
		
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				LocalDate localDate = LocalDate.now();	
         		LocalDate d1=localDate;
         		String staff=staffid.getText();
         		String receiptid=rid.getText();
         		String vehiclename=vname.getText();
         		String ownername=oname.getText();
         		String vehiclecity=vcity.getText();
         		String reg=regno.getText();
         		String cost1=txtcost.getText();

         		String category=combocat.getSelectedItem().toString();
         		String trip=combotrip.getSelectedItem().toString();
         		String lane=combolane.getSelectedItem().toString();
         		
         		
         		
         		try
         		{
         			Connection con= null;
         			con =connection.getDBconnection();
         			Statement stmt = con.createStatement();
         		int result=stmt.executeUpdate("insert into receipt(staffid,laneno,receiptid,vcategory,vehiclename,ownername,vehicleno,vehiclecity,trip,cost,date)"
						+"values('"+staff+"','"+lane+"','"+receiptid+"','"+category+"','"+vehiclename+"','"+ownername+"','"+reg+"','"+vehiclecity+"','"+trip+"','"+cost1+"','"+d1+"')");
				
				
					
					if(result==1)
						JOptionPane.showMessageDialog(null,"Record Insert Successfully");
					
					 
					 else
							JOptionPane.showMessageDialog(null,"Record Insert Successfully");
					 rid.setText("");
					 vname.setText("");
					 oname.setText("");
					 vcity.setText("");
					 regno.setText("MH");
					 txtcost.setText("");
				
			
			}

         		catch (Exception e) {
		              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			
			
			
			
			
			}
		});
		btnAdd.setBounds(552, 626, 202, 45);
		frame.getContentPane().add(btnAdd);
		
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
		btnCancel.setBounds(891, 626, 202, 45);
		frame.getContentPane().add(btnCancel);
		
		label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		
		
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(label);
		
	
	
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
