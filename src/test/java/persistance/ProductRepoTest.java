package persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;

class ProductRepoTest {

	private ProductRepo repo;
	private Product p;

	@BeforeEach
	public void setUp() {
		repo = new ProductRepo();
		p = new Product("tomate", 10, new Category("fruit"));
		p.setId(1);
	}

	@Test
	public void shouldSaveProduct() {
		repo.save(p);
		Product result = repo.findById(1);
		assertNotNull(result);
		assertEquals("tomate", result.getName());
	}

	@Test
	public void shouldFindById() {
		repo.save(p);
		Product result = repo.findById(1);
		assertEquals("tomate", result.getName());
	}

	@Test
	public void shouldFindByIdNotFound() {
		Product result = repo.findById(999);
		assertNull(result);
	}

	@Test
	public void shouldFindByName() {
		repo.save(p);
		Optional<Product> result = repo.findByName("tomate");
		assertTrue(result.isPresent());
		assertEquals("tomate", result.get().getName());
	}

	@Test
	public void shouldFindByNameIgnoreCase() {
		repo.save(p);
		Optional<Product> result = repo.findByName("tomate");
		assertTrue(result.isPresent());
		assertEquals("tomate", result.get().getName());
	}

	@Test
	public void findByName_shouldReturnEmpty_whenNotFound() {
		Optional<Product> result = repo.findByName("Inconnu");
		assertFalse(result.isPresent());
	}

	@Test
	public void shouldFindAllProducts() {
		Product p2 = new Product("Pomme", 5, new Category("fruit"));
		p2.setId(2);
		repo.save(p);
		repo.save(p2);
		List<Product> list = repo.findAll();
		assertEquals(2, list.size());
	}

	@Test
	public void shouldFindAllNoProducts() {
		List<Product> list = repo.findAll();
		assertTrue(list.isEmpty());
	}

	@Test
	public void shouldDeleteProduct() {
		repo.save(p);
		repo.delete(1);
		assertNull(repo.findById(1));
	}

	@Test
	public void shouldDeleteIdNotFound() {
		repo.save(p);
		repo.delete(999);
		assertNotNull(repo.findById(1));
	}
}