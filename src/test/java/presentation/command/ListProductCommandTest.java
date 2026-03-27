package presentation.command;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.model.Product;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.presentation.command.ListProductsCommand;

class ListProductsCommandTest {

    @Test
    void shouldListAllProducts() {
        // Arrange
        CategoryService categoryService = mock(CategoryService.class);
        ProductService productService = mock(ProductService.class);
        Scanner Scanner = new Scanner("");
        Product p1 = new Product("Tomate", 10, new Category("Fruit"));
        Product p2 = new Product("Pomme", 5, new Category("Fruit"));
        when(productService.getAllProduct()).thenReturn(List.of(p1, p2));
        ListProductsCommand cmd = new ListProductsCommand(categoryService, productService, Scanner);
        cmd.execute();
        verify(productService).getAllProduct();
    }
}