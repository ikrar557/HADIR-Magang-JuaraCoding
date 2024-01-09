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