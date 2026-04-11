package fr.uparis.projet_genie_logiciel.factory;

import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.presentation.command.AddProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.Command;
import fr.uparis.projet_genie_logiciel.presentation.command.DecreaseProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.DeleteProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ExitCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.IncreaseProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ListCategoriesCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ListProductsCommand;

public class CommandFactory {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final Scanner scanner;

    public CommandFactory(CategoryService categoryService,
                          ProductService productService,
                          Scanner scanner) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.scanner = scanner;
    }

    public Command add() {
        return new AddProductCommand(categoryService, productService, scanner);
    }

    public Command listProducts() {
        return new ListProductsCommand(categoryService, productService, scanner);
    }

    public Command delete() {
        return new DeleteProductCommand(categoryService, productService, scanner);
    }

    public Command increase() {
        return new IncreaseProductCommand(productService, scanner);
    }

    public Command decrease() {
        return new DecreaseProductCommand(productService, scanner);
    }

    public Command listCategories() {
        return new ListCategoriesCommand(categoryService, scanner);
    }

    public Command exit() {
        return new ExitCommand();
    }
}
