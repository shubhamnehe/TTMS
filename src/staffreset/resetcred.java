package staffreset;

public class resetcred {
	
public String staffid,sname,email,mobileno;
public String getStaffid() {
	return staffid;
}

public void setStaffid(String staffid) {
	this.staffid = staffid;
}
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname =sname;
	}

	public String getEmailId() {
		return email;
	}
	
		public void setEmailId(String email) {
		this.email = email;
	}
		
		

		/*public String getBdate() {
			return bdate;
		}
		
		public void setBdate(String date) {
			this.bdate = date;
		}
*/
		public String getMobno() {
			return mobileno;
		}
		
		public void setMobno(String mobno) {
			this.mobileno = mobno;
		}
	
		public resetcred(String staffid,String sname,String email,String mobno)
		{
			this.staffid=staffid;
			this.sname=sname;
			this.email=email;
			
			//this.bdate=date;
			this.mobileno=mobno;
		}
}