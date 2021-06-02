package reset;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;

public class Reset {

	private JFrame frame;
	private JTextField txtfullname;
	private JTextField txtemailid;
	private JTextField txtaadharno;
	private JTextField txtmobileno;
	private JComboBox chckbxday;
	private JComboBox chckbxmonth;
	private JComboBox chckbxyear;
	private JLabel lblday,lblmonth,lblyear,label,label_1,label_2,label_3,label_4;
	private JTextField txtpassword;
	private JTextField txtrepassword;
	JLabel lblpassword,lblrepassword;
	private JButton btnsubmit,btncancel;
	private JButton btnCancel;
	private JLabel lblheadcontext1;
	JLabel lblusername ;
	private JTextField txtusername;
	private JLabel label_5;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reset window = new Reset();
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
	public Reset() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(540, 350, 830, 603);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblheadcaption = new JLabel("                            Forgot Password");
		lblheadcaption.setBackground(Color.BLACK);
		lblheadcaption.setForeground(Color.BLACK);
		lblheadcaption.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 26));
		lblheadcaption.setBounds(82, 12, 627, 33);
		frame.getContentPane().add(lblheadcaption);
		
		JLabel lblfullname = new JLabel("What is your full name ?");
		lblfullname.setBackground(Color.BLACK);
		lblfullname.setForeground(Color.BLACK);
		lblfullname.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 19));
		lblfullname.setBounds(176, 79, 410, 26);
		frame.getContentPane().add(lblfullname);
		
		txtfullname = new JTextField();
		txtfullname.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtfullname.setBounds(170, 122, 499, 35);
		frame.getContentPane().add(txtfullname);
		txtfullname.setColumns(10);
		
		JLabel lblemailid = new JLabel("What is your email id ?");
		lblemailid.setBackground(Color.BLACK);
		lblemailid.setForeground(Color.BLACK);
		lblemailid.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 19));
		lblemailid.setBounds(176, 181, 410, 26);
		frame.getContentPane().add(lblemailid);
		
		txtemailid = new JTextField();
		txtemailid.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtemailid.setColumns(10);
		txtemailid.setBounds(170, 219, 499, 35);
		frame.getContentPane().add(txtemailid);
		
		JLabel lblaadharno = new JLabel("What is your aadhar no ?");
		lblaadharno.setBackground(Color.BLACK);
		lblaadharno.setForeground(Color.BLACK);
		lblaadharno.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 19));
		lblaadharno.setBounds(176, 280, 410, 26);
		frame.getContentPane().add(lblaadharno);
		
		txtaadharno = new JTextField();
		txtaadharno.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtaadharno.setColumns(10);
		txtaadharno.setBounds(170, 318, 499, 35);
		frame.getContentPane().add(txtaadharno);
		
		
		JLabel lblmobno = new JLabel("What is your mobile no ?");
		lblmobno.setBackground(Color.BLACK);
		lblmobno.setForeground(Color.BLACK);
		lblmobno.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 19));
		lblmobno.setBounds(176, 382, 410, 26);
		frame.getContentPane().add(lblmobno);
		
		txtmobileno = new JTextField();
		txtmobileno.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtmobileno.setColumns(10);
		txtmobileno.setBounds(170, 420, 499, 35);
		frame.getContentPane().add(txtmobileno);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.RED);
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String fullname=txtfullname.getText();
				String emailid=txtemailid.getText();
				String aadharno=txtaadharno.getText();
				
				
				//System.out.println(date);
				String mobno=txtmobileno.getText();
				resetcred reset=new resetcred(fullname,emailid,aadharno,mobno);
				
				loginservice loginservice=new loginservice();
				int x=loginservice.reset(reset);
				
				
				if(x==1)
				{
					JOptionPane.showMessageDialog(null,"Details are correct");
					lblheadcaption.setVisible(false);
					lblfullname.setVisible(false);
					txtfullname.setVisible(false);
					lblaadharno.setVisible(false);
					txtaadharno.setVisible(false);
					lblmobno.setVisible(false);
					txtmobileno.setVisible(false);
					lblemailid.setVisible(false);
					txtemailid.setVisible(false);
				
				
					
					lblpassword.setVisible(true);
					lblrepassword.setVisible(true);
					txtpassword.setVisible(true);
					txtrepassword.setVisible(true);
					btnsubmit.setVisible(true);
					btncancel.setVisible(true);
					btnSubmit.setVisible(false);
					btnCancel.setVisible(false);
					lblheadcontext1.setVisible(true);
					txtusername.setVisible(true);
					lblusername.setVisible(true);
				
					
					
					
					
				}   
				else
					JOptionPane.showMessageDialog(null,"no match found please try agian");
				
				
				
				
			}
		});
		btnSubmit.setBounds(233, 500, 147, 44);
		frame.getContentPane().add(btnSubmit);
		
	    btnCancel = new JButton("Cancel");
	    btnCancel.setFont(new Font("Dialog", Font.BOLD, 20));
	    btnCancel.setBackground(Color.WHITE);
	    btnCancel.setForeground(Color.RED);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				
			}
		});
		btnCancel.setBounds(462, 500, 147, 44);
		frame.getContentPane().add(btnCancel);
	
		
		 lblpassword = new JLabel("Enter your New password  :");
		 lblpassword.setForeground(Color.BLACK);
		lblpassword.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 24));
		lblpassword.setBounds(42, 204, 410, 26);
		frame.getContentPane().add(lblpassword);
		lblpassword.setVisible(false);
		
		txtpassword = new JTextField();
		txtpassword.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpassword.setColumns(10);
		txtpassword.setBounds(420, 204, 319, 35);
		txtpassword.setVisible(false);
		frame.getContentPane().add(txtpassword);
		
	    lblrepassword = new JLabel("Re Enter Your Password    :");
	    lblrepassword.setBackground(Color.BLACK);
	    lblrepassword.setForeground(Color.BLACK);
		lblrepassword.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 24));
		lblrepassword.setBounds(42, 294, 410, 26);
		frame.getContentPane().add(lblrepassword);
		lblrepassword.setVisible(false);
		
		txtrepassword = new JTextField();
		txtrepassword.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtrepassword.setColumns(10);
		txtrepassword.setVisible(false);
		txtrepassword.setBounds(420, 294, 319, 35);
		frame.getContentPane().add(txtrepassword);
		
	    btnsubmit = new JButton("Submit");
	    btnsubmit.setBackground(Color.WHITE);
	    btnsubmit.setForeground(Color.RED);
	    btnsubmit.setFont(new Font("Dialog", Font.BOLD, 20));
	    btnsubmit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		
	    		String password=txtpassword.getText();
	    		String repassword=txtrepassword.getText();
	    		String name=txtfullname.getText();
	    		String username=txtusername.getText();
	    		loginservice ls=new loginservice();
	    		
	    		int x=ls.resetpass(password,repassword,name,username);
	    		
	    		if(x==1)
	    		{
	    			JOptionPane.showMessageDialog(null,"your password has been rested succesfully");
	    		    frame.setVisible(false);
	    		    
	    		}
	    		else
	    			JOptionPane.showMessageDialog(null,"your password is not match in both textfields");
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    	}
	    });
		btnsubmit.setBounds(197, 378, 157, 44);
		btnsubmit.setVisible(false);
		frame.getContentPane().add(btnsubmit);
		
	    btncancel = new JButton("Cancel");
	    btncancel.setBackground(Color.WHITE);
	    btncancel.setFont(new Font("Dialog", Font.BOLD, 20));
	    btncancel.setForeground(Color.RED);
		btncancel.setBounds(423, 378, 147, 44);
		btncancel.setVisible(false);
		frame.getContentPane().add(btncancel);
		
		lblheadcontext1 = new JLabel("                            Forgot Password");
		lblheadcontext1.setBackground(Color.BLACK);
		lblheadcontext1.setForeground(Color.BLACK);
		lblheadcontext1.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 26));
		lblheadcontext1.setBounds(82, 25, 627, 33);
		frame.getContentPane().add(lblheadcontext1);
		
	    lblusername = new JLabel("Enter Your Name Username  :");
	    lblusername.setBackground(Color.BLACK);
	    lblusername.setForeground(Color.BLACK);
		lblusername.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 24));
		lblusername.setBounds(42, 104, 380, 33);
		lblusername.setVisible(false);
		frame.getContentPane().add(lblusername);
		
		txtusername = new JTextField();
		txtusername.setBounds(420, 112, 319, 35);
		txtusername.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JLabel label_6 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/pic.jpg")).getImage();
		label_6.setIcon(new ImageIcon(img));
		label_6.setBounds(0, 0, 830, 605);
		frame.getContentPane().add(label_6);
		
	
		txtusername.setVisible(false);
		lblheadcontext1.setVisible(false);
	}
}