package org.example;

import org.example.instruments.*;
import org.example.manager.ScannerManager;
import org.example.manager.SearchManager;
import org.example.manager.SortManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class App {
    static public void run() {
        List<Instrument> allInstrumentsList = initializeInstruments();
        Integer choice = 0;
        while (true) {
            System.out.println("Enter what you want:\n1 - Search specific type of instruments\n2 - Search instruments for a band\n" +
                    "3 - Sort all instruments by name\n4 - Sort all instruments by prize\n5 - Exit");
            choice = ScannerManager.readIntFromConsole();
            switch (choice) {
                case 1: {
                    searchInstruments(allInstrumentsList);
                    break;
                }
                case 2: {
                    searchInstrumentsForBand(allInstrumentsList);
                    break;
                }
                case 3: {
                    List<Instrument> sortedList = new ArrayList<>(allInstrumentsList);
                    sortedList.sort(new Comparator<Instrument>() {
                        @Override
                        public int compare(Instrument instrument1, Instrument instrument2) {
                            return instrument1.getName().compareTo(instrument2.getName());
                        }
                    });
                    howToSort(sortedList);
                    printList(sortedList);
                    break;
                }
                case 4: {
                    List<Instrument> sortedList = new ArrayList<>(allInstrumentsList);
                    sortedList.sort((instrument1, instrument2) -> Double.compare(instrument1.getPrize(), instrument2.getPrize()));
                    howToSort(sortedList);
                    printList(sortedList);
                    break;
                }
                case 5: {
                    return;
                }
                default:
                    System.out.println("There is no such choice!");
                    break;
            }
        }
    }

    static private List<Instrument> initializeInstruments() {
        List<KeyboardInstrument> keyboardInstrumentsList = ScannerManager.readInstrumentsFromFile(
                "D:/mine/code/JavaProjects/Lab2/src/main/resources/keyboardList.txt",
                KeyboardInstrument.class,
                String.class, double.class, String.class, int.class
        );
        List<PercussionInstrument> percussionInstrumentList = ScannerManager.readInstrumentsFromFile(
                "D:/mine/code/JavaProjects/Lab2/src/main/resources/percussionList.txt",
                PercussionInstrument.class,
                String.class, double.class, String.class, int.class
        );
        List<StringInstrument> stringInstrumentList = ScannerManager.readInstrumentsFromFile(
                "D:/mine/code/JavaProjects/Lab2/src/main/resources/stringList.txt",
                StringInstrument.class,
                String.class, double.class, String.class, String.class, int.class
        );
        List<WindInstrument> windInstrumentList = ScannerManager.readInstrumentsFromFile(
                "D:/mine/code/JavaProjects/Lab2/src/main/resources/windList.txt",
                WindInstrument.class,
                String.class, double.class, String.class, String.class, int.class
        );
        List<Instrument> allInstrumentsList = new ArrayList<>();
        allInstrumentsList.addAll(keyboardInstrumentsList);
        allInstrumentsList.addAll(percussionInstrumentList);
        allInstrumentsList.addAll(stringInstrumentList);
        allInstrumentsList.addAll(windInstrumentList);
        return allInstrumentsList;
    }

    static private void searchInstruments(List<Instrument> allInstrumentsList) {
        System.out.println("Choose the type:\n1 - Keyboard instruments\n2 - Percussion instruments\n3 - String instruments\n4 - Wind instruments\n" +
                "5 - Go back");
        Integer choice = ScannerManager.readIntFromConsole();
        List<Instrument> foundedList = new ArrayList<>();
        switch (choice) {
            case 1: {
                foundedList = SearchManager.searchForType(allInstrumentsList, "Keyboard");
                printList(foundedList);
                askToSort(foundedList);
                return;
            }
            case 2: {
                foundedList = SearchManager.searchForType(allInstrumentsList, "Percussion");
                printList(foundedList);
                askToSort(foundedList);
                return;
            }
            case 3: {
                foundedList = SearchManager.searchForType(allInstrumentsList, "String");
                printList(foundedList);
                askToSort(foundedList);
                return;
            }
            case 4: {
                foundedList = SearchManager.searchForType(allInstrumentsList, "Wind");
                printList(foundedList);
                askToSort(foundedList);
                return;
            }
            case 5: {
                return;
            }
            default:
                System.out.println("There is no such choice!");
                break;
        }
    }

    static private void searchInstrumentsForBand(List<Instrument> allInstrumentsList) {
        System.out.println("Choose the instrument:\n1 - Guitars\n2 - Pianos\n3 - Drums\n4 - Go back");
        Integer choice = ScannerManager.readIntFromConsole();
        List<Instrument> foundedList;
        switch (choice) {
            case 1: {
               foundedList = SearchManager.searchForName(allInstrumentsList, "Guitar");
               printList(foundedList);
               askToSort(foundedList);
                return;
            }
            case 2: {
                foundedList = SearchManager.searchForName(allInstrumentsList, "Piano");
                printList(foundedList);
                askToSort(foundedList);
                return;
            }
            case 3: {
                foundedList = SearchManager.searchForName(allInstrumentsList, "Drum");
                printList(foundedList);
                askToSort(foundedList);
                return;
            }
            case 4: {
                return;
            }
            default: {
                System.out.println("There is no such choice!");
                break;
            }
        }
    }

    static public void askToSort(List<Instrument> instruments) {
        while (true){
            System.out.println("Do you whant to sort?\n1 - By name\n2 - By prize\n" +
                    "3 - No, return");
            int choice = ScannerManager.readIntFromConsole();
            List<Instrument> sortedList;
            switch (choice) {
                case 1: {
                    SortManager sortManager = new SortManager();
                    sortedList = sortManager.sortInstrumentsByName(instruments);
                    howToSort(sortedList);
                    printList(sortedList);
                    return;
                }
                case 2: {
                    SortManager sortManager = new SortManager();
                    sortedList = sortManager.sortInstrumentsByPrize(instruments);
                    howToSort(sortedList);
                    printList(sortedList);
                    return;
                }
                case 3: {
                    return;
                }
                default: {
                    System.out.println("There is no such choice!");
                }
            }
        }
    }

    static public void howToSort(List<Instrument> instruments) {
        while(true){
            System.out.println("How to sort?\n1 - Ascending\n2 - Descending\n");
            int choice = ScannerManager.readIntFromConsole();
                switch (choice) {
                    case 1: {
                        return;
                    }
                    case 2: {
                        Collections.reverse(instruments);
                        return;
                    }
                    default: {
                        System.out.println("There is no such choice!");
                    }
                }
        }
    }

    static public void printList (List < Instrument > instruments) {
        for (Instrument instrument : instruments) {
            instrument.printInstrument();
        }
        System.out.println("\n");
    }
}