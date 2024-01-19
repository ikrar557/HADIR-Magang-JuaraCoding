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
    T11("Input valid NIK, Nama Lengkap, Email, Password, Upload Selfie Kosong"),
    T12("Input Valid NIK, Email, Password , Upload Selfie, Nama Lengkap hanya Angka saja "),
    T13("Input Valid NIK, Nama Lengkap, Password, Upload Selfie, Email Di isi dengan Karakter Specia"),
    T14("Input Valid NIK, Nama Lengkap, Password, Upload Selfie, Email Di isi dengan Angka saja"),
    T15("Input Valid NIK, Nama Lengkap, Password, Upload Selfie, Email Di isi Tanpa Domain"),
    T16("Input Valid NIK, Email, Password, Upload Selfie, Nama Lengkap hanya Karakter Special"),
    T17("Input Valid Nama Lengkap, Email, Password, Upload Selfie, Input NIK Dengan Email"),
    T18("Input Valid, Nama Lengkap, Email, Password, Upload Selfie, NIK menggunakan Karakter Special"),
    T19("Input Valid, Nama Lengkap, Email , Password, Upload Selfie, NIK menggunakan Nama Lengkap"),
    T20("Input valid NIK , Nama Lengkap, Email , Password , Upload Selfie");


    private String testCaseName;

    TestCase(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
