package fr.uparis.projet_genie_logiciel.persistance;

import java.util.*;
import fr.uparis.projet_genie_logiciel.domain.model.Product;

public class ProductRepo {

    private Map<Integer, Product> products = new HashMap<>();

    public void save(Product product) {
        products.put(product.getId(), product);
    }

    public Product findById(int id) {
        return products.get(id);
    }
    public Optional<Product> findByName(String name) {
        return  products.values().stream()
        	    .filter(product -> product.getName().equalsIgnoreCase(name))
        	    .findFirst();
    }

    public List<Product> findAll() {
        return products.values().stream().toList();
    }

    public void delete(int id) {
        products.remove(id);
    }
}