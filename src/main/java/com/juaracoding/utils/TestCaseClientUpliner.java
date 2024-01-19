package com.juaracoding.utils;

public enum TestCaseClientUpliner {

    T1("Input URL benar"),
    T2("Input valid Username dan Password"),
    T3("User pindah ke menu client upliner"),
    T4("Tambah valid client upliner baru dengan tipe upliner v2"),
    T5("Tambah client tipe upliner V2 dengan alamat email yang sudah ada"),
    T6("Tambah valid client upliner baru dengan tipe upliner v3"),
    T7("Tambah client tipe upliner V3 dengan alamat email yang sudah ada"),
    T8("Tambah client upliner baru dengan invalid alamat email"),
    T9("Tambah client upliner baru dengan email baru tapi dengan nama dan unit yang sama"),
    T10("Tambah client upliner baru dengan email baru tapi dengan nama sama namun beda unit"),
    T11("Tambah client upliner baru dengan data valid namun password kurang dari 8 karakter"),
    T12("Tambah client upliner baru dengan data valid namun nama hanya angka saja"),
    T13("Cari nama client dengan nama yang tidak ada pada list"),
    T14("Reset pencarian nama client"),
    T15("Cari client dengan nama yang sudah ditentukan"),
    T16("Edit nama client menjadi \"Ikrar Bagaskara\""),
    T17("Edit client dengan nama \"Ikrar Bagaskara\" menjadi angka saja"),
    T18("Edit client dengan nama client menjadi identik dengan nama client lain"),
    T19("Edit email client menggunakan email baru"),
    T20("Edit email client menggunakan email yang sudah digunakan"),
    T21("Edit client dengan unit \"Air Asia\" menjadi \"TEKNISI EDC\""),
    T22("Batal filter berdasarkan unit \"Air Asia\""),
    T23("Filter berdasarkan unit \"Air Asia\""),
    T24("Batal delete client yang sudah ditambahkan"),
    T25("Delete client sudah ditambahkan"),
    T26("Filter jumlah baris yang ditampilkan menjadi 5 baris pada setiap halaman"),
    T27("Filter jumlah baris yang ditampilkan menjadi 10 baris pada setiap halaman"),
    T28("Filter jumlah baris yang ditampilkan menjadi 25 baris pada setiap halaman"),
    T29("Pindah ke halaman paling akhir"),
    T30("Pindah ke halaman sebelumnya"),
    T31("Pindah ke halaman paling awal"),
    T32("Pindah ke halaman selanjutnya");



    private String testCaseName;

    TestCaseClientUpliner(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }

}
