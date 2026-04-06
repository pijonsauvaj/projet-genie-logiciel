package fr.uparis.projet_genie_logiciel.domain.service;

import java.util.List;
import java.util.Optional;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;

public class ProductService {

	private final ProductRepo repo;
	private final CategoryService categoryService;

	public ProductService(ProductRepo repo, CategoryService categoryService) {
		this.repo = repo;
		this.categoryService = categoryService;
	}

	public void verifyNotNull(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("Product not found");
		}
	}

	public void delProduct(String name) {
		Optional<Product> opt = repo.findByName(lowerCase(name));
		if (opt.isEmpty()) {
			throw new IllegalArgumentException("Product not found: " + name);
		}
		Product p = opt.get();
		repo.delete(p.getId());
	}

	public void addProduct(String name, int quantity, String categoryName) {
		Category cat = categoryService.addCategory(categoryName);
		Optional<Product> existing = repo.findByName(lowerCase(name));
		if (existing.isPresent()) {
			Product p = existing.get();
			p.addQuantity(quantity);
			repo.save(p);
			System.out.println("Existing product: " + name + ". Increased quantity of this product.");
			return;
		}
		Product p = new Product(lowerCase(name), quantity, cat);
		repo.save(p);
	}

	public void modifyNameProduct(int id, String name) {
		Product product = repo.findById(id);
		verifyNotNull(product);
		if (name != null) {
			product.setName(lowerCase(name));
			repo.save(product);
		} else {
			throw new IllegalArgumentException("name can't be empty.");
		}
	}

	public void modifyQuantityProduct(int id, int quantity) {
		Product product = repo.findById(id);
		verifyNotNull(product);
		if (quantity > 0) {
			product.setQuantity(quantity);
			repo.save(product);
		} else {
			throw new IllegalArgumentException("quantity must be positif.");
		}
	}

	public Optional<Product> getProduct(String name) {
		return repo.findByName(lowerCase(name));
	}

	public List<Product> getAllProduct() {
		return repo.findAll();
	}

	// réfléchir la logique
	public void listProductByCategory() {
	}

	public boolean verifyThreshold(int id) {
		Product p = repo.findById(id);
		verifyNotNull(p);
		int threshold = 10;
		if (p.getQuantity() <= threshold) {
			return true;
		}
		return false;
	}

	public void increaseQuantity(String name, int q) {
		Optional<Product> opt = repo.findByName(lowerCase(name));
		if (opt.isEmpty()) {
			throw new IllegalArgumentException("Product not found");
		}
		Product product = opt.get();
		if (q <= 0) {
			throw new IllegalArgumentException("Quantity must be superior");
		} else {
			product.addQuantity(q);
			repo.save(product);
		}
		if (verifyThreshold(product.getId()) == true) {
			throw new IllegalArgumentException("threshold reach");
		}
	}

	public void decreaseQuantity(String name, int q) {
		Optional<Product> opt = repo.findByName(lowerCase(name));
		if (opt.isEmpty()) {
			throw new IllegalArgumentException("Product not found");
		}
		Product product = opt.get();
		if (q <= 0) {
			throw new IllegalArgumentException("Quantity must be superior");
		} else {
			product.addQuantity(-q);
			repo.save(product);
		}
		if (verifyThreshold(product.getId()) == true) {
			throw new IllegalArgumentException("Threshold reach");
		}
	}

	private String lowerCase(String name) {
		return name.toLowerCase().trim();
	}

}
