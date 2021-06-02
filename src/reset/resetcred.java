package reset;

public class resetcred {
	
public String fullname,emailid,aadharno,mobno;
	
	public String getFullName() {
		return fullname;
	}

	public void setFullName(String fullname) {
		this.fullname =fullname;
	}

	public String getEmailId() {
		return emailid;
	}
	
		public void setEmailId(String emailid) {
		this.emailid = emailid;
	}
		
		public String getAadharNo() {
			return aadharno;
		}

		public void setAadharNo(String aadharno) {
			this.aadharno = aadharno;
		}

		/*public String getBdate() {
			return bdate;
		}
		
		public void setBdate(String date) {
			this.bdate = date;
		}
*/
		public String getMobno() {
			return mobno;
		}
		
		public void setMobno(String mobno) {
			this.mobno = mobno;
		}
	
		public resetcred(String fullname,String emailid,String aadharno,String mobno)
		{
			this.fullname=fullname;
			this.emailid=emailid;
			this.aadharno=aadharno;
			//this.bdate=date;
			this.mobno=mobno;
		}
}