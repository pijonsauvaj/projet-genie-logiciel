package fr.uparis.projet_genie_logiciel.presentation.command;
import java.util.Scanner;


import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

public class DeleteProductCommand implements Command {

	private CategoryService categoryService;
    private ProductService service;
    private Scanner scanner;

    public DeleteProductCommand(CategoryService categoryService, ProductService service, Scanner scanner) {
    	this.categoryService = categoryService;
    	this.service = service;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        service.delProduct(name);
        System.out.println("Product deleted.");
    }

    @Override
    public String getName() {
        return "delete";
    }

    @Override
    public String getDescription() {
        return "Delete a product by name";
    }
}