package com.example;

public class CaesarCipher {

    // Fonction pour chiffrer une chaîne avec un chiffre de César
    public static String caesarCipher(String input, int key) {
        StringBuilder encrypted = new StringBuilder();

        // Parcourir chaque caractère de la chaîne
        for (char character : input.toCharArray()) {
            // Vérifier si le caractère est une lettre majuscule
            if (character >= 'A' && character <= 'Z') {
                char newChar = (char) (((character - 'A' + key) % 26) + 'A');
                encrypted.append(newChar);
            }
            // Vérifier si le caractère est une lettre minuscule
            else if (character >= 'a' && character <= 'z') {
                char newChar = (char) (((character - 'a' + key) % 26) + 'a');
                encrypted.append(newChar);
            }
            // Si ce n'est pas une lettre, ne pas modifier le caractère
            else {
                encrypted.append(character);
            }
        }

        return encrypted.toString();
    }
}

