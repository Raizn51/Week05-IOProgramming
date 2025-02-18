package com.tit.day01csvdatahandling.basicproblem.readandcountrowsincsvfile;



/*
 * Basic Problems
 * 3️⃣ Read and Count Rows in a CSV File
 * ✅ Problem Statement:
 * Read a CSV file and count the number of records (excluding the header row).
 */

public class Main {
    public static void main(String[] args) {
        // Create a CSVRowCounter object
        CSVRowCounter counter = new CSVRowCounter();
        // Specify the file path
        String filePath = "src/main/resources/Students.csv";
        // Call the method to count rows in the CSV file
        int rowCount = counter.countRows(filePath);
        // Print the row count
        System.out.println("Number of records (excluding header): " + rowCount);
    }
}
