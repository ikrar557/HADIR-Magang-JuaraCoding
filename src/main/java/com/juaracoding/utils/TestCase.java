package com.juaracoding.utils;

public enum TestCase {

    T1("Input URL Salah"),
    T2("Input URL Benar"),
    T3("Input valid NIK, Nama Lengkap, Password, Upload Selfie, Email tanpa '@'"),
    T4("Input valid NIK, Nama Lengkap, Password, Upload Selfie, Email yang sudah terdaftar"),
    T5("Input valid NIK, Nama Lengkap, Email, Password, Upload Selfie lebih dari 2 MB"),
    T6("Input valid NIK, Nama Lengkap, Email, Password, Upload Selfie selain format gambar"),
    T7("Input valid, Nama Lengkap, Email, Password, Upload Selfie, NIK Kosong"),
    T8("Input valid NIK, Email, Password, Upload Selfie, Nama Lengkap Kosong"),
    T9("Input valid NIK, Nama Lengkap, Password, Upload Selfie, Email Kosong"),
    T10("Input valid NIK, Nama Lengkap, Email, Upload Selfie, Password Kosong"),
    T11("Input valid NIK, Nama Lengkap, Email, Upload Selfie, Password Kosong"),
    T12("Input valid NIK, Email , Password , Upload Selfie, Nama Lengkap hanya angka saja"),
    T13("Input valid NIK , Nama Lengkap, Email , Password , Upload Selfie");


    private String testCaseName;

    TestCase(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
