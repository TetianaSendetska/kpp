package org.example.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
    static public <T> List<T> readInstrumentsFromFile(String filePath, Class<T> instrumentClass, Class... constructorParamTypes) {
        List<T> instrumentList = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == constructorParamTypes.length) {
                    Object[] constructorArgs = new Object[constructorParamTypes.length];
                    for (int i = 0; i < constructorParamTypes.length; i++) {
                        if (constructorParamTypes[i] == String.class) {
                            constructorArgs[i] = parts[i];
                        } else if (constructorParamTypes[i] == double.class) {
                            constructorArgs[i] = Double.parseDouble(parts[i]);
                        } else if (constructorParamTypes[i] == int.class) {
                            constructorArgs[i] = Integer.parseInt(parts[i]);
                        }
                    }

                    T instrument = instrumentClass.getConstructor(constructorParamTypes)
                            .newInstance(constructorArgs);

                    instrumentList.add(instrument);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instrumentList;
    }

}
