package com.tit.day01csvdatahandling.basicproblem.readcsvfileandprintdata;

import java.io.*;

// Creating a class CSVReader to read and print CSV data
public class CSVReader {

    // Method to read and print CSV data
    public void readCSV(String filePath) {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line
            String header = br.readLine();
            // Print the header
            System.out.println(header);

            // Read and print each record
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] student = line.split(csvSplitBy);
                // Print each record in a structured format
                System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n", student[0], student[1], student[2], student[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

