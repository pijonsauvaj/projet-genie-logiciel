

import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;
import fr.uparis.projet_genie_logiciel.presentation.CLI;
import fr.uparis.projet_genie_logiciel.presentation.command.AddProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ExitCommand;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AppTest {

    @Test
    void appInitializationTest() {
        assertDoesNotThrow(() -> {
            Scanner scanner = new Scanner(System.in);
            ProductRepo repo = new ProductRepo();
            ProductService service = new ProductService(repo);
            CategoryRepo categoryRepo = new CategoryRepo();
            CategoryService categoryService = new CategoryService(categoryRepo);

            CLI cli = new CLI();
            cli.register(new AddProductCommand(categoryService, service, scanner));
            cli.register(new ExitCommand());

            // Run CLI in a separate thread or mock input to avoid blocking
            Thread cliThread = new Thread(cli::run);
            cliThread.start();
            cliThread.interrupt(); // Immediately stop to avoid blocking
        });
    }
}