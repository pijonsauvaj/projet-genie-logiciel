package fr.uparis.projet_genie_logiciel.presentation;


import java.util.Scanner;

import fr.uparis.projet_genie_logiciel.domain.model.Category;
import fr.uparis.projet_genie_logiciel.domain.service.CategoryService;
import fr.uparis.projet_genie_logiciel.domain.service.ProductService;

public class CLI {
	private CategoryService categoryService;
    private ProductService service;
    private Scanner scanner;

    public CLI(ProductService service, CategoryService categoryService) {
    	this.categoryService = categoryService;
    	this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            afficherMenu();
            int choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    service.listAllProduct();
                    break;
                case 2:
                    service.addProduct(null, choix, null);
                    break;
                case 3:
                    service.increaseQuantity(choix, choix);
                    break;
                case 4:
                    service.decreaseQuantity(choix, choix);
                    break;   
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private void afficherMenu() {
        System.out.println("\n=== Gestion Stock ===");
        System.out.println("1. Lister produits");
        System.out.println("2. Entrée de stock");
        System.out.println("3. Sortie de stock");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }
    
    private void productRegister() { //Y'a un truc qui va pas au niveau des categories
        System.out.print("Nom du produit: \n");
        String name = scanner.nextLine();

        System.out.print("\n\nQuantité du produit: \n");
        int quantity = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Dans quel catégorie voulez vous ajouter le produit? \n");
        String nameCategory = scanner.nextLine();
        Category category = new Category(nameCategory);
        categoryService.addCategory(nameCategory);

        service.addProduct(name, quantity, category); //je dois ajouter une categorie mais je dois d'abord demander le nom puis...
        System.out.println("Entrée enregistrée.");
    }
	
}
