package fr.uparis.projet_genie_logiciel.domain.service;

import java.util.List;
import java.util.Optional;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import static fr.uparis.projet_genie_logiciel.util.StringUtils.lowerCase;

public class CategoryService {
	private final CategoryRepo repo;

	public CategoryService(CategoryRepo repo) {
		this.repo = repo;
	}

	public void delCategory(int id) {
		repo.delete(id);
	}

	public boolean addCategory(String name) {
		Optional<Category> existing = repo.findByName(lowerCase(name));
		if (existing.isPresent()) {
			Category cat = existing.get();
			repo.save(cat);
			return false;
		}
		Category cat = new Category(lowerCase(name));
		repo.save(cat);
		return true;
	}

	public void modifyNameCategory(int id, String name) {
		Category cat = repo.findById(id);
		if (cat != null) {
			cat.setName(lowerCase(name));
			repo.save(cat);
		}
	}

	public List<Category> listAllCategory() {
		return repo.findAll();
	}

}
