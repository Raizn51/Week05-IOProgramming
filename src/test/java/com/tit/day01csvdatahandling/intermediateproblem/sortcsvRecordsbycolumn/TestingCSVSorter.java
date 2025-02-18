package com.tit.day01csvdatahandling.intermediateproblem.sortcsvRecordsbycolumn;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Creating a class TestingCSVSorter to test the CSVSorter class
class TestingCSVSorter {

    // Test method for sorting and printing top 5 highest-paid employees in a CSV file
    @Test
    void testSortCSV() throws IOException {
        // Create a temporary CSV file for testing
        String filePath = "test_employees.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("1,John Doe,Engineering,75000\n");
            writer.append("2,Jane Smith,Marketing,70000\n");
            writer.append("3,Michael Brown,Sales,68000\n");
            writer.append("4,Emily Davis,HR,72000\n");
            writer.append("5,David Wilson,Finance,76000\n");
            writer.append("6,Chris Johnson,IT,80000\n");
            writer.append("7,Alice Walker,IT,85000\n");
        }

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a CSVSorter object
        CSVSorter sorter = new CSVSorter();
        // Call the method to sort and print CSV data
        sorter.sortCSV(filePath);

        // Expected output
        String expectedOutput = "ID,Name,Department,Salary\r\n" +
                "ID: 7, Name: Alice Walker, Department: IT, Salary: 85000\r\n" +
                "ID: 6, Name: Chris Johnson, Department: IT, Salary: 80000\r\n" +
                "ID: 5, Name: David Wilson, Department: Finance, Salary: 76000\r\n" +
                "ID: 1, Name: John Doe, Department: Engineering, Salary: 75000\r\n" +
                "ID: 4, Name: Emily Davis, Department: HR, Salary: 72000\r\n";

        // Asserting the output
        assertEquals(expectedOutput, outContent.toString());

        // Clean up the test file
        new File(filePath).delete();
    }
}

