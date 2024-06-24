package com.example;

import java.util.Scanner;

public class TextDecipher {
 
    public static void textDecipher(Scanner scanner) {
        System.out.print("Enter text to decrypt : ");
        String text = scanner.nextLine();

        System.out.print("Enter a key : ");
        int key = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Decrypted text : " + CaesarCipher.caesarDecipher(text, key));

    }
}
