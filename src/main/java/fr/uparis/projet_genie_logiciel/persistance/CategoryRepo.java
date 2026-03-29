package fr.uparis.projet_genie_logiciel.persistance;

import java.util.*;
import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;

public class CategoryRepo {

    private Map<Integer, Category> categories = new HashMap<>();

    public void save(Category category) {
        categories.put(category.getId(), category);
    }

    public Category findById(int id) {
        return categories.get(id);
    }
    
    public Optional<Category> findByName(String name) {
        return  categories.values().stream()
        	    .filter(product -> product.getName().equalsIgnoreCase(name)).findFirst();
    }

    public List<Category> findAll() {
        return categories.values().stream().toList();
    }
    
    public void delete(int id) {
        categories.remove(id);
    }
}