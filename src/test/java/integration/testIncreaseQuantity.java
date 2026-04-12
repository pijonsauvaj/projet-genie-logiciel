package integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.model.Product;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;

public class testIncreaseQuantity {
	@Test
	void testIncreaseQuantity() {
	    CategoryRepo categoryRepo = new CategoryRepo();
	    ProductRepo productRepo = new ProductRepo();

	    CategoryService categoryService = new CategoryService(categoryRepo);
	    ProductService productService = new ProductService(productRepo, categoryService);

	    categoryService.addCategory("Fruits");
	    productService.addProduct("Banane", 5, "Fruits");

	    // Augmentation qui dépasse le seuil (5 + 20 = 25)
	    productService.increaseQuantity("Banane", 20);

	    Optional<Product> opt = productRepo.findByName("Banane");
	    assertTrue(opt.isPresent());
	    assertEquals(25, opt.get().getQuantity());
	}


}
