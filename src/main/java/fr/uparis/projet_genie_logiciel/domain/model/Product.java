package fr.uparis.projet_genie_logiciel.domain.model;

public class Product {
	static private int id=0;
	private String name;
	private int quantity;
	private Category category;
	
	
	public Product(String n, int q, Category c) {
		this.id++;
		this.name = n;
		this.quantity = q;
		this.category = c;
	}
	
	
	
	public void IncreaseQuantity(int q) {
		quantity+=q;
	}
	public void DecreaseQuantity(int q) {
		quantity-=q;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int q) {
		quantity = q;
	}
	/*public Category getCategory() {
		return category;
	}
	public void setCategory(CAtegory c) {
		category = c;
	}*/
	
}
