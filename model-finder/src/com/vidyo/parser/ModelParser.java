package com.vidyo.parser;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModelParser {

    /**
     * Write here what you want to find
     */
    private static final String foundRequest = "xiaomi, samsung,moto";

    private static final String EXCEL_FILE_NAME = "../Build.MODEL.xls";
    private static final String MAPPINGS_FILE_NAME = "./device_mappings.xml";
    private static final String MAPPINGS_DEVICES_NAME = "devices";

    public static void main(String[] Args) {
        System.out.println(">> main");

        Path mappingPath = Paths.get(MAPPINGS_FILE_NAME);
        Path excelPath = Paths.get(EXCEL_FILE_NAME);
        try {
            createMappingFile(mappingPath);

            ArrayList<Device> devices = readDevices(mappingPath, excelPath);
            findDevices(devices, foundRequest);

        } catch (IOException | SAXException | InvalidFormatException e) {
            e.printStackTrace();
        } finally {
            deleteMappingFile(mappingPath);
        }
    }

    private static void findDevices(ArrayList<Device> devices, String foundRequest) {
        System.out.println(">> findDevices, device size[" + devices.size() + "]");
        // System.out.println(">> findDevices, devices[" + devices + "]");

        String[] foundWords = foundRequest.split(",");
        for (String w : foundWords) {
            checkAcceptedDevice(devices, w);
        }

        System.out.println("<< findDevices");
    }

    private static void checkAcceptedDevice(ArrayList<Device> devices, String foundRequest) {
        for (Device d : devices) {
            if (d.findEntry(foundRequest)) {
                System.out.println(d.toSimpleString());
            }
        }
    }

    private static ArrayList<Device> readDevices(Path mappingPath, Path excelPath) throws IOException, SAXException, InvalidFormatException {
        ArrayList<Device> res = new ArrayList<>();

        final XLSReader xlsReader = ReaderBuilder.buildFromXML(Files.newInputStream(mappingPath));
        Map<String, Object> beans = new HashMap<>();
        beans.put(MAPPINGS_DEVICES_NAME, res);

        InputStream inputStream = new BufferedInputStream(Files.newInputStream(excelPath));
        xlsReader.read(inputStream, beans);
        return res;
    }

    private static void deleteMappingFile(Path mappingPath) {
        try {
            Files.deleteIfExists(mappingPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createMappingFile(Path mappingPath) throws IOException {
        Files.createFile(mappingPath);
        try (BufferedWriter writer = Files.newBufferedWriter(mappingPath, Charset.forName("UTF-8"))) {
            writer.write(MAPPING_SOURCE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static final String MAPPING_SOURCE = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
            "<workbook>\n" +
            "    <worksheet name=\"Snapdragon\">\n" +
            "        <loop startRow=\"0\" endRow=\"0\" items=\"" + MAPPINGS_DEVICES_NAME + "\" var=\"device\" varType=\"com.vidyo.parser.Device\">\n" +
            "            <section startRow=\"0\" endRow=\"0\">\n" +
            "                <mapping row=\"0\" col=\"0\">device.build</mapping>\n" +
            "                <mapping row=\"0\" col=\"1\">device.model</mapping>\n" +
            "                <mapping row=\"0\" col=\"2\">device.manufacturer</mapping>\n" +
            "                <mapping row=\"0\" col=\"3\">device.comment</mapping>\n" +
            "            </section>\n" +
            "            <loopbreakcondition>\n" +
            "                <rowcheck offset=\"0\">\n" +
            "                    <cellcheck offset=\"0\"/>\n" +
            "                    <cellcheck offset=\"1\"/>\n" +
            "                    <cellcheck offset=\"2\"/>\n" +
            "                    <cellcheck offset=\"3\"/>\n" +
            "                </rowcheck>\n" +
            "            </loopbreakcondition>\n" +
            "        </loop>\n" +
            "    </worksheet>\n" +
            "</workbook>";
}
