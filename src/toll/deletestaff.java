package toll;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class deletestaff {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deletestaff window = new deletestaff();
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
	public deletestaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Delete Staff");
		frame.setBounds(110, 264, 1700, 760);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 0, 50));
		panel.setBounds(314, 34, 1187, 69);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Delete Staff"
				+ "");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Droid Serif", Font.BOLD, 27));
		label.setBounds(12, 10, 1163, 45);
		panel.add(label);
		
		JLabel lblDeleteByStaff = new JLabel("Delete By Staff ID");
		lblDeleteByStaff.setForeground(new Color(0, 0, 0));
		lblDeleteByStaff.setBounds(337, 254, 1057, 38);
		frame.getContentPane().add(lblDeleteByStaff);
		
		textField = new JTextField();
		textField.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(335, 318, 1187, 44);
		frame.getContentPane().add(textField);
		
		JButton button = new JButton("DELETE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				String id=textField.getText();
				try {
					Connection con= null;
					con =connection.getDBconnection();
					Statement stmt = con.createStatement();
					int result=stmt.executeUpdate("delete from staff where staffid='"+id+"'");
			 
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
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Droid Serif", Font.PLAIN, 16));
		button.setBackground(Color.RED);
		button.setBounds(814, 417, 176, 38);
		frame.getContentPane().add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 1700, 760);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img));
		frame.getContentPane().add(label_1);
	}
}
