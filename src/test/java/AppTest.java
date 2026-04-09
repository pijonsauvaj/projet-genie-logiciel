import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;
import fr.uparis.projet_genie_logiciel.presentation.CLI;
import fr.uparis.projet_genie_logiciel.presentation.command.AddProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ExitCommand;

public class AppTest {
    @Test
    void appInitializationTest() {
        assertDoesNotThrow(() -> {
            CategoryRepo categoryRepo = new CategoryRepo();
            CategoryService categoryService = new CategoryService(categoryRepo);
            ProductRepo repo = new ProductRepo();
            ProductService service = new ProductService(repo, categoryService);
            CLI cli = new CLI();
            cli.register(new AddProductCommand(categoryService, service, null));
            cli.register(new ExitCommand());
        });
    }
}
