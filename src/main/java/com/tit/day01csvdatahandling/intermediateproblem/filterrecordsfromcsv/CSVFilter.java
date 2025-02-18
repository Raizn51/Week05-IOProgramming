package com.tit.day01csvdatahandling.intermediateproblem.filterrecordsfromcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Creating a class CSVFilter to read and filter CSV data
public class CSVFilter {

    // Method to read and filter CSV data
    public void filterCSV(String filePath) {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line
            String header = br.readLine();
            // Print the header
            System.out.println(header);

            // Read and filter each record
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] student = line.split(csvSplitBy);
                int marks = Integer.parseInt(student[3]);
                // Print only the qualifying records
                if (marks > 80) {
                    System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n", student[0], student[1], student[2], student[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
