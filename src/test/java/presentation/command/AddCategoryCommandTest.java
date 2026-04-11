package presentation.command;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.presentation.command.AddCategoryCommand;

public class AddCategoryCommandTest {
    @Test
    void testExecuteAddsCategoryCorrectly() {
        CategoryService categoryService = mock(CategoryService.class);
        String input = "Légume\n";
        Scanner scanner = new Scanner(input);
        AddCategoryCommand cmd = new AddCategoryCommand(categoryService, scanner);
        cmd.execute();
        verify(categoryService).addCategory("Légume");
    }
}
