package com.juaracoding.utils;

public enum TestCase {

    T1("Input URL benar"),
    T2("Input valid Username dan Password"),
    T3("Search Jabatan"),
    T4("Reset Search Jabatan"),
    T5("Tambah Jabatan"),
    T6("Negative Tambah Jabatan"),
    T7("Edit Jabatan"),
    T8("Delete Jabatan"),;

    private String testCaseName;

    TestCase(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
