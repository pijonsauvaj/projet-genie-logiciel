package domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;

public class ProductTest {
	Category cat;
	Product product1;

	@BeforeEach
	void setUp() {
		cat = new Category("fruit");
		product1 = new Product("tomate", 16, cat);
	}

	@Test
	void shouldCreateProduct() {
		Product product2 = new Product("orange", 16, cat);
		assertNotNull(product2);
		assertEquals("orange", product2.getName());
		assertTrue(product2.getId() > 0);
	}

	@Test
	void shouldChangeName() {
		product1.setName("fraise");
		assertEquals("fraise", product1.getName());
	}

	@Test
	void shouldChangeQuantity() {
		product1.setQuantity(18);
		assertEquals(18, product1.getQuantity());
	}

	@Test
	void shouldAddQuantity() {
		product1.addQuantity(4);
		assertEquals(20, product1.getQuantity());
	}

	@Test
	void shouldNotAllowNegativeQuantity() {
		try {
			product1.setQuantity(0);
		} catch (IllegalArgumentException e) {
			assertEquals("La quantité ne peut pas être négative ou nulle", e.getMessage());
		}
	}

}
