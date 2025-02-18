package com.tit.day01csvdatahandling.basicproblem.readcsvfileandprintdata;

/*
 * Basic Problems
 * 1️⃣ Read a CSV File and Print Data
 * ✅ Problem Statement:
 * Read a CSV file containing student details (ID, Name, Age, Marks).
 * Print each record in a structured format.
 */

public class Main {
    public static void main(String[] args) {
        // Create a CSVReader object
        CSVReader reader = new CSVReader();
        // Specify the file path
        String filePath = "src/main/resources/Students.csv";
        // Call the method to read and print CSV data
        reader.readCSV(filePath);
    }
}

