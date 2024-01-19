Feature: Input Client Upliner Baru

  #1
  Scenario: Tambah valid client upliner baru dengan tipe upliner v2
   Given Masuk menu "Client Upliner"
   Then Klik tombol "Tambahkan"
   And Masukan nama
   And Masukan email
   And Masukan password
   And Pilih Unit
   And Pilih Tipe "Upliner V2"
   And Klik "Daftar"
   Then Data Client Upliner V2 berhasil ditambahkan

  #2
  Scenario: Tambah client tipe upliner V2 dengan alamat email yang sudah ada
   Given Masuk menu "Client Upliner"
   When Klik tombol "Tambahkan"
   And Masukan nama
   And Masukan email yang sudah terdaftar
   And Masukan password
   And Pilih Unit
   And Pilih Tipe "Upliner V2"
   And Klik "Daftar"
   Then Data gagal ditambahkan, muncul pop-up "Email sudah terdaftar"

  #3
  Scenario: Tambah valid client upliner baru dengan tipe upliner v3
    Given Masuk menu "Client Upliner"
    Then Klik tombol "Tambahkan"
    And Masukan nama
    And Masukan email
    And Masukan password
    And Pilih Unit
    And Pilih Tipe "Upliner V3"
    And Klik "Daftar"
    Then Data Client Upliner V3 berhasil ditambahkan

  #4
  Scenario: Tambah client tipe upliner V3 dengan alamat email yang sudah ada
    Given Masuk menu "Client Upliner"
    When Klik tombol "Tambahkan"
    And Masukan nama
    And Masukan email yang sudah terdaftar
    And Masukan password
    And Pilih Unit
    And Pilih Tipe "Upliner V3"
    And Klik "Daftar"
    Then Data gagal ditambahkan, muncul pop-up "Email sudah terdaftar"

    #5
  Scenario: Tambah client upliner baru dengan invalid alamat email
    Given Masuk menu "Client Upliner"
    When Klik tombol "Tambahkan"
    And Masukan nama
    And Masukan email tanpa "@"
    And Masukan password
    And Pilih Unit
    And Pilih Tipe "Upliner V2"
    And Klik "Daftar"
    Then Data gagal ditambahkan, muncul warning untuk menambahkan "@" pada kolom email

    #6
  Scenario: Tambah client upliner baru dengan email baru tapi dengan nama dan unit yang sama
    Given Masuk menu "Client Upliner"
    When Klik tombol "Tambahkan"
    And Masukan nama yang sudah terdaftar
    And Masukan email
    And Masukan password
    And Pilih Unit
    And Pilih Tipe "Upliner V2"
    And Klik "Daftar"
    Then Data gagal ditambahkan

    #7
  Scenario: Tambah client upliner baru dengan email baru tapi dengan nama sama namun beda unit
    Given Masuk menu "Client Upliner"
    When Klik tombol "Tambahkan"
    And Masukan nama yang sudah terdaftar
    And Masukan email
    And Masukan password
    And Pilih Unit yang berbeda
    And Pilih Tipe "Upliner V2"
    And Klik "Daftar"
    Then Data berhasil ditambahkan

    #8
  Scenario: Tambah client upliner baru dengan data valid namun password kurang dari 8 karakter
    Given Masuk menu "Client Upliner"
    When Klik tombol "Tambahkan"
    And Masukan nama
    And Masukan email
    And Masukan password kurang dari 8 karakter
    And Pilih Unit
    And Pilih Tipe "Upliner V2"
    And Klik "Daftar"
    Then Muncul warning password kurang dari 8 karakter

    #9
  Scenario: Tambah client upliner baru dengan data valid namun nama hanya angka saja
    Given Masuk menu "Client Upliner"
    When Klik tombol "Tambahkan"
    And Masukan nama hanya angka saja
    And Masukan email
    And Masukan password
    And Pilih Unit
    And Pilih Tipe "Upliner V2"
    And Klik "Daftar"
    Then Client dengan nama angka gagal ditambahkan

  #10
  Scenario: Cari nama client dengan nama yang tidak ada pada list
    Given Masuk menu "Client Upliner"
    When Masukan nama client yang tidak ada pada list
    And Klik tombol "Search"
    Then Tidak muncul client yang dicari

  #11
  Scenario: Reset pencarian nama client
    Given Masuk menu "Client Upliner"
    When Masukan nama client pada kolom pencarian
    And Klik tombol "Search"
    And Muncul nama client yang dicari
    And Klik tombol "Reset"
    Then Daftar client kembali ke semula

  #12
  Scenario: Cari client dengan nama yang sudah ditentukan
    Given Masuk menu "Client Upliner"
    When Masukan nama client pada kolom pencarian
    And Klik tombol "Search"
    Then Muncul nama client yang dicari

  #13
  Scenario: Edit nama client menjadi "Ikrar Bagaskara"
    Given Cari nama client yang ingin di edit pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris nama client
    And Klik "Edit"
    And Rubah "Nama Karyawan" menjadi nama client baru
    And Klik "Ubah"
    Then Nama karyawan berubah menjadi nama client baru

  #14
  Scenario: Edit client dengan nama "Ikrar Bagaskara" menjadi angka saja
    Given Cari nama client yang ingin di edit nama menjadi angka
    When Klik icon 3 baris pada sisi kanan baris nama client
    And Klik "Edit"
    And Rubah "Nama Karyawan" menjadi angka saja
    And Klik "Ubah"
    Then Error harusnya nama karyawan tidak boleh hanya angka saja

  #15
  Scenario: Edit client dengan nama client menjadi identik dengan nama client lain
    Given Cari nama client yang ingin di edit nama menjadi identik nama lain
    When Klik icon 3 baris pada sisi kanan baris nama client
    And Klik "Edit"
    And Rubah "Nama Karyawan" menjadi nama client identik
    And Klik "Ubah"
    Then Gagal edit nama client, nama identik dengan client lain

  #16
  Scenario: Edit email client menggunakan email baru
    Given Cari nama client yang ingin di edit email baru pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris nama client
    And Klik "Edit"
    And Rubah "Email" menjadi email baru
    And Klik "Ubah"
    Then Alamat karyawan berubah menjadi alamat email baru

  #17
  Scenario: Edit email client menggunakan email yang sudah digunakan
    Given Cari nama client yang ingin di edit email baru pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris nama client
    And Klik "Edit"
    And Rubah "Email" menjadi email yang sudah terdaftar
    And Klik "Ubah"
    Then Muncul pop-up "Email sudah terdaftar"

  #18
  Scenario: Edit client dengan unit "BCA Life" menjadi "TEKNISI EDC"
    Given Cari client dengan unit yang sudah ditentukan
    When Klik icon 3 baris pada sisi kanan baris nama client
    And Klik "Edit"
    And Rubah "Unit" menjadi unit yang sudah ditentukan
    And Klik "Ubah"
    Then Nama unit berubah menjadi nama unit baru

  #19
  Scenario: Batal filter berdasarkan unit "Air Asia"
    Given Masuk menu "Client Upliner"
    When Klik icon "Filter"
    And Pilih unit yang akan difilter
    And Klik "Batal" filter unit
    Then Daftar client belum terfillter

  #20
  Scenario: Filter berdasarkan unit "Air Asia"
    Given Masuk menu "Client Upliner"
    When Klik icon "Filter"
    And Pilih unit yang akan difilter
    And Klik "Terapkan"
    Then Daftar client sudah terfilter

  #21
  Scenario: Batal delete client yang sudah ditambahkan
    Given Cari nama client yang akan dihapus pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris nama client
    And Klik "Delete"
    And Klik "Tidak"
    Then Client masih ada pada daftar client

  #22
  Scenario: Delete client sudah ditambahkan
    Given Cari nama client yang akan dihapus pada kolom pencarian
    When Klik icon 3 baris pada sisi kanan baris nama client
    And Klik "Delete"
    And Klik "Ya"
    Then Client berhasil dihapus dari daftar client

  #23
  Scenario: Filter jumlah baris yang ditampilkan menjadi 5 baris pada setiap halaman
    Given Scroll ke bawah halaman
    When Klik drop down di samping Rows per page
    And Klik "5"
    Then Jumlah baris yang ditampilkan adalah 5 baris

  #24
  Scenario: Filter jumlah baris yang ditampilkan menjadi 10 baris pada setiap halaman
    Given Scroll ke bawah halaman
    When Klik drop down di samping Rows per page
    And Klik "10"
    Then Jumlah baris yang ditampilkan adalah 10 baris

  #25
  Scenario: Filter jumlah baris yang ditampilkan menjadi 25 baris pada setiap halaman
    Given Scroll ke bawah halaman
    When Klik drop down di samping Rows per page
    And Klik "25"
    Then Jumlah baris yang ditampilkan adalah 25 baris

  #26
  Scenario: Pindah ke halaman paling akhir
    Given Scroll ke bawah halaman
    When Klik icon halaman terakhir
    Then Berhasil pindah table upliner ke halaman paling akhir

  #27
  Scenario: Pindah ke halaman sebelumnya
    Given Scroll ke bawah halaman
    When Klik icon halaman sebelumnya
    Then Berhasil pindah table upliner ke halaman sebelumnya

  #28
  Scenario: Pindah ke halaman paling awal
    Given Scroll ke bawah halaman
    When Klik icon halaman paling awal
    Then Berhasil pindah table upliner ke halaman paling awal

  #29
  Scenario: Pindah ke halaman selanjutnya"
    Given Scroll ke bawah halaman
    When Klik icon halaman selanjutnya
    Then Berhasil pindah table upliner ke halaman selanjutnya
