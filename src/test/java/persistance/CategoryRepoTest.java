package persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;

class CategoryRepoTest {

	private CategoryRepo repo;
	private Category cat;

	@BeforeEach
	public void setUp() {
		repo = new CategoryRepo();
		cat = new Category("fruit");
		cat.setId(1);
	}

	@Test
	public void shouldSaveCategory() {
		repo.save(cat);
		Category result = repo.findById(1);
		assertNotNull(result);
		assertEquals("fruit", result.getName());
	}

	@Test
	public void shouldFindById() {
		repo.save(cat);
		Category result = repo.findById(1);
		assertEquals("fruit", result.getName());
	}

	@Test
	public void shouldFindByIdNotFound() {
		Category result = repo.findById(999);
		assertNull(result);
	}

	@Test
	public void shouldFindAllCategories() {
		Category cat2 = new Category("Légume");
		cat2.setId(2);
		repo.save(cat);
		repo.save(cat2);
		List<Category> list = repo.findAll();
		assertEquals(2, list.size());
		assertEquals("fruit", list.get(0).getName());
	}

	@Test
	public void shouldFindAllNoCategories() {
		List<Category> list = repo.findAll();
		assertTrue(list.isEmpty());
	}

	@Test
	public void shouldDeleteCategory() {
		repo.save(cat);
		repo.delete(1);
		assertNull(repo.findById(1));
	}

	@Test
	public void shouldDeleteIdNotFound() {
		repo.save(cat);
		repo.delete(999);
		assertNotNull(repo.findById(1));
	}
}