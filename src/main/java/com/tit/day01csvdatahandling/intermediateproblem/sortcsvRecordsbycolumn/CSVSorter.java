package com.tit.day01csvdatahandling.intermediateproblem.sortcsvRecordsbycolumn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Creating a class CSVSorter to read, sort, and print CSV data
public class CSVSorter {

    // Method to read, sort, and print CSV data
    public void sortCSV(String filePath) {
        String line;
        String csvSplitBy = ",";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line
            String header = br.readLine();
            // Read and store each record
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(csvSplitBy);
                records.add(employee);
            }

            // Sort the records by Salary in descending order
            Collections.sort(records, new Comparator<String[]>() {
                public int compare(String[] a, String[] b) {
                    return Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3]));
                }
            });

            // Print the top 5 highest-paid employees
            System.out.println(header);
            for (int i = 0; i < 5 && i < records.size(); i++) {
                String[] employee = records.get(i);
                System.out.printf("ID: %s, Name: %s, Department: %s, Salary: %s%n", employee[0], employee[1], employee[2], employee[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
