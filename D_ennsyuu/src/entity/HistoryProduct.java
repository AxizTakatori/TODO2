package entity;

public class HistoryProduct {
	private String p_id;
	private String p_category;
	private String p_name;
	private Integer p_price;
	private Integer p_num;
	private Integer p_del;
	private Integer h_buy_no;
	private String h_p_id;
	private Integer h_num;
	private Integer h_subtotal;

	public HistoryProduct() {

	}
	public HistoryProduct(String p_name,Integer p_price, Integer h_num, Integer h_subtotal) {
		this.p_name=p_name;
		this.p_price=p_price;
		this.h_num=h_num;
		this.h_subtotal=h_subtotal;
	}
	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Integer getP_price() {
		return p_price;
	}

	public void setP_price(Integer p_price) {
		this.p_price = p_price;
	}

	public Integer getP_num() {
		return p_num;
	}

	public void setP_num(Integer p_num) {
		this.p_num = p_num;
	}

	public Integer getP_del() {
		return p_del;
	}

	public void setP_del(Integer p_del) {
		this.p_del = p_del;
	}

	public Integer getH_buy_no() {
		return h_buy_no;
	}

	public void setH_buy_no(Integer h_buy_no) {
		this.h_buy_no = h_buy_no;
	}

	public String getH_p_id() {
		return h_p_id;
	}

	public void setH_p_id(String h_p_id) {
		this.h_p_id = h_p_id;
	}

	public Integer getH_num() {
		return h_num;
	}

	public void setH_num(Integer h_num) {
		this.h_num = h_num;
	}

	public Integer getH_subtotal() {
		return h_subtotal;
	}

	public void setH_subtotal(Integer h_subtotal) {
		this.h_subtotal = h_subtotal;
	}

}
