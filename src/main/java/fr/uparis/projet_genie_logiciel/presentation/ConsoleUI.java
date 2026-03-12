package fr.uparis.projet_genie_logiciel.presentation;

import fr.uparis.projet_genie_logiciel.metier.model.Produit;
import fr.uparis.projet_genie_logiciel.metier.service.GestionStockService;

import java.util.Scanner;

public class ConsoleUI {

    private GestionStockService service;
    private Scanner scanner;

    public ConsoleUI(GestionStockService service) {
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
                    listerProduits();
                    break;
                case 2:
                    enregistrerEntree();
                    break;
                case 3:
                    enregistrerSortie();
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

    private void listerProduits() {
        for (Produit p : service.listerProduits()) {
            System.out.println(p.getNom() + " - Quantité : " + p.getQuantite());
        }
    }

    private void enregistrerEntree() {
        System.out.print("Référence : ");
        String ref = scanner.nextLine();

        System.out.print("Quantité : ");
        int qte = Integer.parseInt(scanner.nextLine());

        service.enregistrerEntree(ref, qte);
        System.out.println("Entrée enregistrée.");
    }

    private void enregistrerSortie() {
        System.out.print("Référence : ");
        String ref = scanner.nextLine();

        System.out.print("Quantité : ");
        int qte = Integer.parseInt(scanner.nextLine());

        service.enregistrerSortie(ref, qte);
        System.out.println("Sortie enregistrée.");
    }
}