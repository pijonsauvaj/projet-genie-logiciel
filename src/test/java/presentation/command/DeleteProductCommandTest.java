package presentation.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

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
		String Input = "Banane\n";
		Scanner Scanner = new Scanner(Input);
		DeleteProductCommand cmd = new DeleteProductCommand(categoryService, productService, Scanner);
		cmd.execute();
		verify(productService).delProduct("Banane");
		verifyNoMoreInteractions(productService, categoryService);
	}
}