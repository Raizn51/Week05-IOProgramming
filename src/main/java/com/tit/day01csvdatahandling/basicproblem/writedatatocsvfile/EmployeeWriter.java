package com.tit.day01csvdatahandling.basicproblem.writedatatocsvfile;

import java.io.FileWriter;
import java.io.IOException;

// Creating a class EmployeeWriter to write employee details to a CSV file
public class EmployeeWriter {

    // Method to write employee details to a CSV file
    public void writeCSV(String filePath) {
        // Employee data
        String[] employees = {
                "1,John Doe,Engineering,75000",
                "2,Jane Smith,Marketing,70000",
                "3,Michael Brown,Sales,68000",
                "4,Emily Davis,HR,72000",
                "5,David Wilson,Finance,76000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            // Write header
            writer.append("ID,Name,Department,Salary\n");

            // Write employee records
            for (String employee : employees) {
                writer.append(employee).append("\n");
            }

            System.out.println("CSV file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
