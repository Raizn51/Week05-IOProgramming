package com.tit.day01csvdatahandling.advanceproblem.convertcsvdataintojavaobjects;

import java.io.*;
import java.util.*;

// Creating a class CSVToJavaObjectsConverter to read, convert, and store CSV data in a list of Student objects
public class CSVToJavaObjectsConverter {

    // Method to read CSV data and convert to list of Student objects
    public List<Student> readCSVAndConvert(String filePath) {
        List<Student> students = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line
            br.readLine();

            // Read and convert each record
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] studentData = line.split(csvSplitBy);
                int id = Integer.parseInt(studentData[0]);
                String name = studentData[1];
                int age = Integer.parseInt(studentData[2]);
                int marks = Integer.parseInt(studentData[3]);

                // Create a Student object and add it to the list
                Student student = new Student(id, name, age, marks);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
