package cn.edu.ccnu.imd.study.demo.vo;

public class OrderVo {
	
	private float total;
	private int numbers;
	private float price;
	private short state;
	private String name;
	private int id;
	private String userid;
	
	public void setTotal(float total) {
		this.total = total;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public short getState() {
		return state;
	}
	public void setState(short state) {
		this.state = state;
	}
	public float getTotal() {
		return total;
	}
	public int getNumbers() {
		return numbers;
	}
	public float getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
 
	
	
}
