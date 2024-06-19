package com.example;

import java.util.Scanner;

public class OctalConverter {
    
    public static void ConverterToOctal(Scanner scanner) {
        System.out.print("Choose conversion (1 for Text to Octal, 2 for Octal to Text): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left by nextInt()
        
        if (choice == 1) {
            textToOctalConverter(scanner);
        } else if (choice == 2) {
            octalToTextConverter(scanner);
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
        }
        
        scanner.close();
    }
    
    public static void textToOctalConverter(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String octalString = stringToOctal(input);
        System.out.println("Octal representation:");
        printWithSpaces(octalString);

        EndMenu.end(scanner);
    }
    
    public static void octalToTextConverter(Scanner scanner) {
        System.out.print("Enter an octal string (space-separated): ");
        String octalInput = scanner.nextLine();
        System.out.print("Do you want to encrypt the result? Y/N : ");
        String caesar = scanner.nextLine();

        switch (caesar) {
            case "Y":
                System.out.print("Enter an encryption key (integer): ");
                int key = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Converted back to text: " + CaesarCipher.caesarCipher(octalToString(octalInput), key));
                break;
            case "N":
                String convertedText = octalToString(octalInput);
                System.out.println("Converted back to text: " + convertedText);
                break;

            default:
                System.out.println("Invalid choice");
                System.out.println("Closure of the program...");
                break;
        }
        EndMenu.end(scanner);

    }

    public static String stringToOctal(String input) {
        StringBuilder octalResult = new StringBuilder();

        // Convert each character to its octal representation
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            octalResult.append(charToOctal(character));
            if (i < input.length() - 1) {
                octalResult.append(" ");  // Add space between octal values
            }
        }

        return octalResult.toString();
    }

    public static String octalToString(String octal) {
        StringBuilder textResult = new StringBuilder();

        // Split octal string into segments of 3 digits
        String[] octalSegments = octal.split(" ");
        for (String octalSegment : octalSegments) {
            // Convert octal segment to decimal integer
            int asciiValue = Integer.parseInt(octalSegment, 8);
            // Convert ASCII value to character
            char character = (char) asciiValue;
            // Append character to result
            textResult.append(character);
        }

        return textResult.toString();
    }

    public static String charToOctal(char character) {
        StringBuilder octal = new StringBuilder();
        int asciiValue = (int) character;

        // Convert the ASCII value to octal
        for (int i = 2; i >= 0; i--) { // 3 digits for octal
            int digit = (asciiValue >> (i * 3)) & 7; // 7 because 2^3 - 1
            octal.append(digit);
        }

        return octal.toString();
    }
    
    public static void printWithSpaces(String octalString) {
        // Split octal string into segments of 3 digits
        String[] octalSegments = octalString.split(" ");
        for (String octalSegment : octalSegments) {
            System.out.print(octalSegment + " ");
        }
        System.out.println();
    }
}
