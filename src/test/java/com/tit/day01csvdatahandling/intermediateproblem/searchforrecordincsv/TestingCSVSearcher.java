package com.tit.day01csvdatahandling.intermediateproblem.searchforrecordincsv;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Creating a class TestingCSVSearcher to test the CSVSearcher class
class TestingCSVSearcher {

    // Test method for searching and printing employee details in a CSV file
    @Test
    void testSearchEmployee() throws IOException {
        // Create a temporary CSV file for testing
        String filePath = "test_employees.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("1,John Doe,Engineering,75000\n");
            writer.append("2,Jane Smith,Marketing,70000\n");
            writer.append("3,Michael Brown,Sales,68000\n");
            writer.append("4,Emily Davis,HR,72000\n");
            writer.append("5,David Wilson,Finance,76000\n");
        }

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a CSVSearcher object
        CSVSearcher searcher = new CSVSearcher();
        // Specify the employee name to search for
        String employeeName = "Jane Smith";
        // Call the method to search for the employee and print their department and salary
        searcher.searchEmployee(filePath, employeeName);

        // Expected output
        String expectedOutput = "Name: Jane Smith, Department: Marketing, Salary: 70000\r\n";

        // Asserting the output
        assertEquals(expectedOutput, outContent.toString());

        // Clean up the test file
        new File(filePath).delete();
    }
}
