package com.juaracoding.utils;

public enum TestCaseDivisi {

    T1("Input URL benar"),
    T2("Input valid Username dan Password"),
    T3("User pindah ke menu divisi"),
    T4("Batal tambah divisi baru"),
    T5("Input divisi baru dengan jumlah karakter lebih dari 255"),
    T6("Input divisi baru benar"),
    T7("Input divisi baru dengan nama yang sama"),
    T8("Input divisi dengan nama blank atau kosong"),
    T9("Cari divisi dengan nama yang tidak ada pada list"),
    T10("Reset pencarian divisi"),
    T11("Cari divisi dengan nama \"JC-SQA 12\""),
    T12("Batal edit divisi dengan nama \"JC-SQA 12\" menjadi \"JC-SQA Batch 12\""),
    T13("Edit divisi dengan nama \"JC-SQA 12\" menjadi \"JC-SQA Batch 12\""),
    T14("Edit divisi yang sudah ditambahkan dengan nama yang sama"),
    T15("Batal delete divisi yang sudah di tambahkan"),
    T16("Delete divisi yang sudah di tambahkan"),
    T17("Filter jumlah baris yang ditampilkan menjadi 5 baris pada setiap halaman"),
    T18("Filter jumlah baris yang ditampilkan menjadi 10 baris pada setiap halaman"),
    T19("Filter jumlah baris yang ditampilkan menjadi 25 baris pada setiap halaman"),
    T20("Pindah ke halaman paling akhir"),
    T21("Pindah ke halaman sebelumnya"),
    T23("Pindah ke halaman paling awal"),
    T24("Pindah ke halaman selanjutnya");

    private String testCaseName;

    TestCaseDivisi(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
