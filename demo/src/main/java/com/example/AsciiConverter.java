package com.example;

import java.util.Scanner;

public class AsciiConverter {
    
    public static void scanText(Scanner scanner) {
        try {
            printOptions();
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the text to convert: ");
            String userInput = scanner.nextLine();
            userChoices(userChoice, userInput);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void userChoices(int userChoice, String userInput) {
        switch (userChoice) {
            case 1:
                String ascii = fromStringToAscii(userInput);
                printAscii(ascii);
                break;
            case 2:
                String text = fromAsciiToString(userInput);
                printText(text);
                break;
            case 3:
                System.out.println("-----------------------");
                System.out.println("Looking forward to seeing you again.");
                System.out.println("-----------------------");
                break;
            default:
                System.out.println("Invalid choice");
                userChoices(userChoice, userInput);
                break;
        }
        
    }

    public static String fromStringToAscii(String text)
    {
        String ascii = "";
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int asciiInt = (int) character;
            ascii += asciiInt + " ";
        }
        return ascii;
    }

    public static String fromAsciiToString(String ascii)
    {
        String text = "";
        String[] asciiArray = ascii.split(" ");
        for (String asciiValue : asciiArray) {
            int asciiInt = Integer.parseInt(asciiValue);
            char character = (char) asciiInt;
            text += character;
        }
        return text;
    }

    public static void printAscii(String ascii)
    {
        System.out.println("The ASCII value of the text is: " + ascii);

        System.out.print("Go back to the main menu Y/N : ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        scanner.close();

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

    public static void printText(String text)
    {
        System.out.println("The text value of the ASCII is: " + text);

        System.out.print("Go back to the main menu Y/N : ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        scanner.close();

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

    public static void printOptions()
    {
        System.out.println("Enter your choice:");
        System.out.println("1: Text --> ASCII");
        System.out.println("2: ASCII --> Text");
        System.out.println("3: Quit");
        System.out.print("Yopur choice: ");
    }
}
