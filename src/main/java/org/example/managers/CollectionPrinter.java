package org.example.managers;

import org.example.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class CollectionPrinter {
    private final CollectionManager manager;
    public CollectionPrinter(){
        manager = new CollectionManager();
    }
    public void printAllEmployees(List<Employee> employeeList){
        for (Employee employee: employeeList) {
            System.out.println(employee);
        }
    }
    public void printMapWithHireDateKeySortByPosition(List<Employee> employeeList){
        Map<LocalDate, List<Employee>> resultMap = manager.createMapWithDateKeySortByPosition(employeeList);
        printMap(resultMap);
    }
    public void printMapWithoutThoseWhoveBeenHired10YearsAgo(List<Employee> employeeList){
        Map<LocalDate, List<Employee>> resultMap = manager.createMapWithDateKeySortByPosition(employeeList);
        manager.deleteThoseWhoveBeenHired10YearsAgo(resultMap);
        System.out.println("Map without people who have been hired more than 10 years ago\n");
        printMap(resultMap);
    }

    public void printFrequencyTableOfPositions(List<Employee> employeeList)
    {
        Map<String, Integer> frequencyTable = manager.createFrequencyTable(employeeList);
        for (Map.Entry<String, Integer> entry : frequencyTable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\n");
    }

    public void printMap(Map<LocalDate, List<Employee>> map){
        for (Map.Entry<LocalDate, List<Employee>> entry: map.entrySet()) {
            System.out.println("Hire date: " + entry.getKey());
            System.out.println("Last names sort by positions:");
            for (Employee employee : entry.getValue()) {
                System.out.println(employee.getLastName() + " - " + employee.getPosition());
            }
            System.out.println();
        }
    }
}
