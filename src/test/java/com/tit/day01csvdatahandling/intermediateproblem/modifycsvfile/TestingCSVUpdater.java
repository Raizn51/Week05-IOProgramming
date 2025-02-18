package com.tit.day01csvdatahandling.intermediateproblem.modifycsvfile;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Creating a class TestingCSVUpdater to test the CSVUpdater class
class TestingCSVUpdater {

    // Test method for updating and saving employee details in a CSV file
    @Test
    void testUpdateCSV() throws IOException {
        // Create a temporary CSV file for testing
        String inputFilePath = "test_employees.csv";
        String outputFilePath = "test_updated_employees.csv";
        try (FileWriter writer = new FileWriter(inputFilePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("1,John Doe,Engineering,75000\n");
            writer.append("2,Jane Smith,Marketing,70000\n");
            writer.append("3,Michael Brown,Sales,68000\n");
            writer.append("4,Emily Davis,HR,72000\n");
            writer.append("5,David Wilson,Finance,76000\n");
            writer.append("6,Chris Johnson,IT,80000\n");
            writer.append("7,Alice Walker,IT,85000\n");
        }

        // Create a CSVUpdater object
        CSVUpdater updater = new CSVUpdater();
        // Call the method to update the CSV file
        updater.updateCSV(inputFilePath, outputFilePath);

        // Verify that the output file has been created
        File file = new File(outputFilePath);
        assertTrue(file.exists());

        // Verify the content of the updated file
        try (BufferedReader br = new BufferedReader(new FileReader(outputFilePath))) {
            // Read header
            String header = br.readLine();
            String expectedHeader = "ID,Name,Department,Salary";
            assertEquals(expectedHeader, header);

            // Read and assert each record
            String[] expectedRecords = {
                    "1,John Doe,Engineering,75000",
                    "2,Jane Smith,Marketing,70000",
                    "3,Michael Brown,Sales,68000",
                    "4,Emily Davis,HR,72000",
                    "5,David Wilson,Finance,76000",
                    "6,Chris Johnson,IT,88000.00",
                    "7,Alice Walker,IT,93500.00"
            };
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                assertEquals(expectedRecords[index], line);
                index++;
            }
        }

        // Clean up the test files
        new File(inputFilePath).delete();
        new File(outputFilePath).delete();
    }
}
