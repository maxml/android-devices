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
    private static final String foundRequest = "Samsung";


    private static final String MAPPINGS_FILE_NAME = "./device_mappings.xml";
    private static final String EXCEL_FILE_NAME = "./Build.Model.xls";

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
            try {
                Files.deleteIfExists(mappingPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    private static void findDevices(ArrayList<Device> devices, String foundRequest) {
        System.out.println(">> findDevices, devices[" + devices + "]");
        // TODO
        System.out.println("<< findDevices");
    }

    private static ArrayList<Device> readDevices(Path mappingPath, Path excelPath) throws IOException, SAXException, InvalidFormatException {
        ArrayList<Device> res = new ArrayList<>();

        final XLSReader xlsReader = ReaderBuilder.buildFromXML(Files.newInputStream(mappingPath));
        Map<String, Object> beans = new HashMap<>();
        beans.put("devices", res);

        InputStream inputStream = new BufferedInputStream(Files.newInputStream(excelPath));
        xlsReader.read(inputStream, beans);
        return res;
    }

    private static class Device {
        private String build;
        private String model;
        private String manufacturer;
        private String comment;

        public Device(String build, String model, String manufacturer, String comment) {
            this.build = build;
            this.model = model;
            this.manufacturer = manufacturer;
            this.comment = comment;
        }

        public String getBuild() {
            return build;
        }

        public void setBuild(String build) {
            this.build = build;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "build='" + build + '\'' +
                    ", model='" + model + '\'' +
                    ", manufacturer='" + manufacturer + '\'' +
                    ", comment='" + comment + '\'' +
                    '}';
        }
    }

    private static final String MAPPING_SOURCE = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
            "    <workbook>\n" +
            "       <worksheet name=\"Snapdragon\">\n" +
            "      <section startRow=\"0\" endRow=\"0\" />\n" +
            "            <loop startRow=\"1\" endRow=\"1\" items=\"devices\" var=\"device\" varType=\"com.vidyo.parser.ModelParser$Device\">\n" +
            "               <section startRow=\"1\" endRow=\"1\">\n" +
            "                   <mapping row=\"1\" col=\"0\">device.build</mapping>\n" +
            "                   <mapping row=\"1\" col=\"1\">device.model</mapping>\n" +
            "                   <mapping row=\"1\" col=\"2\">device.manufacturer</mapping>\n" +
            "                   <mapping row=\"1\" col=\"3\">device.comment</mapping>\n" +
            "               </section>\n" +
            "               <loopbreakcondition>\n" +
            "                   <rowcheck offset=\"0\">\n" +
            "             <cellcheck offset=\"0\" />\n" +
            "           </rowcheck>\n" +
            "               </loopbreakcondition>\n" +
            "           </loop>\n" +
            "       </worksheet>\n" +
            "    </workbook>";
}
