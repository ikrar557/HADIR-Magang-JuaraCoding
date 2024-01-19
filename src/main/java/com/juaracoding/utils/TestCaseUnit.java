package com.juaracoding.utils;

public enum TestCaseUnit {

    T1("Input URL benar"),
    T2("Input valid Username dan Password"),
    T3("User pindah ke menu unit"),
    T4("Batal tambah unit baru"),
    T5("Input unit baru dengan jumlah karakter lebih dari 255"),
    T6("Input unit baru benar"),
    T7("Input unit baru dengan nama yang sama"),
    T8("Input unit dengan nama blank atau kosong"),
    T9("Cari unit dengan nama yang tidak ada pada list"),
    T10("Reset pencarian unit"),
    T11("Cari unit dengan nama \"SQA-RPA JC 12\""),
    T12("Batal edit unit dengan nama \"SQA-RPA JC 12\" menjadi \"SQA-RPA JC Benhil\""),
    T13("Edit unit dengan nama \"SQA-RPA JC 12\" menjadi \"SQA-RPA JC Benhil\""),
    T14("Edit unit yang sudah ditambahkan dengan nama yang sama"),
    T15("Batal delete unit yang sudah di tambahkan"),
    T16("Delete unit yang sudah di tambahkan"),
    T17("Filter jumlah baris yang ditampilkan menjadi 5 baris pada setiap halaman"),
    T18("Filter jumlah baris yang ditampilkan menjadi 10 baris pada setiap halaman"),
    T19("Filter jumlah baris yang ditampilkan menjadi 25 baris pada setiap halaman"),
    T20("Pindah ke halaman paling akhir"),
    T21("Pindah ke halaman sebelumnya"),
    T23("Pindah ke halaman paling awal"),
    T24("Pindah ke halaman selanjutnya");


    private String testCaseName;

    TestCaseUnit(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
