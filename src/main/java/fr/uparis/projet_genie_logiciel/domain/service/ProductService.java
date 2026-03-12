package fr.uparis.projet_genie_logiciel.domain.service;

import java.util.List;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;

public class ProductService {
	
	private final ProductRepo repo;

	public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

	
	public void delProduct(int id) {
		repo.delete(id);
	}
	public void addProduct(String name, int quantity, Category category) {
	    Product p = new Product(name, quantity, category);
	    repo.save(p);
	}
	public void modifyNameProduct(int id, String name) {
	    Product product = repo.findById(id);
	    if (product != null) {
	        product.setName(name);
	        repo.save(product);
	    }
	}
	public void modifyQuantityProduct(int id, int quantity) {
	    Product product = repo.findById(id);
	    if (product != null) {
	        product.setQuantity(quantity);
	        repo.save(product);
	    }
	}
	

	public List<Product> listAllProduct(){
		return repo.findAll();
	}
	//réfléchir la logique
	public void listProductByCategory(){}
	
	
	public boolean verifyThreshold(int id) {
        Product p = repo.findById(id);
        int threshold = 10;
        if(p.getQuantity()<threshold){
        	return true;
        }
        return false;
    }
	
	
	public void decreaseQuantity(int id, int q) {
	    Product product = repo.findById(id);
	    if (product == null) {
	        throw new IllegalArgumentException("Produit introuvable");
	    }

	    product.setQuantity(product.getQuantity() - q); 
	    repo.save(product);
	}
	
	
	public void increaseQuantity(int id, int q) {
	    Product product = repo.findById(id);
	    if (product == null) {
	        throw new IllegalArgumentException("Produit introuvable");
	    }

	    product.setQuantity(product.getQuantity() + q); 
	    repo.save(product);
	}

}
