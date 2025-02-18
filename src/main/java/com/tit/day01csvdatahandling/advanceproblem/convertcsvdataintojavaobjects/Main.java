package com.tit.day01csvdatahandling.advanceproblem.convertcsvdataintojavaobjects;

/*
 * Intermediate Problems
 * 9️⃣ Convert CSV Data into Java Objects
 * ✅ Problem Statement:
 * Read a CSV file and convert each row into a Student Java object.
 * Store the objects in a List<Student> and print them.
 */

import java.util.List;

// Creating a class Main to execute the main method
public class Main {
    public static void main(String[] args) {
        // Create a CSVToJavaObjectsConverter object
        CSVToJavaObjectsConverter converter = new CSVToJavaObjectsConverter();
        // Specify the file path
        String filePath = "src/main/resources/Students.csv";
        // Call the method to read and convert CSV data to list of Student objects
        List<Student> students = converter.readCSVAndConvert(filePath);
        // Print the list of Student objects
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
