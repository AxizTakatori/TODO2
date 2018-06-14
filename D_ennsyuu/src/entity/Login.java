package entity;

public class Login {
	private String email;
	private String pass;
	private String uid;

	public Login() {
	}

	public Login(String email,String pass,String uid) {
		super();
		this.email =email;
		this.pass=pass;
		this.uid=uid;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
}
