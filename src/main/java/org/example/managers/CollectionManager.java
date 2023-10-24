package org.example.managers;


import org.example.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class CollectionManager {
    public Map<LocalDate, List<Employee>> createMapWithDateKeySortByPosition(List<Employee> employeeList) {
        Map<LocalDate, List<Employee>> employeeMap = new HashMap<>();
        for (Employee employee : employeeList) {
            LocalDate hireDate = employee.getHireDate();
            if (!employeeMap.containsKey(hireDate)) {
                employeeMap.put(hireDate, new ArrayList<>());
            }
            employeeMap.get(hireDate).add(employee);
        }
        for (Map.Entry<LocalDate, List<Employee>> entry : employeeMap.entrySet()) {
            List<Employee> employees = entry.getValue();
            employees.sort(Comparator.comparing(Employee::getPosition));
        }
        return employeeMap;
    }
    public void deleteThoseWhoveBeenHired10YearsAgo(Map<LocalDate, List<Employee>> map){
        LocalDate currentDate = LocalDate.now();
        List<LocalDate> keysToRemove = new ArrayList<>();
        for (Map.Entry<LocalDate, List<Employee>> entry : map.entrySet()) {
            Period period = Period.between(entry.getKey(), currentDate);
            int years = period.getYears();
            if(years >= 10){
                keysToRemove.add(entry.getKey());
            }
        }
        for (LocalDate key : keysToRemove) {
            map.remove(key);
        }
    }
    public Map<String, Integer> createFrequencyTable(List<Employee> employeeList) {
        Map<String, Integer> frequencyTable = new HashMap<>();
        for (Employee employee : employeeList) {
            String position = employee.getPosition();
            if (frequencyTable.containsKey(position)) {
                int count = frequencyTable.get(position);
                frequencyTable.put(position, count + 1);
            } else {
                frequencyTable.put(position, 1);
            }
        }
        return frequencyTable;
    }

    public static List<Employee> mergeTwoLists(List<Employee> firstList,List<Employee> secondList){
        Set<Employee> set = new LinkedHashSet<>(firstList);

        set.addAll(secondList);
        return new ArrayList<>(set);
        //return new List<Employee>(set);
    }
}
