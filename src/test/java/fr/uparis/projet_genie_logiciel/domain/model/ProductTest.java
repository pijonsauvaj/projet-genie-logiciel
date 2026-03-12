package fr.uparis.projet_genie_logiciel.domain.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

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

}
