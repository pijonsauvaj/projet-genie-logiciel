package fr.uparis.projet_genie_logiciel.presentation.command;

import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;

public class AddCategoryCommand implements Command {

	private final CategoryService categoryService;
	private final Scanner scanner;

	public AddCategoryCommand(CategoryService categoryService, Scanner scanner) {
		this.categoryService = categoryService;
		this.scanner = scanner;
	}

	@Override
	public void execute() {
		System.out.print("Category name: ");
		String name = scanner.nextLine();
		boolean created = categoryService.addCategory(name);
		if (created) {
			System.out.println("Category created.");
		} else {
			System.out.println("Existing category.");
		}
	}

	@Override
	public String getName() {
		return "add category";
	}

	@Override
	public String getDescription() {
		return "Add a new category";
	}
}
