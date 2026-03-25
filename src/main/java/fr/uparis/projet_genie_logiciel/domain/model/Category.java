package fr.uparis.projet_genie_logiciel.domain.model;

public class Category {
	private int id;
	private String name;
	private static int counter = 1;

	
	public Category(String name ) {
		this.id = counter++;
		setName(name);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Le nom ne peut pas être vide");
		}
		this.name = name;
	}
}
