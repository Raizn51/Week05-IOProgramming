package com.tit.day01csvdatahandling.basicproblem.writedatatocsvfile;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Creating a class TestingEmployeeWriter to test the EmployeeWriter class
class TestingEmployeeWriter {

    // Test method for writing employee details to a CSV file
    @Test
    void testWriteCSV() {
        // Create an EmployeeWriter object
        EmployeeWriter writer = new EmployeeWriter();
        // Specify the file path
        String filePath = "src/main/resources/Employees.csv";
        // Call the method to write employee details to the CSV file
        writer.writeCSV(filePath);

        // Verify that the file has been created
        File file = new File(filePath);
        assertTrue(file.exists());

        // Verify the content of the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header
            String header = br.readLine();
            // Expected header
            String expectedHeader = "ID,Name,Department,Salary";
            // Asserting the header
            assertEquals(expectedHeader, header);

            // Read and assert each record
            String[] expectedRecords = {
                    "1,John Doe,Engineering,75000",
                    "2,Jane Smith,Marketing,70000",
                    "3,Michael Brown,Sales,68000",
                    "4,Emily Davis,HR,72000",
                    "5,David Wilson,Finance,76000"
            };
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                assertEquals(expectedRecords[index], line);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Clean up the test file
        file.delete();
    }
}
