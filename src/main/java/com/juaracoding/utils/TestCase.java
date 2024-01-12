package com.juaracoding.utils;

public enum TestCase {

    T1("Input URL benar"),
    T2("Input valid Username dan Password"),
    T3("Menu Management Pendaftaran Sendiri"),
    T4("Search By Name"),
    T5("Search By Nik"),
    T6("Search Name by Nik"),
    T7("Search Nik by Name"),
    T8("Filter data lalu batal"),
    T9("Filter data yang ada di tampilan"),
    T10("Button Data Perhalaman 25"),
    T11("Button Data Perhalaman 10"),
    T12("Button Data Perhalaman 5"),
    T13("Next Page User"),
    T14("Previous Page Data User"),
    T15("Last Page Data User"),
    T16("First Page Data User"),
    T17("Batal Hapus Data User Registration"),
    T18("Hapus Data User Registration"),
    T19("Update Data menggunakan View Button"),
    T20("Update Data User dengan hapus foto karyawan"),
    T21("Update Data User dengan hapus foto file doc"),
    T22("Update Data Tanpa Nik"),
    T23("Update Data Tanpa Nama"),
    T24("Update Data Tanpa Email"),
    T25("Update data dengan inputkan nik dengan 1 huruf"),
    T26("Update Data input nama dengan 1 huruf"),
    T27("Update data input email tanpa @"),
    T28("Update Data dengan atasan sesuai nama Data User Registrasi"),
    T29("Update Input Data User Registrasi Valid"),
    T30("Update data melalui data di ceklis");

    private String testCaseName;

    TestCase(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
