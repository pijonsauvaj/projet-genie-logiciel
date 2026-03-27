package domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        p = new Product("tomate", 20, new Category("Fruit"));
    }

    @Mock
    private ProductRepo repo;

    @InjectMocks
    private ProductService service;

    @Test
    public void shouldIncreaseQuantity() {
    	p.setId(1);
        when(repo.findByName("tomate")).thenReturn(Optional.of(p));
        when(repo.findById(1)).thenReturn(p);
        service.increaseQuantity("tomate", 5);
        assertEquals(25, p.getQuantity());
        verify(repo).save(p);
    }
    
    @Test
    public void shouldModifyName() {
        when(repo.findById(1)).thenReturn(p);
        service.modifyNameProduct(1, "Carotte");
        assertEquals("carotte", p.getName());
        verify(repo).save(p);
    }
    @Test
	public void shouldDelProduct() {
        Product p = new Product("tomate", 10, new Category("Fruit"));
        p.setId(1);
        when(repo.findByName("tomate")).thenReturn(Optional.of(p));
        service.delProduct("tomate");
        verify(repo).delete(1);
	}
    @Test
    public void shouldModifyQuantity() {
        Product p = new Product("tomate", 10, new Category("Fruit"));
        p.setId(1);
        when(repo.findById(1)).thenReturn(p);
        service.modifyQuantityProduct(1, 20);
        assertEquals(20, p.getQuantity());
        verify(repo).save(p);
    }
    @Test
    public void shouldAddProduct() {
        service.addProduct("tomate", 10, new Category("Fruit"));
        verify(repo).save(any(Product.class));
    }
    @Test
    public void shouldGetProduct() {
        Product p = new Product("tomate", 10, new Category("Fruit"));
        when(repo.findByName("tomate")).thenReturn(Optional.of(p));
        Optional<Product> result = service.getProduct("tomate");
        assertTrue(result.isPresent());
        assertEquals("tomate", result.get().getName());
        verify(repo).findByName("tomate");
    }
    @Test
    public void shouldGetAllProducts() {
        Product p1 = new Product("tomate", 10, new Category("Fruit"));
        Product p2 = new Product("pomme", 5, new Category("Fruit"));
        List<Product> list = List.of(p1, p2);
        when(repo.findAll()).thenReturn(list);
        List<Product> result = service.getAllProduct();
        assertEquals(2, result.size());
        assertEquals("tomate", result.get(0).getName());
        verify(repo).findAll();
    }
    
    @Test
    public void shouldVerifyNotNull() {
        try {
            service.verifyNotNull(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Produit introuvable", e.getMessage());
        }
    }
    
    @Test
    public void shoulDelProductNotFound() {
        when(repo.findByName("tomate")).thenReturn(Optional.<Product>empty());
        try {
            service.delProduct("tomate");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Product not found"));
        }
    }
    
    @Test
    public void shouldModifyNameProductNotFound() {
        when(repo.findById(1)).thenReturn(null);
        try {
            service.modifyNameProduct(1, "Carotte");
        } catch (IllegalArgumentException e) {
            assertEquals("Produit introuvable", e.getMessage());
        }
    }
    @Test
    public void shouldModifyNameProductNameNull() {
        when(repo.findById(1)).thenReturn(p);
        try {
            service.modifyNameProduct(1, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Le nom ne peut pas être vide.", e.getMessage());
        }
    }
    @Test
    public void shouldModifyQuantityProducNotFound() {
        when(repo.findById(1)).thenReturn(null);
        try {
            service.modifyQuantityProduct(1, 10);
        } catch (IllegalArgumentException e) {
            assertEquals("Produit introuvable", e.getMessage());
        }
    }
    @Test
    public void shouldModifyQuantityProductQuantityInvalid() {
        when(repo.findById(1)).thenReturn(p);
        try {
            service.modifyQuantityProduct(1, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("La quantité doit être positif.", e.getMessage());
        }
    }
    @Test
    public void shouldGetProductotFound() {
        when(repo.findByName("tomate")).thenReturn(Optional.<Product>empty());

        Optional<Product> result = service.getProduct("tomate");
        assertFalse(result.isPresent());
    }
    @Test
    public void shouldVerifyThresholdBelow() {
        p.setId(1);
        p.setQuantity(5);
        when(repo.findById(1)).thenReturn(p);
        boolean result = service.verifyThreshold(1);
        assertTrue(result);
    }
    @Test
    public void shouldVerifyThresholdAbove() {
        p.setId(1);
        p.setQuantity(20);
        when(repo.findById(1)).thenReturn(p);
        boolean result = service.verifyThreshold(1);
        assertFalse(result);
    }
    
    @Test
    public void shouldIncreaseQuantityProductNotFound() {
        when(repo.findByName("tomate")).thenReturn(Optional.<Product>empty());
        try {
            service.increaseQuantity("tomate", 5);
        } catch (IllegalArgumentException e) {
            assertEquals("Produit introuvable", e.getMessage());
        }
    }
    
    @Test
    public void shouldIncreaseQuantityQuantityInvalid() {
        when(repo.findByName("tomate")).thenReturn(Optional.of(p));
        try {
            service.increaseQuantity("tomate", 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Quantité pas assez grande", e.getMessage());
        }
    }
    
    @Test
    public void shouldIncreaseQuantityThresholdReached() {
        p.setId(1);
        p.setQuantity(10);
        when(repo.findByName("tomate")).thenReturn(Optional.of(p));
        when(repo.findById(1)).thenReturn(p);
        try {
            service.increaseQuantity("tomate", 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Seuil de quantité atteint", e.getMessage());
        }
    }
    @Test
    public void shouldDecreaseQuantityCorrectly() {
        p.setId(1);
        when(repo.findByName("tomate")).thenReturn(Optional.of(p));
        when(repo.findById(1)).thenReturn(p);
        service.decreaseQuantity("tomate", 3);
        assertEquals(17, p.getQuantity());
        verify(repo).save(p);
    }
    @Test
    public void shouldDecreaseQuantityProductNotFound() {
        when(repo.findByName("tomate")).thenReturn(Optional.<Product>empty());
        try {
            service.decreaseQuantity("tomate", 3);
        } catch (IllegalArgumentException e) {
            assertEquals("Produit introuvable", e.getMessage());
        }
    }
    @Test
    public void shouldDecreaseQuantityInvalid() {
        when(repo.findByName("tomate")).thenReturn(Optional.of(p));
        try {
            service.decreaseQuantity("tomate", 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Quantité pas assez grande", e.getMessage());
        }
    }
    @Test
    public void shouldDecreaseQuantityThresholdReached() {
        p.setId(1);
        p.setQuantity(10);
        when(repo.findByName("tomate")).thenReturn(Optional.of(p));
        when(repo.findById(1)).thenReturn(p);
        try {
            service.decreaseQuantity("tomate", 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Seuil de quantité atteint", e.getMessage());
        }
    }
}