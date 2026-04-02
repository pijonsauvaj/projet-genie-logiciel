package presentation.command;
import static org.mockito.Mockito.*;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.presentation.command.DecreaseProductCommand;

class DecreaseProductCommandTest {
    @Test
    void shouldDecreaseProductQuantity() {
        ProductService productService = mock(ProductService.class);
        String input = "Orange\n3\n";
        Scanner scanner = new Scanner(input);
        DecreaseProductCommand cmd = new DecreaseProductCommand(productService, scanner);
        cmd.execute();
        verify(productService).decreaseQuantity("Orange", 3);
        verifyNoMoreInteractions(productService);
    }
}