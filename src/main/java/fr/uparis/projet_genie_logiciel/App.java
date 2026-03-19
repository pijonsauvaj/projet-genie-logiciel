package fr.uparis.projet_genie_logiciel;

import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;
import fr.uparis.projet_genie_logiciel.presentation.CLI;
import fr.uparis.projet_genie_logiciel.presentation.command.AddProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.DeleteProductCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ExitCommand;
import fr.uparis.projet_genie_logiciel.presentation.command.ListProductsCommand;


import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

 class App 
{
    public static void main( String[] args ){
	    Scanner scanner = new Scanner(System.in);
	    ProductRepo repo = new ProductRepo();
	    ProductService service = new ProductService(repo);
	    CategoryRepo categoryRepo = new CategoryRepo();
	    CategoryService categoryService = new CategoryService(categoryRepo);

	    CLI cli = new CLI();
	    cli.register(new AddProductCommand(categoryService, service, scanner));
	    cli.register(new ListProductsCommand(categoryService, service, scanner));
	    cli.register(new DeleteProductCommand(categoryService, service, scanner));
	    cli.register(new ExitCommand());
	    cli.run();
	}
}
