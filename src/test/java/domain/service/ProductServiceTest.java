package domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	Product p;
	
	@BeforeEach
    void setUp() {
        p = new Product("Tomate", 10, new Category("Fruit"));
    }

    @Mock
    private ProductRepo repo;

    @InjectMocks
    private ProductService service;

    @Test
    public void shouldIncreaseQuantity() {
    	p.setId(1);
        when(repo.findByName("Tomate")).thenReturn(Optional.of(p));
        when(repo.findById(1)).thenReturn(p);
        service.increaseQuantity("Tomate", 5);
        assertEquals(15, p.getQuantity());
        verify(repo).save(p);
    }
    
    @Test
    public void shouldModifyName() {
        when(repo.findById(1)).thenReturn(p);
        service.modifyNameProduct(1, "Carotte");
        assertEquals("Carotte", p.getName());
        verify(repo).save(p);
    }
    @Test
	public void shouldDelProduct() {
        Product p = new Product("Tomate", 10, new Category("Fruit"));
        p.setId(1);
        when(repo.findByName("Tomate")).thenReturn(Optional.of(p));
        service.delProduct("Tomate");
        verify(repo).delete(1);
	}
    @Test
    public void shouldModifyQuantity() {
        Product p = new Product("Tomate", 10, new Category("Fruit"));
        p.setId(1);
        when(repo.findById(1)).thenReturn(p);
        service.modifyQuantityProduct(1, 20);
        assertEquals(20, p.getQuantity());
        verify(repo).save(p);
    }
    @Test
    public void shouldAddProduct() {
        service.addProduct("Tomate", 10, new Category("Fruit"));
        verify(repo).save(any(Product.class));
    }
    @Test
    public void shouldGetProduct() {
        Product p = new Product("Tomate", 10, new Category("Fruit"));
        when(repo.findByName("Tomate")).thenReturn(Optional.of(p));
        Optional<Product> result = service.getProduct("Tomate");
        assertTrue(result.isPresent());
        assertEquals("Tomate", result.get().getName());
        verify(repo).findByName("Tomate");
    }
    @Test
    public void shouldGetAllProducts() {
        Product p1 = new Product("Tomate", 10, new Category("Fruit"));
        Product p2 = new Product("Pomme", 5, new Category("Fruit"));
        List<Product> list = List.of(p1, p2);
        when(repo.findAll()).thenReturn(list);
        List<Product> result = service.getAllProduct();
        assertEquals(2, result.size());
        assertEquals("Tomate", result.get(0).getName());
        verify(repo).findAll();
    }
}