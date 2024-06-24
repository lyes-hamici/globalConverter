package com.example;

public class Controller {
    private String base;
    private String message;
    private boolean reverse;
    private int key;
    private String translatedMessage;

    public Controller(String base, String message, boolean reverse, int key) {
        this.base = base;
        this.message = message;
        this.reverse = reverse;
        this.key = key;
        this.translatedMessage = "";
    }

    public void translate() {
        String translatedMessage = "";
        switch (base) {
            case "-b":
            case "binary":
                // Call your method to translate the message to binary
                if (reverse) {
                    // Reverse the translated message
                }
                else {
                    // Translate the message to binary
                   
                }
                break;
            case "-o":
            case "octal":
                // Call your method to translate the message to octal
                break;
            case "-d":
            case "decimal":
                // Call your method to translate the message to decimal
                
                break;
            case "-h":
            case "hexadecimal":
                // Call your method to translate the message to hexadecimal
                break;
            case "-t":
            case "text":
                // Call your method to translate the message to text
                break;
            default:
                System.out.println("Invalid base: " + base);
                return;
        }
        if (reverse) {
            // Reverse the translated message
        }
        System.out.println("Translated message: " + translatedMessage);
    }
}