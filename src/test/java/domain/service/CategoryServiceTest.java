package domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

	@Mock
	private CategoryRepo repo;

	@InjectMocks
	private CategoryService service;
	private Category cat;

	@BeforeEach
	public void setUp() {
		cat = new Category("fruit");
		cat.setId(1);
	}

	@Test
	public void shouldAddCategory() {
		Category result = service.addCategory("légume");
		assertEquals("légume", result.getName());
		verify(repo).save(result);
	}

	@Test
	public void shouldDeleteCategory() {
		service.delCategory(1);
		verify(repo).delete(1);
	}

	@Test
	public void shouldModifyCategoryName() {
		when(repo.findById(1)).thenReturn(cat);
		service.modifyNameCategory(1, "viande");
		assertEquals("viande", cat.getName());
		verify(repo).save(cat);
	}

	@Test
	public void shouldModifyNameCategoryNotFound() {
		when(repo.findById(1)).thenReturn(null);
		service.modifyNameCategory(1, "surgelé");
		verify(repo, never()).save(any(Category.class));
	}

	@Test
	public void shouldListAllCategories() {
		List<Category> list = new ArrayList<Category>();
		list.add(cat);
		list.add(new Category("boisson"));
		when(repo.findAll()).thenReturn(list);
		List<Category> result = service.listAllCategory();
		assertEquals(2, result.size());
		assertEquals("fruit", result.get(0).getName());
		verify(repo).findAll();
	}
}