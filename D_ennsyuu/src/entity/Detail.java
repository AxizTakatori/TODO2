package entity;

public class Detail {

	private String p_id;
	private Integer num;
	private Integer subtotal;

	public Detail() {

	}

	public Detail(String p_id,Integer num,Integer subtotal) {
		this.p_id=p_id;
		this.num=num;
		this.subtotal=subtotal;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

}
