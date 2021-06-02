package reset;

import java.sql.*;
import toll.*;


import javax.swing.JOptionPane;

import java.io.*;
//import Designs.*;
//import Cred.*;

public class loginservice {
	 
	private int flag=0;
	private int flag1=0;
	private int loginflag=0;
	private int flagreset=0;
	
	//private int x=registration.formno;
	private String a[];
	private String dbusername,dbpassword;
	private String search[],search1[],akash="xyz";
	
		public int demo(logincred l)
	{
		String user=l.user;
		String pwd=l.pwd;
		try
		{
			Connection con= null;
			con =connection.getDBconnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from login1");
			while(rs.next())
			{
				 dbusername=rs.getString("username");
				 dbpassword=rs.getString("password");
			if(user.equals(dbusername)&& pwd.equals(dbpassword))
			{
				flag=1;
				break;
			}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(flag==1)
				return 1;
			else
				return 0;
		
		}
		
	
	

public int reset(resetcred r1)
{

	try
	 {
		Connection con= null;
		con =connection.getDBconnection();
		Statement stmt = con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from login1");
			while(rs.next())	
			{	
				String name=rs.getString("fullname");
				String emailid=rs.getString("emailid");
				String aadharno=rs.getString("aadharno");
				//String date=""+(rs.getDate("bdate"));
				String mobno=rs.getString("mobno");
				
				//System.out.println(""+name+""+emailid+""+aadharno+""+mobno+""+date1);
				//System.out.println(""+r1.fullname+""+r1.emailid+""+r1.aadharno+""+r1.mobno+""+r1.bdate);
				
				if((r1.fullname.equals(name))&&(r1.emailid.equals(emailid))&&(r1.aadharno.equals(aadharno))&&(r1.mobno.equals(mobno)))
				{
					
					loginflag=1;
				//	System.out.println(loginflag);
					break;
				}
				
			}
			
			
		stmt.close();
		con.close();
	 }
	catch(Exception ke)
	{
		ke.printStackTrace();
	}
	
	//System.out.println(loginflag);
	
	if(loginflag==1)
		return 1;
	else
		return 0;
	
	
	
}

public int resetpass(String password,String repassword,String name,String username)
{

	try
	 {
		Connection con= null;
		con =connection.getDBconnection();
		Statement stmt = con.createStatement();
			
		if(password.equals(repassword))
		{
			int result = stmt.executeUpdate("update login1 set password ='"+password+"',username='"+username+"' where fullname='"+name+"' ");
			if(result==1)
					flagreset=1;
		}
		else
		{
			    flagreset=0;
		}
			
			
		stmt.close();
		con.close();
	 }
	catch(Exception ke)
	{
		ke.printStackTrace();
	}
	if(flagreset==1)
		return 1;
	else
		return 0;
}
}
