package toll;


import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class toll {

	private JFrame frame;
	private JPanel panel;
	JLabel label_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					toll window = new toll();
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
				
					label_5.setText("Time  "+hour+":"+minute+":"+second+"  Date  "+year+"/"+month+"/"+day);
				
					
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
	public toll() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(384, 142, 1200, 137);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 0, 50));
		frame.getContentPane().add(panel_1);
		
		JLabel label = new JLabel("      TTMS");
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("URW Chancery L", Font.BOLD, 38));
		label.setBounds(12, 41, 213, 69);
		panel_1.add(label);
		
		JButton button = new JButton("HOME");
		button.setFont(new Font("Dialog", Font.BOLD, 20));
		button.setForeground(Color.RED);
		button.setBackground(new Color(0, 0, 0, 20));
		button.setBounds(520, 41, 166, 48);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Admin");
		button_1.setForeground(Color.LIGHT_GRAY);
		button_1.setFont(new Font("Dialog", Font.BOLD, 20));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(a.getSource()==button_1)
				{
					login.main(null);
					frame.setVisible(false);
				}
			}
		});
		button_1.setBackground(new Color(0, 0, 0, 20));
		button_1.setBounds(740, 41, 166, 48);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Staff");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				stafflogin.main(null);
				frame.setVisible(false);

			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 20));
		button_2.setForeground(Color.LIGHT_GRAY);
		button_2.setBackground(new Color(0, 0, 0, 20));
		button_2.setBounds(971, 41, 166, 48);
		panel_1.add(button_2);
		
		JLabel label_1 = new JLabel("Toll Tax Management System.");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setBounds(71, 338, 811, 110);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Nimbus Mono L", Font.BOLD, 40));
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("TOll Information");
		label_2.setBounds(160, 460, 320, 40);
		label_2.setFont(new Font("Nimbus Mono L", Font.BOLD, 30));
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/pic2.jpeg")).getImage();
		label_3.setIcon(new ImageIcon(img));
		label_3.setBackground(new Color(0, 0, 0, 20));
		label_3.setBounds(793, 517, 1115, 397);
		frame.getContentPane().add(label_3);
		
		JLabel lblTollTaxManagment = new JLabel("Toll Tax Managment System @2020");
		lblTollTaxManagment.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTollTaxManagment.setHorizontalAlignment(SwingConstants.CENTER);
		lblTollTaxManagment.setForeground(Color.DARK_GRAY);
		lblTollTaxManagment.setBounds(757, 945, 485, 40);
		frame.getContentPane().add(lblTollTaxManagment);
		
		JLabel label_4 = new JLabel("");
		Image img11=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		
		 label_5 = new JLabel("clock");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("LM Roman 8", Font.BOLD, 16));
		label_5.setBounds(1585, 12, 335, 36);
		frame.getContentPane().add(label_5);
		label_4.setIcon(new ImageIcon(img11));
		label_4.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(label_4);
		
		
	}
}