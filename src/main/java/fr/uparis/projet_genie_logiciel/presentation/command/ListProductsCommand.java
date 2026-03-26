package fr.uparis.projet_genie_logiciel.presentation.command;
import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

public class ListProductsCommand implements Command {
	private CategoryService categoryService;
    private ProductService service;
    private Scanner scanner;

    public ListProductsCommand(CategoryService categoryService, ProductService service, Scanner scanner) {
    	this.categoryService = categoryService;
    	this.service = service;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("\n=== Products List ===");
        service.getAllProduct().forEach(System.out::println);
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "List all products";
    }
}