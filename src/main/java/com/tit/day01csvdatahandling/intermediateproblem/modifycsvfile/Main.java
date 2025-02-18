package com.tit.day01csvdatahandling.intermediateproblem.modifycsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Intermediate Problems
 * 6️⃣ Modify a CSV File (Update a Value)
 * ✅ Problem Statement:
 * Read a CSV file and increase the salary of employees from the "IT" department by 10%.
 * Save the updated records back to a new CSV file.
 */

public class Main {
    public static void main(String[] args) {
        // Create a CSVUpdater object
        CSVUpdater updater = new CSVUpdater();
        // Specify the input file path
        String inputFilePath = "src/main/resources/Employees.csv";
        // Specify the output file path
        String outputFilePath = "src/main/resources/UpdatedEmployees.csv";
        // Call the method to update the CSV file
        updater.updateCSV(inputFilePath, outputFilePath);
    }
}
