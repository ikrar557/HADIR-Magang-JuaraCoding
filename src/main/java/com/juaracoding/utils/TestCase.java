package com.juaracoding.utils;

public enum TestCase {

    T1("User Login Valid"),
    T2("User move to division menu"),
    T3("Batal tambah divisi baru"),
    T4("Input divisi baru dengan jumlah karakter lebih dari 255"),
    T5("Input divisi baru benar"),
    T6("Input divisi baru dengan nama yang sama"),
    T7("Input divisi dengan nama blank atau kosong");

    private String testCaseName;

    TestCase(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
