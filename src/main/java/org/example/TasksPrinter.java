package org.example;

import java.util.List;

public class TasksPrinter {
    public static void printList(List<String> text) {
        for (String sentence: text) {
            System.out.println(sentence);
        }
    }
    public static void printQuestions(List<String> text){
        RegularExpressionController rbcontroller = new RegularExpressionController();
        TasksPrinter.printList(rbcontroller.findQuestions(text));
    }
    public static void printWordsFromQuestionsOfCertainLength(List<String> text){
        System.out.println("Enter the length of the word:\n");
        int length = ScannerManager.readIntFromConsole();
        if(length > 0){
            RegularExpressionController rbcontroller = new RegularExpressionController();
            TasksPrinter.printList(rbcontroller.findWordsOfCertainLength(text, length));
        }else {
            System.out.println("There is a wrong length");
        }
    }
}
