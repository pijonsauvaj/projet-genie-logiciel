package integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;

public class testDeleteProduct {
	@Test
	void testDeleteProduct() {
	    CategoryRepo categoryRepo = new CategoryRepo();
	    ProductRepo productRepo = new ProductRepo();

	    CategoryService categoryService = new CategoryService(categoryRepo);
	    ProductService productService = new ProductService(productRepo, categoryService);

	    categoryService.addCategory("Fruits");
	    productService.addProduct("Banane", 10, "Fruits");

	    assertTrue(productRepo.findByName("Banane").isPresent());

	    productService.delProduct("Banane");

	    assertTrue(productRepo.findByName("Banane").isEmpty());
	}
}
