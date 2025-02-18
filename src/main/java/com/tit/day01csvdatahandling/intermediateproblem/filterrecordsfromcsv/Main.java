package com.tit.day01csvdatahandling.intermediateproblem.filterrecordsfromcsv;

/*
 * Intermediate Problems
 * 4️⃣ Filter Records from CSV
 * ✅ Problem Statement:
 * Read a CSV file and filter students who have scored more than 80 marks.
 * Print only the qualifying records.
 */

public class Main {
    public static void main(String[] args) {
        // Create a CSVFilter object
        CSVFilter filter = new CSVFilter();
        // Specify the file path
        String filePath = "src/main/resources/Students.csv";
        // Call the method to filter and print CSV data
        filter.filterCSV(filePath);
    }
}
