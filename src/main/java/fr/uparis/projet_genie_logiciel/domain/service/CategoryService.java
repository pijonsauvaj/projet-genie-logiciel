package fr.uparis.projet_genie_logiciel.domain.service;

import java.util.List;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;
import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;

public class CategoryService {
	private final CategoryRepo repo;

	public CategoryService(CategoryRepo repo) {
        this.repo = repo;
    }
	
	public void delCategory(int id) {
		repo.delete(id);
	}
	public void addCategory(String name) {
		Category cat = new Category(name);
		repo.save(cat);
	}
	public void modifyNameCategory(int id, String name) {
		Category cat = repo.findById(id);
		if(cat != null) {
			cat.setName(name);
			repo.save(cat);
		}
	}
	
	public List<Category> listAllCategory(){
		return repo.findAll();
	}
	
	
	
	
	
}
