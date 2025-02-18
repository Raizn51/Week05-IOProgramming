package com.tit.day01csvdatahandling.basicproblem.writedatatocsvfile;

/*
 * Basic Problems
 * 2️⃣ Write Data to a CSV File
 * ✅ Problem Statement:
 * Create a CSV file with employee details (ID, Name, Department, Salary).
 * Write at least 5 records to the file.
 */

public class Main {
    public static void main(String[] args) {
        // Create an EmployeeWriter object
        EmployeeWriter writer = new EmployeeWriter();
        // Specify the file path
        String filePath = "src/main/resources/Employees.csv";
        // Call the method to write employee details to the CSV file
        writer.writeCSV(filePath);
    }
}
