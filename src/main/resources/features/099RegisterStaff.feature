Feature: User Register

  # 1
  Scenario: Input URL Salah
   Given Input URL Register Staff Admin yang salah
   When Klik tombol Enter pada Keyboard
   Then Menampilkan Halaman Register yang salah atau 404
  # 2
  Scenario: Input URL Benar
    Given Input URL Register Staff Admin yang benar
    When Klik tombol Enter pada Keyboard
    Then Menampilkan Halaman Registrasi

  # 3
  Scenario: Input valid NIK, Nama Lengkap, Password, Upload Selfie, Email tanpa '@'
    Given Pergi ke halaman registrasi
    When Masukan NIK
    And Masukan Nama Lengkap
    And Masukan Email tanpa '@'
    And Masukan Password
    And Masukan Upload Selfie
    And Klik Daftar
    Then User gagal daftar, muncul peringatan perlu simbol add

  # 4
  Scenario: Input valid NIK, Nama Lengkap, Password, Upload Selfie, Email yang sudah terdaftar
    Given Pergi ke halaman registrasi
    When Masukan NIK
    And Masukan Nama Lengkap
    And Masukan Email yang sudah terdaftar
    And Masukan Password
    And Masukan Upload Selfie
    And Klik Daftar
    Then User gagal daftar, muncul peringatan email sudah terdaftar

  # 5
  Scenario: Input valid NIK, Nama Lengkap, Email, Password, Upload Selfie lebih dari 2 MB
    Given Pergi ke halaman registrasi
    When Masukan NIK
    And Masukan Nama Lengkap
    And Masukan Email
    And Masukan Password
    And Masukan Upload Selfie lebih dari 2 MB
    And Klik Daftar
    Then User gagal daftar, muncul peringatan file lebih dari 2 MB

  # 6
  Scenario: Input valid NIK, Nama Lengkap, Email, Password, Upload Selfie selain format gambar
    Given Pergi ke halaman registrasi
    When Masukan NIK
    And Masukan Nama Lengkap
    And Masukan Email
    And Masukan Password
    And Masukan Upload Selfie selain format gambar
    And Klik Daftar
    Then User gagal daftar, muncul peringatan harus menggunakan format gambar

  # 7
  Scenario: Input valid, Nama Lengkap, Email, Password, Upload Selfie, NIK Kosong
    Given Pergi ke halaman registrasi
    When Masukan NIK kosong
    And Masukan Nama Lengkap
    And Masukan Email
    And Masukan Password
    And Masukan Upload Selfie
    And Klik Daftar
    Then User gagal daftar, muncul peringatan NIK kosong

  # 8
  Scenario: Input valid NIK, Email, Password, Upload Selfie, Nama Lengkap Kosong
    Given Pergi ke halaman registrasi
    When Masukan NIK
    And Masukan Nama Lengkap kosong
    And Masukan Email
    And Masukan Password
    And Masukan Upload Selfie
    And Klik Daftar
    Then User gagal daftar, muncul peringatan Nama Lengkap kosong

  # 9
  Scenario: Input valid NIK, Nama Lengkap, Password, Upload Selfie, Email Kosong
    Given Pergi ke halaman registrasi
    When Masukan NIK
    And Masukan Nama Lengkap
    And Masukan Email kosong
    And Masukan Password
    And Masukan Upload Selfie
    And Klik Daftar
    Then User gagal daftar, muncul peringatan Email kosong

  # 10
  Scenario: Input valid NIK, Nama Lengkap, Email, Upload Selfie, Password Kosong
    Given Pergi ke halaman registrasi
    When Masukan NIK
    And Masukan Nama Lengkap
    And Masukan Email
    And Masukan Password kosong
    And Masukan Upload Selfie
    And Klik Daftar
    Then User gagal daftar, muncul peringatan Password kosong

  # 11
  Scenario: Input valid NIK, Nama Lengkap, Email, Upload Selfie, Password Kosong
    Given Pergi ke halaman registrasi
    When Masukan NIK
    And Masukan Nama Lengkap
    And Masukan Email
    And Masukan Password
    And Masukan Upload Selfie kosong
    And Klik Daftar
    Then User gagal daftar, muncul peringatan Upload Selfie kosong

  # 12
#  Scenario: Input valid NIK, Email , Password , Upload Selfie, Nama Lengkap hanya angka saja
#    Given Pergi ke halaman registrasi
#    When Masukan NIK
#    And Masukan Nama Lengkap hanya angka
#    And Masukan Email
#    And Masukan Password
#    And Masukan Upload Selfie
#    And Klik Daftar
#    Then User gagal daftar, muncul peringatan
#
#  # 13
#  Scenario: Input valid NIK , Nama Lengkap, Email , Password , Upload Selfie
#    Given Pergi ke halaman registrasi
#    When Masukan NIK
#    And Masukan Nama Lengkap
#    And Masukan Email
#    And Masukan Password
#    And Masukan Upload Selfie
#    And Klik Daftar
#    Then User berhasil terdaftar

