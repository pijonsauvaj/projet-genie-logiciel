package fr.uparis.projet_genie_logiciel.presentation.command;

import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

public class IncreaseProductCommand implements Command {
	private ProductService service;
	private Scanner scanner;

	public IncreaseProductCommand(ProductService service, Scanner scanner) {
		this.service = service;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void execute() {
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Quantity: ");
		int quantity = Integer.parseInt(scanner.nextLine());
		service.increaseQuantity(name, quantity);
		System.out.println("Registered");
	}

	@Override
	public String getName() {
		return "increase";
	}

	@Override
	public String getDescription() {
		return "Increase quantity of a product";
	}

}
