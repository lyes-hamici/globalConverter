package com.example;

import java.util.Scanner;

public class AsciiConverter {

    private static String result;
    
    public static void scanText(Scanner scanner) {
        try {
            printOptions();
            userChoices(scanner);
            EndMenu.end(scanner);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void userChoices(Scanner scanner) {
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the text to convert: ");
        String userInput = scanner.nextLine();

        switch (userChoice) {
            case 1:
                result = fromStringToAscii(userInput);
                printAscii(result);
                break;
            case 2:
                result = fromAsciiToString(userInput);
                userCypherChoice(scanner);

                break;
            case 3:
                System.out.println("-----------------------");
                System.out.println("Looking forward to seeing you again.");
                System.out.println("-----------------------");
                break;
            default:
                System.out.println("Invalid choice");
                userChoices(scanner);
                break;
        }
    }

    public static void userCypherChoice(Scanner scanner)
    {
        System.out.print("Do you want to encrypt the result? Y/N : ");
        String caesar = scanner.nextLine();
        switch (caesar) {
            case "Y":
                System.out.print("Enter an encryption key (integer): ");
                int key = scanner.nextInt();
                result = CaesarCipher.caesarCipher(result, key);
                printText(result);
                scanner.nextLine();
                break;
            case "N":
                printText(result);
                break;
            default:
                System.out.println("Invalid choice");
                userCypherChoice(scanner);
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
        
        
    }

    public static void printText(String text)
    {
        System.out.println("The text value of the ASCII is: " + text);
    }

    public static void printOptions()
    {
        System.out.println("Enter your choice:");
        System.out.println("1: Text --> ASCII");
        System.out.println("2: ASCII --> Text");
        System.out.println("3: Quit");
        System.out.print("Your choice: ");
    }
}
