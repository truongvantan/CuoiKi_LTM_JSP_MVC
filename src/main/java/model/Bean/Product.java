package model.Bean;

public class Product {
	private int id;
	private String name;
	private String image;
	private double price;
	private String title;
	private String describtion;
	private int mid;
	
	public Product() {
		
	}
	public Product(int id, String name, String image, double price, String title, String describtion, int mid) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.title = title;
		this.describtion = describtion;
		this.mid = mid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribtion() {
		return describtion;
	}
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", title=" + title
				+ ", describtion=" + describtion + ", mid=" + mid + "]";
	}

	
	
	
}
