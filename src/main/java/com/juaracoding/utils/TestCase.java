package com.juaracoding.utils;

public enum TestCase {

    T1("User Login Valid"),
    T2("User move to division menu"),
    T3("Batal tambah divisi baru");

    private String testCaseName;

    TestCase(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
