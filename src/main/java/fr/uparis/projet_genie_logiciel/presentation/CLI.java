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
                    service.listAllProduct(); //marche pas
                    break;
                case 2:
                    productRegister();
                    break;
                case 3:
                    increase();
                    break;
                case 4:
                    break;   
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    public void afficherMenu() {
        System.out.println("\n=== Gestion Stock ===");
        System.out.println("1. Lister produits");
        System.out.println("2. Enregistrer un produit");
        System.out.println("3. Augmenter ou baisser la quantité d'un produit");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }
    
    private void productRegister() { 
        System.out.print("Nom du produit: \n");
        String name = scanner.nextLine();

        System.out.print("\nQuantité du produit: \n");
        int quantity = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Dans quel catégorie voulez vous ajouter le produit? \n");
        String nameCategory = scanner.nextLine();

        service.addProduct(name, quantity, categoryService.addCategory(nameCategory)); //je dois ajouter une categorie mais je dois d'abord demander le nom puis...
        System.out.println("Entrée enregistrée.");
        System.out.println("\033[H\033[2J"); //censé nettoyer la console (je crois)
        afficherMenu();
    }
    
    private void increase() { 
        System.out.print("Nom du produit: \n");
        String name = scanner.nextLine();

        System.out.print("\nnombre de quantité que tu veux augmenter ou baisse (ex: 7 ou -3): \n");
        int quantity = Integer.parseInt(scanner.nextLine());

        service.increaseQuantity(name, quantity);
        System.out.println("Entrée enregistrée.");
        System.out.println("\033[H\033[2J"); //censé nettoyer la console (je crois)
        afficherMenu();
    }
}
