package com.vidyo.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * You can execute only this file from command line (Windows)
 * http://www.skylit.com/javamethods/faqs/javaindos.html
 */
public class DeviceNameParser {

    private static String FILE_NAME = "input_old_devices.txt";

    public static void main(String[] Args) {
        int rowNumbwer = 1;
        printRow(rowNumbwer);
    }

    private static void printRow(int rowNumbwer) {
        System.out.println(">> printRow, index =  " + rowNumbwer);

        try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {
            stream.forEach(line -> System.out.println(getModel(getOnlyRow(line, rowNumbwer))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getModel(String onlyRow) {
        String[] temp = onlyRow.trim().split(" ");
        return temp.length >= 1 ? onlyRow.replace(temp[0], "").trim() : "";
    }

    private static String getManufacturer(String onlyRow) {
        // System.out.println(">> getManufacturer, row[" + onlyRow + "]");
        String[] temp = onlyRow.trim().split(" ");
        return temp.length >= 1 ? temp[0] : "";
    }

    private static String getOnlyRow(String line, int rowNumber) {
        String[] rows = line.split("=");
        return rows.length < rowNumber ? rows[rowNumber] : "";
    }
}
