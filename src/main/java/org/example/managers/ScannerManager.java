package org.example.managers;

import java.util.InputMismatchException;
import java.util.Scanner;

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
}
