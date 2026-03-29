package presentation.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.presentation.command.AddProductCommand;

public class AddProductCommandTest {
	@Test
	void testExecuteAddsProductCorrectly() {
	    CategoryService categoryService = mock(CategoryService.class);
	    ProductService productService = mock(ProductService.class);
	    String Input = "Banane\n12\nFruits\n";
	    Scanner Scanner = new Scanner(Input);

	    AddProductCommand cmd = new AddProductCommand(categoryService, productService, Scanner);
	    cmd.execute();
	    verify(productService).addProduct("Banane", 12, "Fruits");
	}
}
