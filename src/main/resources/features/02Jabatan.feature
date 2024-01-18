Feature: Jabatan Admin

  Scenario: Search Jabatan
    Given Login sebagai admin
    When Input 99 pada search field
    And Klik tombol search
    Then Menampilkan jabatan dengan level 99

  Scenario: Reset Search Jabatan
    When Klik tombol reset
    Then Menampilkan seluruh jabatan

  Scenario: Tambah Jabatan
    When Klik tombol tambah
    And Input nama jabatan
    And Input level jabatan
    And Klik tombol simpan
    Then Menampilkan pop up berhasil menambahkan jabatan

  Scenario: Negative Tambah Jabatan
    When Negative Klik tombol tambah
    And Negative Input nama jabatan
    And Negative Input level jabatan
    And Negative Klik tombol simpan
    Then Negative Menampilkan pop up gagal menambahkan jabatan
    Then Klik tombol batal

  Scenario: Edit Jabatan
    When Cari jabatan level 98
    And Klik tombol titik tiga
    And Klik tombol edit
    And Edit nama jabatan
    And Klik tombol simpan edit
    Then Menampilkan jabatan dengan nama Boss Besar

  Scenario: Delete Jabatan
    When Klik tombol titik tiga untuk dihapus
    And Klik tombol hapus
    And Klik tombol konfirmasi hapus
    Then Menampilkan pop up berhasil menghapus jabatan