package fr.uparis.projet_genie_logiciel;

import fr.uparis.projet_genie_logiciel.persistance.CategoryRepo;
import fr.uparis.projet_genie_logiciel.persistance.ProductRepo;
import fr.uparis.projet_genie_logiciel.presentation.CLI;
import fr.uparis.projet_genie_logiciel.domain.*;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	ProductRepo repo = new ProductRepo();
    	CategoryRepo rep = new CategoryRepo();
    	ProductService ps = new ProductService(repo);
    	CategoryService cs = new CategoryService(rep);
    	CLI cli = new CLI(ps, cs);
    	cli.start();
    }
}
