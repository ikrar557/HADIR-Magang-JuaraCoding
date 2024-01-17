Feature: Login Admin/Staff

  Scenario: Input URL benar
   Given  Input url Absen Hadir yang benar
   When  Klik tombol enter pada keyboard
   Then  Menampilkan halaman login

   Scenario: Input valid Username dan Password
    Given Input username yang terdaftar
    When Input password yang terdaftar
    And Klik tombol Sign In
    Then Berhasil masuk ke halaman dashboard