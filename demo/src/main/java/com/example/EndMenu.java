package com.example;

import java.util.Scanner;

public class EndMenu {
    public static void end(Scanner scanner) {
        System.out.print("Go back to the main menu Y/N : ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "Y":
                Menu.menu();
                break;
            case "N":
                System.out.println("Closure of the program...");
                break;

            default:
                System.out.println("Invalid choice");
                System.out.println("Closure of the program...");
                break;
        }
    }
}
