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