package com.example;

import java.util.Scanner;

public class EndMenu {
    public static void end() {
        System.out.print("Go back to the main menu Y/N : ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        

        switch (choice) {
            case "Y":
                Menu.menu();
                scanner.close();
                break;
            case "N":
                System.out.println("Closure of the program...");
                scanner.close();
                break;

            default:
                System.out.println("Invalid choice");
                System.out.println("Closure of the program...");
                scanner.close();
                break;
        }
    }
}
