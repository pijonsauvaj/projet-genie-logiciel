package fr.uparis.projet_genie_logiciel;

import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;
import fr.uparis.projet_genie_logiciel.presentation.CLI;
import fr.uparis.projet_genie_logiciel.presentation.command.AddProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.DecreaseProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.DeleteProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ExitCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.IncreaseProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ListCategoriesCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ListProductsCommand;

import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;
import fr.uparis.projet_genie_logiciel.factory.CommandFactory;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CategoryRepo categoryRepo = new CategoryRepo();
        CategoryService categoryService = new CategoryService(categoryRepo);

        ProductRepo repo = new ProductRepo();
        ProductService service = new ProductService(repo, categoryService);
        CommandFactory factory = new CommandFactory(categoryService, service, scanner);
        
        CLI cli = new CLI();
        cli.register(factory.add());
        cli.register(factory.listProducts());
        cli.register(factory.delete());
        cli.register(factory.increase());
        cli.register(factory.decrease());
        cli.register(factory.listCategories());
        cli.register(factory.exit());

        cli.run();
    }
}

