package com.example;

import java.util.Scanner;

public class BinaryConverter {
    
    public static void ConverterToBinary(Scanner scanner) {
        System.out.print("Choose conversion (1 for Text to Binary, 2 for Binary to Text): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left by nextInt()
        
        if (choice == 1) {
            textToBinaryConverter(scanner);
        } else if (choice == 2) {
            binaryToTextConverter(scanner);
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
        }
        
        scanner.close();
    }
    
    public static void textToBinaryConverter(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String binaryString = stringToBinary(input);
        System.out.println("Binary representation: " + binaryString);


    }
    
    public static void binaryToTextConverter(Scanner scanner) {
        System.out.print("Enter a binary string (space-separated): ");
        String binaryInput = scanner.nextLine();
        System.out.print("Do you want to encrypt the result? Y/N : ");
        String caesar = scanner.nextLine();

        switch (caesar) {
            case "Y":
                System.out.print("Enter an encryption key (integer): ");
                int key = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Converted back to text: " + CaesarCipher.caesarCipher(binaryToString(binaryInput), key));
                break;
            case "N":
                String convertedText = binaryToString(binaryInput);
                System.out.println("Converted back to text: " + convertedText);
                break;

            default:
                System.out.println("Invalid choice");
                System.out.println("Closure of the program...");
                break;
        }
        }

    public static String stringToBinary(String input) {
        StringBuilder binaryResult = new StringBuilder();

        // Convert each character to its binary representation
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            binaryResult.append(charToBinary(character));
            if (i < input.length() - 1) {
                binaryResult.append(" ");  // Add space between binary values
            }
        }

        return binaryResult.toString();
    }

    public static String binaryToString(String binary) {
        StringBuilder textResult = new StringBuilder();

        // Split binary string into segments of 8 bits
        String[] binarySegments = binary.split(" ");
        for (String binarySegment : binarySegments) {
            // Convert binary segment to decimal integer
            int asciiValue = Integer.parseInt(binarySegment, 2);
            // Convert ASCII value to character
            char character = (char) asciiValue;
            // Append character to result
            textResult.append(character);
        }

        return textResult.toString();
    }

    public static String charToBinary(char character) {
        StringBuilder binary = new StringBuilder();
        int asciiValue = (int) character;

        // Convert the ASCII value to binary
        for (int i = 7; i >= 0; i--) {
            int bit = (asciiValue >> i) & 1;
            binary.append(bit);
        }

        return binary.toString();
    }
}
