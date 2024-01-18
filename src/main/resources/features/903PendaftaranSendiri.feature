Feature: Pendaftaran Sendiri
 #1
  Scenario: Menu Management Pendaftaran Sendiri
    Given Admin go to menu management
    And go to pendaftaran sendiri
    Then page pendaftaran sendiri
#2
  Scenario: Search by name
    Given Search by name
    When admin iputkan nama user
    And admin klik btn search
    Then data tampil
#3
  Scenario: Search by nik
    And Reset Search
    And Search by nik
    And admin inputkan nik user
    And admin klik btn search
    Then data tampil
#4
  Scenario: Search name by nik
    And Reset Search
    And Search by nik
    And inputkan nama user
    And admin klik btn search
    Then data tampil
#5
  Scenario: Search nik by name
    And Reset Search
    And Search by name
    And inputkan nik user
    And admin klik btn search
    Then data tampil
#6
  Scenario: Batal Filter
    And klik btn Filter
    And klik batal filter
    Then data tampil
#7
  Scenario: Filter
    And Reset Search
    And klik btn Filter
    And pilih filter by
    And klik IT
    And Terapkan
    Then data tampil
    And Reset Search
#8
  Scenario: Button Data Perhalaman 25
    And Klik btn data perhalaman
    And klik 25
    Then data tampil
#9
  Scenario: Button Data perhalaman 10
    And Klik btn data perhalaman
    And klik 10
    Then data tampil
#10
  Scenario: Button Data Perhalaman 5
    And Klik btn data perhalaman
    And klik 5
    Then data tampil
#11
  Scenario: Next Page User
    And refresh page
    And Klik next page
    Then data tampil
#12
  Scenario: Previous Page User
    And refresh page
    And Klik previous page
    Then data tampil
#13
  Scenario: Last Page User
    And refresh page
    And Klik last page
    Then data tampil
#14
  Scenario: First Page User
    And refresh page
    And Klik first page
    Then data tampil
#15
  Scenario: Batal hapus user registration
    And refresh page
    And klik tombol hapus user
    And klik tombol batal
    Then data tampil
#16
  Scenario: Hapus user registration
    And refresh page
    And klik tombol hapus user
    And klik tombol ya
    Then data tampil
#17
  Scenario: Update data menggunakan view button
    And refresh page
    And klik tombol view button
    Then berada di tab user
#18
  Scenario: Update data User hapus foto karyawan
    When Hapus foto karyawan
    And pilih divisi
    And pilih unit
    And pilih tipe kontrak
    And pilih posisi kerja
    And pilih jabatan
    And pilih atasan1
    #And pilih atasan2
    And pilih atasan3
    And pilih lokasi kerja
    And pilih tipe shift
    And pilih jadwal kerja
    And pilih selfie
    And input jumlah cuti
    And klik submit
    Then pemberitahuan1
#19
  Scenario: Update data User input file doc
    And refresh page
    When Hapus foto karyawan
    And upload file doc
    And pilih divisi
    And pilih unit
    And pilih tipe kontrak
    And pilih posisi kerja
    And pilih jabatan
    And pilih atasan1
    #And pilih atasan2
    And pilih atasan3
    And pilih lokasi kerja
    And pilih tipe shift
    And pilih jadwal kerja
    And pilih selfie
    And input jumlah cuti
    And klik submit
    Then pemberitahuan1
#20
  Scenario: Update data tanpa nik
    And refresh page
    And upload file foto
    And kosongkan nik
    And klik submit
    Then pemberitahuan2
#21
  Scenario: Update data tanpa nama
    And refresh page
    And upload file foto
    And kosongkan nama
    And klik submit
    Then pemberitahuan3
#22
  Scenario: Update data tanpa email
    And refresh page
    And upload file foto
    And kosongkan email
    And klik submit
    Then pemberitahuan4
#23
  Scenario: Update data dengan inputkan nik dengan 1 huruf
    And refresh page
    And upload file foto
    And isi nik 1 huruf
    And klik submit
    Then pemberitahuan5
#24
  Scenario: Update Data input nama dengan 1 huruf
    And refresh page
    And upload file foto
    And isi nama 1 huruf
    And klik submit
    Then pemberitahuan6
#25
  Scenario: Update data input email tanpa @
    And refresh page
    And upload file foto
    And inputkan email tanpa et
    And klik submit
    Then pemberitahuan7

#26
  Scenario: Update Data dengan atasan sesuai nama Data User Registrasi
    And refresh page
    And upload file foto
    And pilih divisi
    And pilih unit
    And pilih tipe kontrak
    And pilih posisi kerja
    And pilih jabatan
    And pilih atasan sesuai user
    #And pilih atasan2
    And pilih atasan3
    And pilih lokasi kerja
    And pilih tipe shift
    And pilih jadwal kerja
    And pilih selfie
    And input jumlah cuti
    And klik submit
    #Then pemberitahuan8
#27
  Scenario: Update data Valid
    Given Admin go to menu management
    And go to pendaftaran sendiri
    And klik tombol view button
    And Hapus foto karyawan
    And upload file foto
    And pilih divisi
    And pilih unit
    And pilih tipe kontrak
    And pilih posisi kerja
    And pilih jabatan
    And pilih atasan1
    #And pilih atasan2
    And pilih atasan3
    And pilih lokasi kerja
    And pilih tipe shift
    And pilih jadwal kerja
    And pilih selfie
    And input jumlah cuti
    And klik submit
    And klik user
    Then pemberitahuan9
#28
  Scenario: Update data diceklis
    And refresh page
    And go to pendaftaran sendiri
    And ceklis user
    And klik btn update data diceklis
    And isi divisi
    And isi posisi
    And isi jabatan
    And isi atasan
    And isi kontrak
    And isi lokasi
    And isi jadwal
    And klik btn submit
    Then pemberitahuan edit
    And klik silang
