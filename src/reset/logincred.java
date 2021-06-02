package reset;

public class logincred {
	
	public String user,pwd;
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public logincred(String user,String pwd)
	{
		this.user=user;
		this.pwd=pwd;
	}
		
	}
