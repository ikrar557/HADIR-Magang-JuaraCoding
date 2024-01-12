Feature: Divisi Module
  #1
  Scenario: Batal tambah divisi baru
   Given Masuk menu "Divisi"
   When Klik tombol "Tambahkan"
   And Masukan nama divisi baru
   And Klik tombol "Batal"
   Then Kembali ke daftar divisi, divisi baru batal di tambahkan
  #2
  Scenario: Input divisi baru dengan jumlah karakter lebih dari 255
   Given Masuk menu "Divisi"
   When Klik tombol "Tambahkan"
   And Masukan random karakter yang lebih dari 255
   And Klik tombol "Tambah"
   Then Muncul pop-up "Gagal menambahkan divisi"
  #3
  Scenario: Input divisi baru benar
   Given Masuk menu "Divisi"
   When Klik tombol "Tambahkan"
   And Masukan nama divisi baru
   And Klik tombol "Tambah"
   Then Divisi baru berhasil ditambahkan
  #4
  Scenario: Input divisi baru dengan nama yang sama
   Given Masuk menu "Divisi"
   When Klik tombol "Tambahkan"
   And Masukan nama divisi baru
   And Klik tombol "Tambah"
   Then Divisi baru gagal ditambahkan, divisi sudah tersedia
  #5
  Scenario: Input divisi dengan nama blank atau kosong
   Given Masuk menu "Divisi"
   When Klik tombol "Tambahkan"
   And Masukan input kosong
   And Klik tombol "Tambah"
   Then Divisi gagal ditambahkan, muncul pop-up "Please fill out the field"
  #6
  Scenario: Cari divisi dengan nama yang tidak ada pada list
   Given Masuk menu "Divisi"
   When Masukan nama divisi yang tidak ada pada list
   And Klik tombol "Search"
   Then Tidak muncul divisi yang dicari

  #7
  Scenario: Reset pencarian divisi
   Given Masuk menu "Divisi"
   When Masukan nama divisi pada kolom pencarian
   And Klik tombol "Search"
   And Muncul divisi yang dicari
   And Klik tombol "Reset"
   Then Daftar divisi kembali ke semula

  #8
  Scenario: Cari divisi dengan nama "JC-SQA 12"
   Given Masuk menu "Divisi"
   When Masukan nama divisi pada kolom pencarian
   And Klik tombol "Search"
   Then Muncul divisi yang dicari

  #9
  Scenario: Batal edit divisi dengan nama "JC-SQA 12" menjadi "JC-SQA Batch 12"
   Given Cari divisi pada kolom pencarian
   When Klik icon 3 baris pada sisi kanan baris divisi yang dicari
   And Klik "Edit"
   And Rubah "Nama Divisi" menjadi nama divisi baru
   And Klik "Batal"
   Then Nama divisi masih nama divisi lama

  #10
  Scenario: Edit divisi dengan nama "JC-SQA 12" menjadi "JC-SQA Batch 12"
   Given Cari divisi pada kolom pencarian
   When Klik icon 3 baris pada sisi kanan baris divisi yang dicari
   And Klik "Edit"
   And Rubah "Nama Divisi" menjadi nama divisi baru
   And Klik "Simpan"
   Then Nama divisi lama ganti menjadi nama divisi baru

  #11
  Scenario: Edit divisi yang sudah ditambahkan dengan nama yang sama
   Given Cari divisi pada kolom pencarian
   When Klik icon 3 baris pada sisi kanan baris divisi yang dicari
   And Klik "Edit"
   And Rubah "Nama Divisi" menjadi nama divisi baru
   And Klik "Simpan"
   Then Nama divisi lama gagal di ganti menjadi nama divisi baru karena nama sudah tersedia

  #12
  Scenario: Batal delete divisi yang sudah di tambahkan
   Given Cari nama divisi baru pada kolom pencarian
   When Klik icon 3 baris pada sisi kanan baris divisi yang dicari
   And Klik "Delete"
   And Klik "Tidak"
   Then Divisi baru masih ada pada daftar divisi

  #13
  Scenario: Delete divisi yang sudah di tambahkan
   Given Cari nama divisi baru pada kolom pencarian
   When Klik icon 3 baris pada sisi kanan baris divisi yang dicari
   And Klik "Delete"
   And Klik "Ya"
   Then Divisi baru berhasil dihapus dari daftar divisi

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




