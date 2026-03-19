package fr.uparis.projet_genie_logiciel.presentation.command;

import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

public class AddProductCommand implements Command {
	private CategoryService categoryService;
    private ProductService service;
    private Scanner scanner;

    public AddProductCommand(CategoryService categoryService, ProductService service, Scanner scanner) {
    	this.categoryService = categoryService;
    	this.service = service;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() { 
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Category: ");
        String nameCategory = scanner.nextLine();
        service.addProduct(name, quantity, categoryService.addCategory(nameCategory)); //je dois ajouter une categorie mais je dois d'abord demander le nom puis...
        System.out.println("Entrée enregistrée.");
    }

    @Override
    public String getName() { return "add"; }

    @Override
    public String getDescription() { return "Add a new product"; }
}