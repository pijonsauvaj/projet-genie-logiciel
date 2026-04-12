package integration;
import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

class ProductIntegrationTest {
	@Test
	void testAddProductAndRetrieveIt() {
	    CategoryRepo categoryRepo = new CategoryRepo();
	    ProductRepo productRepo = new ProductRepo();

	    CategoryService categoryService = new CategoryService(categoryRepo);
	    ProductService productService = new ProductService(productRepo, categoryService);

	    boolean catAdded = categoryService.addCategory("Fruits");
	    assertTrue(catAdded);

	    Optional<Category> cat = categoryRepo.findByName("Fruits");
	    assertTrue(cat.isPresent());

	    boolean prodAdded = productService.addProduct("Banane", 10, "Fruits");
	    assertTrue(prodAdded);

	    Optional<Product> prod = productRepo.findByName("Banane");
	    assertTrue(prod.isPresent());
	    Product p = prod.get();

	    assertEquals("banane", p.getName());
	    assertEquals(10, p.getQuantity());

	    Optional<Category> createdCat = categoryRepo.findByName("fruits");
	    assertTrue(createdCat.isPresent());

	    assertEquals(createdCat.get().getName(), p.toString().contains("fruits") ? "fruits" : null);
	}

}


