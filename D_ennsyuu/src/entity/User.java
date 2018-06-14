package entity;

public class User {
	private Integer uid;
	private String name;
	private String email;

	public User() {
	}

	public User(Integer uid,String name, String email) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
