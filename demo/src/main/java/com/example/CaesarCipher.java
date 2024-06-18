package com.example;

public class CaesarCipher {

    // Function to encrypt a string using a Caesar cipher
    public static String caesarCipher(String input, int key) {
        StringBuilder encrypted = new StringBuilder();

        // Loop through each character in the string
        for (char character : input.toCharArray()) {
            // Check if the character is an uppercase letter
            if (character >= 'A' && character <= 'Z') {
                char newChar = (char) (((character - 'A' + key) % 26) + 'A');
                encrypted.append(newChar);
            }
            // Check if the character is a lowercase letter
            else if (character >= 'a' && character <= 'z') {
                char newChar = (char) (((character - 'a' + key) % 26) + 'a');
                encrypted.append(newChar);
            }
            // If it is not a letter, do not modify the character
            else {
                encrypted.append(character);
            }
        }

        return encrypted.toString();
    }}