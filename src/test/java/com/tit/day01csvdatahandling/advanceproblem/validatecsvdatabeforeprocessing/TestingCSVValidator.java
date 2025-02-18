package com.tit.day01csvdatahandling.advanceproblem.validatecsvdatabeforeprocessing;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Creating a class TestingCSVValidator to test the CSVValidator class
class TestingCSVValidator {

    // Test method for validating and printing CSV data
    @Test
    void testValidateCSV() throws IOException {
        // Create a temporary CSV file for testing
        String filePath = "src/main/resources/TestContacts.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Email,Phone Number\n");
            writer.append("1,John Doe,john.doe@example.com,1234567890\n");
            writer.append("2,Jane Smith,invalid-email,123456789\n");
            writer.append("3,Michael Brown,michael.brown@example.com,0987654321\n");
            writer.append("4,Emily Davis,emily.davis@example,2345678901\n");
            writer.append("5,David Wilson,david.wilson@example.com,123456789012\n");
        }

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        // Create a CSVValidator object
        CSVValidator validator = new CSVValidator();
        // Call the method to validate and print CSV data
        validator.validateCSV(filePath);

        // Expected valid output
        String expectedValidOutput = "ID,Name,Email,Phone Number\r\n" +
                "ID: 1, Name: John Doe, Email: john.doe@example.com, Phone Number: 1234567890\r\n" +
                "ID: 3, Name: Michael Brown, Email: michael.brown@example.com, Phone Number: 0987654321\r\n";

        // Expected invalid output
        String expectedInvalidOutput = "Error: Invalid Email Invalid Phone Number - ID: 2, Name: Jane Smith, Email: invalid-email, Phone Number: 123456789\r\n" +
                "Error: Invalid Email - ID: 4, Name: Emily Davis, Email: emily.davis@example, Phone Number: 2345678901\r\n" +
                "Error: Invalid Phone Number - ID: 5, Name: David Wilson, Email: david.wilson@example.com, Phone Number: 123456789012\r\n";

        // Asserting the valid output
        assertEquals(expectedValidOutput, outContent.toString());

        // Asserting the invalid output
        assertEquals(expectedInvalidOutput, errContent.toString());

        // Clean up the test file
        new File(filePath).delete();
    }
}