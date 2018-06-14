package entity;

public class Product {

	private String p_id;
	private String category;
	private String name;
	private Integer price;
	private Integer num;
	private Integer del;

	public Product() {

	}

	public Product(String p_id, String category, String name, Integer price, Integer num, Integer del) {
		this.p_id = p_id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.num = num;
		this.del = del;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}
}