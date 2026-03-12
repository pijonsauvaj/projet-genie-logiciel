package fr.uparis.projet_genie_logiciel.domain.model;

public class Category {
	private int id=0;
	private String name;
	
	public Category(String n) {
		this.id ++;
		this.name = n;
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
}
