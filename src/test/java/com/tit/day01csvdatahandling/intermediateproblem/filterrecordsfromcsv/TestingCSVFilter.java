package com.tit.day01csvdatahandling.intermediateproblem.filterrecordsfromcsv;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Creating a class TestingCSVFilter to test the CSVFilter class
class TestingCSVFilter {

    // Test method for filtering and printing CSV data
    @Test
    void testFilterCSV() throws IOException {
        // Create a temporary CSV file for testing
        String filePath = "test_students.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Age,Marks\n");
            writer.append("1,John Doe,20,85\n");
            writer.append("2,Jane Smith,22,90\n");
            writer.append("3,Michael Brown,19,78\n");
            writer.append("4,Emily Davis,21,88\n");
        }

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a CSVFilter object
        CSVFilter filter = new CSVFilter();
        // Call the method to filter and print CSV data
        filter.filterCSV(filePath);

        // Expected output
        String expectedOutput = "ID,Name,Age,Marks\r\n" +
                "ID: 1, Name: John Doe, Age: 20, Marks: 85\r\n" +
                "ID: 2, Name: Jane Smith, Age: 22, Marks: 90\r\n" +
                "ID: 4, Name: Emily Davis, Age: 21, Marks: 88\r\n";

        // Asserting the output
        assertEquals(expectedOutput, outContent.toString());

        // Clean up the test file
        new File(filePath).delete();
    }
}
