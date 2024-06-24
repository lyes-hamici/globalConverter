package com.example;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 4) {
            System.out.println("Usage: java Main -<language> <message> [-r] [-k <key>]");
            return;
        }

        String base = args[0];
        String message = args[1];
        boolean reverse = false;
        int key = 0; // Default key

        for (int i = 2; i < args.length; i++) {
            if (args[i].equals("-r")) {
                reverse = true;
            } else if (args[i].equals("-k")) {
                if (i + 1 < args.length) {
                    try {
                        key = Integer.parseInt(args[i + 1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid key. Please enter a valid integer.");
                        return;
                    }
                    i++; // Skip the next argument which is the key
                } else {
                    System.out.println("Missing key after -k.");
                    return;
                }
            } else {
                System.out.println("Invalid argument: " + args[i]);
                return;
            }
        }

        Controller controller = new Controller(base, message, reverse, key);


        // Call your translation methods here with the parsed arguments
        // For example:
        // Translator translator = new Translator();
        // String translated = translator.translate(message, language, reverse, key);
        // System.out.println("Translated string: " + translated);
    }
}