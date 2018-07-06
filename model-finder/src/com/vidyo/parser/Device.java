package com.vidyo.parser;

public class Device {
    private String build;
    private String model;
    private String manufacturer;
    private String comment;

    public Device() {
    }

    public Device(String build, String model, String manufacturer, String comment) {
        this.build = build;
        this.model = model;
        this.manufacturer = manufacturer;
        this.comment = comment;
    }

    public boolean findEntry(String entry) {
        return entry != null && (isNotContainsInsideEachOther(entry, build)
                || isNotContainsInsideEachOther(entry, manufacturer) || isNotContainsInsideEachOther(entry, model));
    }

    private boolean isNotContainsInsideEachOther(String s1, String s2) {
        return s1 != null && s2 != null && !s1.isEmpty() && !s2.isEmpty() &&
                (s1.toLowerCase().trim().contains(s2.toLowerCase().trim())
                        || s2.toLowerCase().trim().contains(s1.toLowerCase().trim()));
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

    public String toSimpleString() {
        return "\"" + changeNullString(build) + " " + changeNullString(model) + " " + changeNullString(manufacturer) + "\",";
    }

    private String changeNullString(String input) {
        return input == null ? "" : input;
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
