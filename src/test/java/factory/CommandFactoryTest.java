package factory;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.factory.CommandFactory;
import fr.uparis.projet_genie_logiciel.presentation.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CommandFactoryTest {

    private CommandFactory factory;

    @BeforeEach
    void setUp() {
        CategoryService categoryService = mock(CategoryService.class);
        ProductService productService = mock(ProductService.class);
        Scanner scanner = new Scanner(System.in);

        factory = new CommandFactory(categoryService, productService, scanner);
    }

    @Test
    void testAddCommandCreation() {
        Command cmd = factory.add();
        assertNotNull(cmd);
        assertTrue(cmd instanceof AddProductCommand);
    }

    @Test
    void testListProductsCommandCreation() {
        Command cmd = factory.listProducts();
        assertNotNull(cmd);
        assertTrue(cmd instanceof ListProductsCommand);
    }

    @Test
    void testDeleteCommandCreation() {
        Command cmd = factory.delete();
        assertNotNull(cmd);
        assertTrue(cmd instanceof DeleteProductCommand);
    }

    @Test
    void testIncreaseCommandCreation() {
        Command cmd = factory.increase();
        assertNotNull(cmd);
        assertTrue(cmd instanceof IncreaseProductCommand);
    }

    @Test
    void testDecreaseCommandCreation() {
        Command cmd = factory.decrease();
        assertNotNull(cmd);
        assertTrue(cmd instanceof DecreaseProductCommand);
    }

    @Test
    void testListCategoriesCommandCreation() {
        Command cmd = factory.listCategories();
        assertNotNull(cmd);
        assertTrue(cmd instanceof ListCategoriesCommand);
    }

    @Test
    void testExitCommandCreation() {
        Command cmd = factory.exit();
        assertNotNull(cmd);
        assertTrue(cmd instanceof ExitCommand);
    }
}
