package org.example;

import java.time.LocalDate;
import java.util.*;

public class Employee {
    private String lastName;
    private String position;
    private LocalDate hireDate;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPosition() {
        return position;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }

    public Employee(){
        this.lastName = null;
        this.position = null;
        this.hireDate = null;
    }
    public Employee(String lastName, String position, LocalDate hireDate){
        this.lastName = lastName;
        this.position = position;
        this.hireDate = hireDate;
    }

    public String toString() {
        return "Last name: "+lastName+ ", Position: "+position+", Hire date: "+hireDate;
    }

    public int hashCode() {
        return this.lastName.hashCode();
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        return Objects.equals(lastName, otherEmployee.lastName);
    }
}
