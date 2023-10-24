package org.example;

import org.example.managers.CollectionManager;
import org.example.managers.CollectionPrinter;
import org.example.managers.ScannerManager;

import java.util.*;

public class App {

    public static void run(){
        CollectionPrinter manager = new CollectionPrinter();
        String filePath = "D:\\mine\\code\\JavaProjects\\Lab3\\src\\main\\resources\\list.txt";
        String filePath2 = "D:\\mine\\code\\JavaProjects\\Lab3\\src\\main\\resources\\list2.txt";

        List<Employee> employeeList = FileReader.readEmployeesFromFile(filePath);
        List<Employee> employeeList2 = FileReader.readEmployeesFromFile(filePath2);

        System.out.println("Do you want to read from one file or two?\n" +
                "1 - One file\n2 - Two files\n");

        int choice = ScannerManager.readIntFromConsole();
        if(choice == 2){
            employeeList = CollectionManager.mergeTwoLists(employeeList, employeeList2);
        }
        else if(choice != 1){
            System.out.println("Invalid choice\n");
            return;
        }

        while (true) {
            System.out.println("Choose what you want to do:\n1 - print all employees\n2 - print map with date key sorted by position\n" +
                    "3 - do the same as higher but also delete those who've been hired more than 10 years ago\n" +
                    "4 - print the frequency table of people with a given position\n5 - exit");
            choice = ScannerManager.readIntFromConsole();
            switch (choice){
                case 1:{
                    manager.printAllEmployees(employeeList);
                    break;
                }
                case 2:{
                    manager.printMapWithHireDateKeySortByPosition(employeeList);
                    break;
                }
                case 3:{
                    manager.printMapWithoutThoseWhoveBeenHired10YearsAgo(employeeList);
                    break;
                }
                case 4:{
                    manager.printFrequencyTableOfPositions(employeeList);
                    break;
                }
                case 5:{
                    return;
                }
                default:{
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
                }
            }
        }
    }
}
