package com.tit.day01csvdatahandling.intermediateproblem.sortcsvRecordsbycolumn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Intermediate Problems
 * 7️⃣ Sort CSV Records by a Column
 * ✅ Problem Statement:
 * Read a CSV file and sort the records by Salary in descending order.
 * Print the top 5 highest-paid employees.
 */

public class Main {
    public static void main(String[] args) {
        // Create a CSVSorter object
        CSVSorter sorter = new CSVSorter();
        // Specify the file path
        String filePath = "src/main/resources/Employees.csv";
        // Call the method to sort and print CSV data
        sorter.sortCSV(filePath);
    }
}
