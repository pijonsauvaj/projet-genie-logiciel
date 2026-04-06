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

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", category="
				+ category.getName() + "}";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Le nom ne peut pas être vide");
		}
		this.name = name.toLowerCase().trim();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("La quantité ne peut pas être négative ou nulle");
		}
		this.quantity = quantity;
	}

	public void addQuantity(int q) {
		this.quantity += q;
	}

	public void setId(int i) {
		this.id = i;
	}

}
