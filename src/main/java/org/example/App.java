package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void run(){
        List<String> text = new ArrayList<>();
        String filePath = "D:\\mine\\code\\JavaProjects\\Lab5\\src\\main\\resources\\text.txt";
        int choice = 0;
        while (true) {
            System.out.println("1 - Read text from file\n2 - Read text from console\n3 - Exit");
            choice = ScannerManager.readIntFromConsole();
            if(choice == 1){
                try {
                    text = TextFileReader.readTextFromFile(filePath);
                }
                 catch (Exception ex){
                     System.out.println(ex);
                     return;
                 }
                    break;
            }
            else if(choice == 2) {
                    text = ScannerManager.readTextFromConsole();
                    break;
            }
            else if(choice == 3){
                 return;
            }
             else {
                System.out.println("You entered wrong symbol, try again!\n");
            }
        }
        while (true) {
            System.out.println("1 - Print all text\n2 - Print only questions\n3 - Enter the length of word\n4 - Exit");
            choice = ScannerManager.readIntFromConsole();
            if(choice == 1){
                TasksPrinter.printList(text);
                break;
            }
            else if(choice == 2) {
                TasksPrinter.printQuestions(text);
                break;
            }
            else if(choice == 3){
                TasksPrinter.printWordsFromQuestionsOfCertainLength(text);
                break;
            }
            else if(choice == 4)
                return;
            else {
                System.out.println("You entered wrong symbol, try again!\n");
            }
        }

    }
}

