package domain.model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.*;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;

public class ProductTest {
	Category cat;
	Product product1;
    @BeforeEach
    void setUp() {
        cat = new Category("Fruit");
        product1 = new Product("Tomate", 16, cat);
    }
    
    @Test
    void shouldCreateProduct() {
    	Product product2 = new Product("Orange", 16, cat);
    	assertNotNull(product2);
        assertEquals("Orange", product2.getName());
        assertTrue(product2.getId() > 0);
    }

    @Test
    void shouldChangeName() {
        product1.setName("Fraise");
        assertEquals("Fraise", product1.getName());
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
        }
        catch (IllegalArgumentException e) {
            assertEquals("La quantité ne peut pas être négative ou nulle", e.getMessage());
        }
    }
    
}
