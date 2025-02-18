package com.tit.day01csvdatahandling.basicproblem.readcsvfileandprintdata;

import java.io.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


// Creating a class TestingCSVReader to test the CSVReader class
class TestingCSVReader {

    // Test method for reading and printing CSV data
    @Test
    void testReadCSV() {
        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a CSVReader object
        CSVReader reader = new CSVReader();
        // Specify the file path
        String filePath = "src/main/resources/Students.csv";
        // Call the method to read and print CSV data
        reader.readCSV(filePath);

        // Expected output
        String expectedOutput = "ID,Name,Age,Marks\r\n" +
                "ID: 1, Name: John Doe, Age: 20, Marks: 85\r\n" +
                "ID: 2, Name: Jane Smith, Age: 22, Marks: 90\r\n" +
                "ID: 3, Name: Michael Brown, Age: 19, Marks: 78\r\n" +
                "ID: 4, Name: Emily Davis, Age: 21, Marks: 88\r\n";

        // Asserting the output
        assertEquals(expectedOutput, outContent.toString());
    }
}
