package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class ScannerManager {
    static public Integer readIntFromConsole(){
        Integer choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                choice = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("You entered wrong symbol, try agian:");
                scanner.next();
            }
        }
        return choice;
    }
    static public List<String> readTextFromConsole(){
        System.out.println("Enter you text:\n");
        List<String> sentences = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputText = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputText.append(line).append("\n");
        }
        String[] words = inputText.toString().split("\\s+");
        StringBuilder currentSentence = new StringBuilder();
        for (String word : words) {
            currentSentence.append(word).append(" ");
            char lastChar = word.charAt(word.length() - 1);
            if (lastChar == '.' || lastChar == '?' || lastChar == '!') {
                sentences.add(currentSentence.toString().trim());
                currentSentence.setLength(0);
            }
        }
        return sentences;
    }
}
