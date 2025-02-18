package com.tit.day01csvdatahandling.advanceproblem.validatecsvdatabeforeprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/*
 * Intermediate Problems
 * 8️⃣ Validate CSV Data Before Processing
 * ✅ Problem Statement:
 * Ensure that the "Email" column follows a valid email format using regex.
 * Ensure that "Phone Numbers" contain exactly 10 digits.
 * Print any invalid rows with an error message.
 */

public class Main {
    public static void main(String[] args) {
        // Create a CSVValidator object
        CSVValidator validator = new CSVValidator();
        // Specify the file path
        String filePath = "src/main/resources/Contacts.csv";
        // Call the method to validate and print CSV data
        validator.validateCSV(filePath);
    }
}
