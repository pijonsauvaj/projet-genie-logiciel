package fr.uparis.projet_genie_logiciel.persistance;

import java.util.*;
import fr.uparis.projet_genie_logiciel.domain.model.Category;

public class CategoryRepo {

    private Map<Integer, Category> categories = new HashMap<>();

    public void save(Category category) {
        categories.put(category.getId(), category);
    }

    public Category findById(int id) {
        return categories.get(id);
    }

    public List<Category> findAll() {
        return new ArrayList<>(categories.values());
    }

    public void delete(int id) {
        categories.remove(id);
    }
}