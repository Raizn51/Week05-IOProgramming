package com.tit.day01csvdatahandling.advanceproblem.convertcsvdataintojavaobjects;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Creating a class TestingCSVToJavaObjectsConverter to verify the functionality of CSVToJavaObjectsConverter class
class TestingCSVToJavaObjectsConverter {

    // Test method for reading and converting CSV data to list of Student objects
    @Test
    void testReadCSVAndConvert() throws IOException {
        // Create a temporary CSV file for testing
        String filePath = "test_students.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Age,Marks\n");
            writer.append("1,John Doe,20,85\n");
            writer.append("2,Jane Smith,22,90\n");
            writer.append("3,Michael Brown,19,78\n");
            writer.append("4,Emily Davis,21,88\n");
        }

        // Create a CSVToJavaObjectsConverter object
        CSVToJavaObjectsConverter converter = new CSVToJavaObjectsConverter();
        // Call the method to read and convert CSV data to list of Student objects
        List<Student> students = converter.readCSVAndConvert(filePath);

        // Expected list of Student objects
        List<Student> expectedStudents = List.of(
                new Student(1, "John Doe", 20, 85),
                new Student(2, "Jane Smith", 22, 90),
                new Student(3, "Michael Brown", 19, 78),
                new Student(4, "Emily Davis", 21, 88)
        );

        // Asserting the size of the list
        assertEquals(expectedStudents.size(), students.size());

        // Asserting each Student object
        for (int i = 0; i < expectedStudents.size(); i++) {
            assertEquals(expectedStudents.get(i).toString(), students.get(i).toString());
        }

        // Clean up the test file
        new File(filePath).delete();
    }
}
