package com.juaracoding.utils;

public enum TestCase {

    T1("Input URL benar"),
    T2("Input valid Username dan Password");

    private String testCaseName;

    TestCase(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
