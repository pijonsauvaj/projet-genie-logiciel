package presentation.command;

import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.presentation.command.DeleteProductCommand;

class DeleteProductCommandTest {

    @Test
    void shouldDeleteProductByName() {
        CategoryService categoryService = mock(CategoryService.class);
        ProductService productService = mock(ProductService.class);
        String input = "Banane\n";
        Scanner scanner = new Scanner(input);
        DeleteProductCommand cmd = new DeleteProductCommand(categoryService, productService, scanner);
        cmd.execute();
        verify(productService).delProduct("Banane");
        verifyNoMoreInteractions(productService, categoryService);
    }
}