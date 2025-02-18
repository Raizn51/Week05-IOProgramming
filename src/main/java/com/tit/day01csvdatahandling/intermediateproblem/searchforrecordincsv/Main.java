package com.tit.day01csvdatahandling.intermediateproblem.searchforrecordincsv;

/*
 * Intermediate Problems
 * 5️⃣ Search for a Record in CSV
 * ✅ Problem Statement:
 * Read an employees.csv file and search for an employee by name.
 * Print their department and salary.
 */

public class Main {
    public static void main(String[] args) {
        // Create a CSVSearcher object
        CSVSearcher searcher = new CSVSearcher();
        // Specify the file path
        String filePath = "src/main/resources/Employees.csv";
        // Specify the employee name to search for
        String employeeName = "Jane Smith";
        // Call the method to search for the employee and print their department and salary
        searcher.searchEmployee(filePath, employeeName);
    }
}

