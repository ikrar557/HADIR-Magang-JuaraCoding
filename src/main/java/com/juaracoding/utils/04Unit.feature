Feature: Unit Module
  #1
  Scenario: Batal tambah unit baru
    Given Masuk menu "Unit"
    When Klik tombol "Tambahkan"
    And Masukan nama unit baru
    And Klik tombol "Batal"
    Then Kembali ke daftar unit, unit baru batal di tambahkan

  #2
  Scenario: Input unit baru dengan jumlah karakter lebih dari 255
    Given Masuk menu "Unit"
    When Klik tombol "Tambahkan"
    And Masukan random karakter yang lebih dari 255
    And Klik tombol "Tambah"
    Then Muncul pop-up "Gagal menambahkan Departements"

  #3
  Scenario: Input unit baru benar
    Given Masuk menu "Unit"
    When Klik tombol "Tambahkan"
    And Masukan nama unit baru
    And Klik tombol "Tambah"
    Then Unit baru berhasil ditambahkan

  #4
  Scenario: Input unit baru dengan nama yang sama
    Given Masuk menu "Unit"
    When Klik tombol "Tambahkan"
    And Masukan nama unit baru
    And Klik tombol "Tambah"
    Then Unit baru gagal ditambahkan, unit sudah tersedia

  #5
  Scenario: Input unit dengan nama blank atau kosong
    Given Masuk menu "Unit"
    When Klik tombol "Tambahkan"
    And Masukan input kosong
    And Klik tombol "Tambah"
    Then Unit gagal ditambahkan, muncul pop-up "Please fill out the field"

  #6
  Scenario: Cari unit dengan nama yang tidak ada pada list
    Given Masuk menu "Unit"
    When Masukan nama unit yang tidak ada pada list
    And Klik tombol "Search"
    Then Tidak muncul unit yang dicari

  #7
  Scenario: Reset pencarian unit
    Given Masuk menu "Unit"
    When Masukan nama unit pada kolom pencarian
    And Klik tombol "Search"
    And Muncul unit yang dicari
    And Klik tombol "Reset"
    Then Daftar unit kembali ke semula

  #8
  Scenario: Cari unit dengan nama "SQA-RPA JC 12"
    Given Masuk menu "Unit"
    When Masukan nama unit pada kolom pencarian
    And Klik tombol "Search"
    Then Muncul unit yang dicari

  #9
  Scenario: Batal edit unit dengan nama "SQA-RPA JC 12" menjadi "SQA-RPA JC Benhil"
    Given Cari unit pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris unit yang dicari
    And Klik "Edit"
    And Rubah "Nama Unit" menjadi nama unit baru
    And Klik "Batal"
    Then Nama unit masih nama unit lama

  #10
  Scenario: Edit unit dengan nama "SQA-RPA JC 12" menjadi "SQA-RPA JC Benhil"
    Given Cari unit pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris unit yang dicari
    And Klik "Edit"
    And Rubah "Nama Unit" menjadi nama unit baru
    And Klik "Simpan"
    Then Nama unit lama ganti menjadi nama unit baru

  #11
  Scenario: Edit unit yang sudah ditambahkan dengan nama yang sama
    Given Cari unit pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris unit yang dicari
    And Klik "Edit"
    And Rubah "Nama Unit" menjadi nama unit baru
    And Klik "Simpan"
    Then Nama unit lama gagal di ganti menjadi nama unit baru karena nama sudah tersedia

  #12
  Scenario: Batal delete unit yang sudah di tambahkan
    Given Cari nama unit baru pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris unit yang dicari
    And Klik "Delete"
    And Klik "Tidak"
    Then Unit baru masih ada pada daftar unit

  #13
  Scenario: Delete unit yang sudah di tambahkan
    Given Cari nama unit baru pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris unit yang dicari
    And Klik "Delete"
    And Klik "Ya"
    Then Unit baru berhasil dihapus dari daftar unit

#  #14
  Scenario: Filter jumlah baris yang ditampilkan menjadi 5 baris pada setiap halaman
    Given Scroll ke bawah halaman
    When Klik drop down di samping Rows per page
    And Klik "5"
    Then Jumlah baris yang ditampilkan adalah 5 baris

#  #15
  Scenario: Filter jumlah baris yang ditampilkan menjadi 10 baris pada setiap halaman
    Given Scroll ke bawah halaman
    When Klik drop down di samping Rows per page
    And Klik "10"
    Then Jumlah baris yang ditampilkan adalah 10 baris

#  #16
  Scenario: Filter jumlah baris yang ditampilkan menjadi 25 baris pada setiap halaman
    Given Scroll ke bawah halaman
    When Klik drop down di samping Rows per page
    And Klik "25"
    Then Jumlah baris yang ditampilkan adalah 25 baris

#  TODO : Don't forget to add verification to check : Last Page, Next Page, First Page, Previous Page
#  #17
#  Scenario: Pindah ke halaman selanjutnya
#   Given Scroll ke bawah halaman
#   When Klik icon ">"
#   Then Berhasil pindah ke halaman selanjutnya
#
#  #18
#  Scenario: Pindah ke halaman sebelumnya
#   Given Scroll ke bawah halaman
#   When Klik icon "<"
#   Then Berhasil pindah ke halaman sebelumnya
#
#  #19
#  Scenario: Pindah ke halaman paling akhir
#   Given Scroll ke bawah halaman
#   When Klik icon ">|"
#   Then Berhasil pindah ke halaman  paling akhir
#
#  #20
#  Scenario: Pindah ke halaman paling awal
#   Given Scroll ke bawah halaman
#   When Klik icon "|<"
#   Then Berhasil pindah ke halaman paling awal