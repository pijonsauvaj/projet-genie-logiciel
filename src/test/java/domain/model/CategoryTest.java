package domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.model.Category;

public class CategoryTest {
	Category cat;

	@BeforeEach
	void setUp() {
		cat = new Category("Legume");
	}

	@Test
	void shouldCreateProduct() {
		Category category = new Category("Fruit");
		assertNotNull(category);
		assertEquals("Fruit", category.getName());
		assertTrue(category.getId() > 0);
	}

	@Test
	void shouldChangeName() {
		cat.setName("Viande");
		assertEquals("Viande", cat.getName());
	}

	@Test
	void shouldNotAllowEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> {
			cat.setName("");
		});
	}
}
