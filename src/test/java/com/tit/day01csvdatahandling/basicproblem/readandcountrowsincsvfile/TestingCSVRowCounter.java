package com.tit.day01csvdatahandling.basicproblem.readandcountrowsincsvfile;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Creating a class TestingCSVRowCounter to test the CSVRowCounter class

class TestingCSVRowCounter {

    // Test method for counting rows in a CSV file
    @Test
    void testCountRows() throws IOException {
        // Create a temporary CSV file for testing
        String filePath = "test_students.csv";
        try (FileWriter writer = new FileWriter(filePath))
        {
            writer.append("ID,Name,Age,Marks\n");
            writer.append("1,John Doe,20,85\n");
            writer.append("2,Jane Smith,22,90\n");
            writer.append("3,Michael Brown,19,78\n");
            writer.append("4,Emily Davis,21,88\n");
        }

        // Create a CSVRowCounter object
        CSVRowCounter counter = new CSVRowCounter();
        // Call the method to count rows in the CSV file
        int rowCount = counter.countRows(filePath);

        // Expected row count (excluding header)
        int expectedRowCount = 4;

        // Asserting the row count
        assertEquals(expectedRowCount, rowCount);

        // Clean up the test file
        new File(filePath).delete();
    }
}

