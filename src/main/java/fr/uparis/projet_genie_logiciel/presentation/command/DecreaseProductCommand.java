package fr.uparis.projet_genie_logiciel.presentation.command;

import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

public class DecreaseProductCommand implements Command {
    private ProductService service;
    private Scanner scanner;

    public DecreaseProductCommand(ProductService service, Scanner scanner) {
    	this.service = service;
        this.scanner = new Scanner(System.in);
    }
	
	@Override
	public void execute() { 
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        service.decreaseQuantity(name, quantity);
        System.out.println("Registered");
    }
    
    
    @Override
    public String getName() { return "decrease"; }

    @Override
    public String getDescription() { return "Decrease quantity of a product"; }

}
