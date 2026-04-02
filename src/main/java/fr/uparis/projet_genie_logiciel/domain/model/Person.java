package fr.uparis.projet_genie_logiciel.domain.model;

public class Person {
	protected int id;
	protected String name;

	public Person(int i, String n) {
		this.id = i;
		this.name = n;
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

}
