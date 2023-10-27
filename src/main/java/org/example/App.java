package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class App {

    public static void run(){
        List<String> text = new ArrayList<>();
        String filePath = "D:\\mine\\code\\JavaProjects\\Lab5\\src\\main\\resources\\text.txt";
        int choice = 0;
        while (true) {
            System.out.println("1 - Read text from file\n2 - Read text from console\n3 - Exit");
            choice = ScannerManager.readIntFromConsole();
            if(choice == 1){
                    text = TextFileReader.readTextFromFile(filePath);
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

        System.out.println(text.size());
        //ListPrinter.printList(text);


        RegularExpressionController rbcontroller = new RegularExpressionController();
        ListPrinter.printList(rbcontroller.findQuestions(text));
    }
}

