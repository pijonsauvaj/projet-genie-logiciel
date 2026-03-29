package fr.uparis.projet_genie_logiciel.presentation.command;
import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

public class ListCategoriesCommand implements Command {
	private CategoryService categoryService;
    private Scanner scanner;

    public ListCategoriesCommand(CategoryService categoryService, Scanner scanner) {
    	this.categoryService = categoryService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("\n=== Categories List ===");
        categoryService.listAllCategory().forEach(System.out::println);
    }

    @Override
    public String getName() {
        return "listCat";
    }

    @Override
    public String getDescription() {
        return "List all categories";
    }
}