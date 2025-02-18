package com.tit.day01csvdatahandling.advanceproblem.validatecsvdatabeforeprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

// Creating a class CSVValidator to read, validate, and print CSV data
public class CSVValidator {

    // Method to read, validate, and print CSV data
    public void validateCSV(String filePath) {
        String line;
        String csvSplitBy = ",";
        // Define the regex pattern for a valid email
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        // Define the regex pattern for a valid phone number
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line
            String header = br.readLine();
            // Print the header
            System.out.println(header);

            // Read and validate each record
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] contact = line.split(csvSplitBy);
                String email = contact[2];
                String phoneNumber = contact[3];
                boolean isValid = true;
                StringBuilder errorMessage = new StringBuilder();

                // Validate the email
                if (!emailPattern.matcher(email).matches()) {
                    isValid = false;
                    errorMessage.append("Invalid Email ");
                }

                // Validate the phone number
                if (!phonePattern.matcher(phoneNumber).matches()) {
                    isValid = false;
                    errorMessage.append("Invalid Phone Number ");
                }

                // Print the invalid row with an error message
                if (isValid) {
                    System.out.printf("ID: %s, Name: %s, Email: %s, Phone Number: %s%n", contact[0], contact[1], contact[2], contact[3]);
                } else {
                    System.err.printf("Error: %s - ID: %s, Name: %s, Email: %s, Phone Number: %s%n", errorMessage.toString().trim(), contact[0], contact[1], contact[2], contact[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
