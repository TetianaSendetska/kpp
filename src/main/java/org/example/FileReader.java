package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class FileReader {
    public static List<Employee> readEmployeesFromFile(String filePath)
    {
        List<Employee> employees = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if(data.length == 3){
                    String lastName = data[0].trim();
                    String position = data[1].trim();
                    LocalDate date = LocalDate.parse(data[2], formatter);
                    Employee employee = new Employee(lastName, position, date);
                    employees.add(employee);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}
