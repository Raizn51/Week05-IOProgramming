package com.tit.day01csvdatahandling.intermediateproblem.searchforrecordincsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Creating a class CSVSearcher to read and search records in a CSV file
public class CSVSearcher {

    // Method to search for an employee by name and print their department and salary
    public void searchEmployee(String filePath, String employeeName) {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line
            String header = br.readLine();

            // Read and search each record
            boolean found = false;
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] employee = line.split(csvSplitBy);
                String name = employee[1];
                if (name.equalsIgnoreCase(employeeName)) {
                    System.out.printf("Name: %s, Department: %s, Salary: %s%n", employee[1], employee[2], employee[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
