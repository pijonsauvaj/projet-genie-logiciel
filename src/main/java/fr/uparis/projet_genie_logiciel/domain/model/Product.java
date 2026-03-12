package fr.uparis.projet_genie_logiciel.domain.model;

public class Product {
	private int id;
	private String name;
	private int quantity;
	private Category category;
	private static int counter = 1;

	
	public Product(String name, int quantity, Category c) {
		this.id = counter++;
		setName(name);
		setQuantity(quantity);
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
	public String getName() {
		return name;
	}
	public void setName(String n) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Le nom ne peut pas être vide");
		}
		name = n;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int q) {
		if(quantity <= 0) {
			throw new IllegalArgumentException("La quantité ne peut pas être négative");
		}
		quantity = q;
	}
	
}
