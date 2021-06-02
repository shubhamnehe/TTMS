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

public class deletereceipt {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deletereceipt window = new deletereceipt();
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
	public deletereceipt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Delete Receipt");
		frame.setBounds(110, 294, 1700, 760);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(265, 38, 1187, 69);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 0, 50));
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Delete Receipt");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Droid Serif", Font.BOLD, 27));
		label.setBounds(12, 10, 1163, 45);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Delete By Receipt ID ");
		label_1.setBounds(265, 113, 1057, 38);
		label_1.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Droid Serif", Font.PLAIN, 18));
		textField.setBounds(265, 155, 1187, 44);
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		JButton button = new JButton("DELETE");
		button.setBounds(784, 228, 176, 38);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String id=textField.getText();
				try {
					Connection con= null;
					con =connection.getDBconnection();
					Statement stmt = con.createStatement();
					int result=stmt.executeUpdate("delete from receipt where receiptid='"+id+"' ");
			

				 
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
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1700, 760);
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel);
	}
}
