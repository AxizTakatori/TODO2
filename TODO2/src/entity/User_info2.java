package entity;

public class User_info2 {



	private Integer user_id;
	private String user_name;
	private String telephone;
	private String password;

	public User_info2() {
	}

	public User_info2(Integer user_id,String user_name,String telephone ,String password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.telephone = telephone;
		this.password = password;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}








}