package toll;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class deletepass {

	protected static int ResultSet = 0;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deletepass window = new deletepass();
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
	public deletepass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Delete Pass");
		frame.setBounds(110, 250, 1700, 760);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 50));
		panel.setBounds(249, 5, 1187, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Pass");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Droid Serif", Font.BOLD, 27));
		lblNewLabel.setBounds(12, 10, 1163, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Delete By Pass ID");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(248, 88, 1057, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		textField.setBounds(249, 133, 1187, 44);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("DELETE");
		btnSearch.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setBackground(Color.RED);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
	
				
			}
		});
		btnSearch.setBounds(768, 194, 176, 38);
		frame.getContentPane().add(btnSearch);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1700, 760);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		frame.getContentPane().add(label);
		Image img1=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
	}
	public class demo1 extends KeyAdapter
	{
	public void keyReleased(KeyEvent ke)
		
		{
			if(ke.getSource()==textField)
			{
			if(ke.getKeyText(ke.getKeyCode())=="Enter")
			{
}
			String id=textField.getText();
			try {
				Connection con= null;
				con =connection.getDBconnection();
				Statement stmt = con.createStatement();
				int result=stmt.executeUpdate("delete from pass where pid='"+id+"' ");
		 
			//System.out.println(id);
			if(result==1)
				JOptionPane.showMessageDialog(null, "Record Delete Successfully");
			else
				JOptionPane.showMessageDialog(null, "Fail");

			
			}
		 

     		catch (Exception e) {
	              JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
	        }
			
			}
		}
	}
}
