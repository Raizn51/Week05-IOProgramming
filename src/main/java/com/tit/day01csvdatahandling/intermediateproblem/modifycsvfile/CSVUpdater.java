package com.tit.day01csvdatahandling.intermediateproblem.modifycsvfile;

import java.io.*;
import java.util.*;

// Creating a class CSVUpdater to read, modify, and save CSV data
public class CSVUpdater {

    // Method to read, modify, and save CSV data
    public void updateCSV(String inputFilePath, String outputFilePath) {
        String line;
        String csvSplitBy = ",";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            // Read the header line
            String header = br.readLine();
            records.add(header.split(csvSplitBy));

            // Read and modify each record
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] employee = line.split(csvSplitBy);
                String department = employee[2];
                double salary = Double.parseDouble(employee[3]);

                // Increase salary by 10% for employees in the IT department
                if (department.equalsIgnoreCase("IT")) {
                    salary *= 1.10;
                    employee[3] = String.format("%.2f", salary);
                }

                records.add(employee);
            }

            // Write the updated records to the new CSV file
            try (FileWriter writer = new FileWriter(outputFilePath)) {
                for (String[] record : records) {
                    writer.append(String.join(csvSplitBy, record)).append("\n");
                }
                System.out.println("CSV file updated successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
