package com.example;

import java.util.Scanner;

public class Menu {
    public static void menu(){
        String text = "Global converter";
        
        int textLength = text.length();
        int lineWidth = textLength + 4;
        
        // Print the top line of asterisks
        for (int i = 0; i < lineWidth; i++) {
            System.out.print("*");
        }
        System.out.println(); // Line break
        
        // Print the line of text surrounded by asterisks
        System.out.println("* " + text + " *");
        
        // Print the bottom line of asterisks
        for (int i = 0; i < lineWidth; i++) {
            System.out.print("*");
        }
        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : Binary"); // Option 1 
        System.out.println("2 : Hexadecimal"); // Option 2 
        System.out.println("3 : Octal"); // Option 3
        System.out.println("4 : Decimal"); // Option 4 
        System.out.println("5 : Quit"); // Option 5 --> Quit

        System.out.println(); // Line break

        Scanner scanner = new Scanner(System.in);
        menuChoice(scanner);

        scanner.close();
    }

    public static void menuChoice(Scanner scanner) {
        try {
            System.out.print("Your choice: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    BinaryConverter.ConverterToBinary(scanner);
                    break;
                case "2":
                    // redirect to  hexadecimal choice(scanner);
                    break;
                    case "3":
                    // redirect to  octal choice(scanner);
                    break;
                    case "4":
                    // redirect to  decimal choice(scanner);
                    AsciiConverter.scanText(scanner);
                    break;
                case "5":
                    System.out.println("-----------------------");
                    System.out.println("Looking forward to seeing you again.");
                    System.out.println("-----------------------");
                    break;
                default:
                    System.out.println("Invalid choice");
                    menuChoice(scanner);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
