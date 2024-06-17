package com.example;



import java.util.Scanner;

public class Menu {
    public static void menu(){
        String texte = "Global converter"; 
        
        int longueurTexte = texte.length();
        int largeurLigne = longueurTexte + 4; 
        
        // Imprimer la ligne supérieure d'étoiles
        for (int i = 0; i < largeurLigne; i++) {
            System.out.print("*");
            
        }
        System.out.println(); // Saut de ligne
        
        // Imprimer la ligne de texte entourée d'étoiles
        System.out.println("* " + texte + " *");
        
        // Imprimer la ligne inférieure d'étoiles
        for (int i = 0; i < largeurLigne; i++) {
            System.out.print("*");
        }
        System.out.println(); // Saut de ligne
        System.out.println("----------------------");
        System.out.println("1 : Texte --> ASCII"); // Choix 1 --> Texte --> ASCII
        System.out.println("2 : ASCII --> Texte"); // Choix 2 --> ASCII --> Texte
        System.out.println("3 : Quitter"); // Choix 3 --> Leave

        System.out.println(); // Saut de ligne



        Scanner scanner = new Scanner(System.in);
        choix_menu(scanner);

        scanner.close();
    }


    public static void choix_menu(Scanner scanner) {
        try {
            System.out.print("Votre choix: ");
            String Value = scanner.nextLine(); 

            switch (Value) {
                case "1":
                    // envoi vers choix de conversion ascii(scanner);
                    break;
                case "2":
                    // envoi vers choix de conversion texte(scanner);
                    break;
                case "3":
                    System.out.println("-----------------------");
                    System.out.println("Au plaisir de vous revoir.");
                    System.out.println("-----------------------");
                    break;
                default:
                    System.out.println("Choix invalide");
                    choix_menu(scanner);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


