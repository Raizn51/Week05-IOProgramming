package com.tit.day01csvdatahandling.basicproblem.readandcountrowsincsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Creating a class CSVRowCounter to read and count rows in a CSV file
public class CSVRowCounter {

    // Method to read and count rows in a CSV file
    public int countRows(String filePath) {
        int rowCount = 0;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line and discard it
            br.readLine();

            // Count each record
            while ((line = br.readLine()) != null) {
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rowCount;
    }
}
