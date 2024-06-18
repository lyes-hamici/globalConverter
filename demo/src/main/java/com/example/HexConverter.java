package com.example;

import java.util.Scanner;

public class HexConverter {
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
                String hex = fromStringToHex(userInput);
                printHex(hex);
                break;
            case 2:
                String text = fromHexToString(userInput);
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

    public static String fromStringToHex(String text)
    {
        String asciiText = AsciiConverter.fromStringToAscii(text);
        StringBuilder hex = new StringBuilder();
        String[] asciiArray = asciiText.split(" ");

        for (String asciiValue : asciiArray) {
            int intValue = Integer.parseInt(asciiValue);
            hex.append(intToHex(intValue)).append(" ");;
        }

        return hex.toString();
    }

    public static String intToHex(int num) {
        StringBuilder hex = new StringBuilder();
        while (num != 0) {
            int remainder = num % 16;
            if (remainder < 10) {
                hex.append((char) ('0' + remainder));
            } else {
                hex.append((char) ('A' + (remainder - 10)));
            }
            num = num / 16;
        }
        return hex.length() == 1 ? "0" + hex.reverse().toString() : hex.reverse().toString();
    }

    public static String fromHexToString(String hex) {
        StringBuilder text = new StringBuilder();
        String[] hexPairs = hex.split(" ");

        for (String hexPair : hexPairs) {
            int intValue = hexToInt(hexPair);
            text.append((char) intValue);
        }

        return text.toString();
    }

    public static int hexToInt(String hex) {
        int intValue = 0;
        for (char c : hex.toCharArray()) {
            intValue *= 16;
            if (c >= '0' && c <= '9') {
                intValue += c - '0';
            } else if (c >= 'A' && c <= 'F') {
                intValue += c - 'A' + 10;
            }
        }
        return intValue;
    }

    public static void printHex(String hex)
    {
        System.out.println("The HEXADECIAML value of the text is: " + hex);
        EndMenu.end();
        
    }

    public static void printText(String text)
    {
        System.out.println("The text value of the HEXADECIMAL is: " + text);
        EndMenu.end();
    }

    public static void printOptions()
    {
        System.out.println("Enter your choice:");
        System.out.println("1: Text --> HEXADECIMAL");
        System.out.println("2: HEXADECIMAL --> Text");
        System.out.println("3: Quit");
        System.out.print("Your choice: ");
    }
}
