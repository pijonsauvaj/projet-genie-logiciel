package domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

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

    @Mock
    private ProductRepo repo;

    @InjectMocks
    private ProductService service;

    @Test
    void shouldIncreaseQuantity() {
        Product p = new Product("Tomate", 10, new Category("Fruit"));
        when(repo.findByName("Tomate")).thenReturn(Optional.of(p));

        service.increaseQuantity("Tomate", 5);

        assertEquals(15, p.getQuantity());
        verify(repo).save(p);
    }
}