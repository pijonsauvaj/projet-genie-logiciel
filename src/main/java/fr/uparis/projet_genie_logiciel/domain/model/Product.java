package fr.uparis.projet_genie_logiciel.domain.model;

public class Product {
	private int id;
	private String name;
	private String reference;
	private int quantity;
	private Category category;
	
	
	public Product(int i, String n, String r, int q, Category c) {
		this.id = i;
		this.name = n;
		this.reference = r;
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
	public String getRef() {
		return reference;
	}
	public void setRef(String r) {
		reference = r;
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
