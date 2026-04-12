package presentation.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.presentation.command.ListCategoriesCommand;

public class ListCategoriesCommandTest {
    @Test
    void shouldListAllCategories() {
        CategoryService categoryService = mock(CategoryService.class);
        Scanner scanner = new Scanner("");

        when(categoryService.listAllCategory())
                .thenReturn(List.of(new Category("Fruit"), new Category("Légume")));

        ListCategoriesCommand cmd = new ListCategoriesCommand(categoryService, scanner);
        cmd.execute();

        // Appelé deux fois dans execute()
        verify(categoryService, times(2)).listAllCategory();
    }
}
