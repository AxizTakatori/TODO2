package entity;

public class History {

	private String u_id;
	private  Integer total;
	private  Integer tax;


	public History() {

	}

	public History(String id,int total,int tax) {
		this.u_id=id;
		this.total=total;
		this.tax=tax;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTax() {
		return tax;
	}

	public void setTax(Integer tax) {
		this.tax = tax;
	}





}
