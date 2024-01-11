package TestNG.admin;

import TestNG.TestBase;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import com.juaracoding.pages.admin.PendaftaranSendiriPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.juaracoding.utils.Constant.ADMIN_URL;

public class PendaftaranSendiriTest extends TestBase {
    AdminLoginPage adminLoginPage;
    GlobalElementPage globalElementPage;
    PendaftaranSendiriPage pendaftaranSendiriPage;
    @BeforeClass
    public void testSetUpEnvironmentChrome(){
        setUpChrome();
        driver.get(ADMIN_URL);
        adminLoginPage = new AdminLoginPage();
        globalElementPage = new GlobalElementPage();
        pendaftaranSendiriPage = new PendaftaranSendiriPage();
    }
    @Test(priority = 1)
    public void testValidLogin(){
        globalElementPage.setEmail("admin@hadir.com");
        globalElementPage.setPassword("admin@hadir");
        adminLoginPage.clickAdminLoginButton();
    }
    @Test(dependsOnMethods = "testLogin")
    public void testMenuPendaftaran(){
        pendaftaranSendiriPage.setBtnManagement();
        pendaftaranSendiriPage.setBtnPendaftaran();
        Assert.assertTrue(pendaftaranSendiriPage.getTxtPendaftaran().contains("Pendaftaran Sendiri"));
    }
    @Test(dependsOnMethods = "testMenuPendaftaran")
    public void testCariUser(){
        //positif
        pendaftaranSendiriPage.setBtnPilihNikNama();
        pendaftaranSendiriPage.setNik("TEST1234");
        pendaftaranSendiriPage.setBtnCari();
        pendaftaranSendiriPage.setBtnResetCari();
        pendaftaranSendiriPage.setBtnPilihNikNama();
        pendaftaranSendiriPage.setNama("Aldi Sonic");
        pendaftaranSendiriPage.setBtnCari();
        pendaftaranSendiriPage.setBtnResetCari();
        //negatif
        pendaftaranSendiriPage.setBtnPilihNikNama();
        pendaftaranSendiriPage.setNik("Aldi Sonic");
        pendaftaranSendiriPage.setBtnCari();
        pendaftaranSendiriPage.setBtnResetCari();
        pendaftaranSendiriPage.setBtnPilihNikNama();
        pendaftaranSendiriPage.setNama("D6192283");
        pendaftaranSendiriPage.setBtnCari();
        pendaftaranSendiriPage.setBtnResetCari();
        DriverSingleton.delay(3);
        Assert.assertTrue(pendaftaranSendiriPage.getTxtDataUser().contains("Data User Registrasi Mobile"));
    }
    @Test(dependsOnMethods = "testCariUser")
    public void testFilter(){
        pendaftaranSendiriPage.setBtnFilter();
        pendaftaranSendiriPage.setBatalFilter();
        pendaftaranSendiriPage.setBtnFilter();
        pendaftaranSendiriPage.setFilterBy();
        pendaftaranSendiriPage.isiIT();
        pendaftaranSendiriPage.setTerapkanFilter();
        pendaftaranSendiriPage.setBtnResetCari();
    }
    @Test(dependsOnMethods = "testFilter")
    public void testDataPerhalaman(){
        pendaftaranSendiriPage.setDataPerhalaman();
        pendaftaranSendiriPage.setData25();
        pendaftaranSendiriPage.setDataPerhalaman();
        pendaftaranSendiriPage.setData10();
        pendaftaranSendiriPage.setDataPerhalaman();
        pendaftaranSendiriPage.setData5();
        DriverSingleton.delay(3);
        Assert.assertTrue(pendaftaranSendiriPage.getTxtDataUser().contains("Data User Registrasi Mobile"));
    }
    @Test(dependsOnMethods = "testDataPerhalaman")
    public void testBtnPage(){
        pendaftaranSendiriPage.setNextPage();
        pendaftaranSendiriPage.setPervPage();
        pendaftaranSendiriPage.setLastPage();
        pendaftaranSendiriPage.setFirstPage();
        DriverSingleton.delay(3);
        Assert.assertTrue(pendaftaranSendiriPage.getTxtDataUser().contains("Data User Registrasi Mobile"));
    }
    @Test(dependsOnMethods = "testBtnPage")
    public void hapusUser(){
        pendaftaranSendiriPage.setBtnHapusUser();
        pendaftaranSendiriPage.setBatalHapus();
        pendaftaranSendiriPage.setBtnHapusUser();
        pendaftaranSendiriPage.setYaHapus();
    }
    @Test(dependsOnMethods = "testMenuPendaftaran")
    public void testUpdateHapusFoto(){
        //WorkInformation
        pendaftaranSendiriPage.setBtnView();
        pendaftaranSendiriPage.setHapusFoto();
        pendaftaranSendiriPage.pilihDivisi("Bank Central Asia");
        pendaftaranSendiriPage.pilihUnit("BCA");
        pendaftaranSendiriPage.pilihTipeKontrak("Magang");
        pendaftaranSendiriPage.pilihPosisiKerja("SQA Analyst");
        pendaftaranSendiriPage.pilihJabatan("Staff");
        pendaftaranSendiriPage.pilihAtasan("Elanda Nur Afwi Desto");
        pendaftaranSendiriPage.pilihAtasan2("test");
        pendaftaranSendiriPage.pilihAtasan3("Koswara");
        //Absensi
        pendaftaranSendiriPage.pilihLokasiKerja("BCA Life");
        pendaftaranSendiriPage.setPilihShift();
        pendaftaranSendiriPage.pilihJadwalKerja("BCA Life");
        pendaftaranSendiriPage.setNonSelfie();
        pendaftaranSendiriPage.jumlahCuti(1);
        pendaftaranSendiriPage.btnSubmit();
        DriverSingleton.delay(2);
        Assert.assertEquals(pendaftaranSendiriPage.getTxtMessage(), "Foto tidak boleh kosong");
    }
    @Test(dependsOnMethods = "testUpdateHapusFoto")
    public void testFotoDoc(){
        pendaftaranSendiriPage.setTestrefresh();
        //WorkInformation
        pendaftaranSendiriPage.setHapusFoto();
        pendaftaranSendiriPage.upFileDoc();
        pendaftaranSendiriPage.pilihDivisi("Bank Central Asia");
        pendaftaranSendiriPage.pilihUnit("BCA");
        pendaftaranSendiriPage.pilihTipeKontrak("Magang");
        pendaftaranSendiriPage.pilihPosisiKerja("SQA Analyst");
        pendaftaranSendiriPage.pilihJabatan("Staff");
        pendaftaranSendiriPage.pilihAtasan("Elanda Nur Afwi Desto");
        pendaftaranSendiriPage.pilihAtasan2("test");
        pendaftaranSendiriPage.pilihAtasan3("Koswara");
        //Absensi
        pendaftaranSendiriPage.pilihLokasiKerja("BCA Life");
        pendaftaranSendiriPage.setPilihShift();
        pendaftaranSendiriPage.pilihJadwalKerja("BCA Life");
        pendaftaranSendiriPage.setNonSelfie();
        pendaftaranSendiriPage.jumlahCuti(1);
        pendaftaranSendiriPage.btnSubmit();
        DriverSingleton.delay(2);
        Assert.assertEquals(pendaftaranSendiriPage.getTxtMessage(), "Foto tidak boleh kosong");
    }
    @Test(dependsOnMethods = "testFotoDoc")
    public void testAtasanInvalid(){
        pendaftaranSendiriPage.setTestrefresh();
        //WorkInformation
        pendaftaranSendiriPage.setUpFile();
        pendaftaranSendiriPage.pilihDivisi("Bank Central Asia");
        pendaftaranSendiriPage.pilihUnit("BCA");
        pendaftaranSendiriPage.pilihTipeKontrak("Magang");
        pendaftaranSendiriPage.pilihPosisiKerja("SQA Analyst");
        pendaftaranSendiriPage.pilihJabatan("Staff");
        pendaftaranSendiriPage.atasanFailed();
        pendaftaranSendiriPage.pilihAtasan2("test");
        pendaftaranSendiriPage.pilihAtasan3("Koswara");
        //Absensi
        pendaftaranSendiriPage.pilihLokasiKerja("BCA Life");
        pendaftaranSendiriPage.setPilihShift();
        pendaftaranSendiriPage.pilihJadwalKerja("BCA Life");
        pendaftaranSendiriPage.setNonSelfie();
        pendaftaranSendiriPage.jumlahCuti(1);
        pendaftaranSendiriPage.btnSubmit();
        DriverSingleton.delay(2);
        Assert.assertEquals(pendaftaranSendiriPage.getTxtMessage(),"Terjadi kesalahan pada server");
    }
    @Test(dependsOnMethods = "testAtasanInvalid")
    public void testNullNik(){
        pendaftaranSendiriPage.setTestrefresh();
        //WorkInformation
        pendaftaranSendiriPage.setHapusFoto();
        pendaftaranSendiriPage.inputNik("");
        pendaftaranSendiriPage.setUpFile();
        pendaftaranSendiriPage.pilihDivisi("Bank Central Asia");
        pendaftaranSendiriPage.pilihUnit("BCA");
        pendaftaranSendiriPage.pilihTipeKontrak("Magang");
        pendaftaranSendiriPage.pilihPosisiKerja("SQA Analyst");
        pendaftaranSendiriPage.pilihJabatan("Staff");
        pendaftaranSendiriPage.pilihAtasan("Elanda Nur Afwi Desto");
        pendaftaranSendiriPage.pilihAtasan2("test");
        pendaftaranSendiriPage.pilihAtasan3("Koswara");
        //Absensi
        pendaftaranSendiriPage.pilihLokasiKerja("BCA Life");
        pendaftaranSendiriPage.setPilihShift();
        pendaftaranSendiriPage.pilihJadwalKerja("BCA Life");
        pendaftaranSendiriPage.setNonSelfie();
        pendaftaranSendiriPage.jumlahCuti(1);
        pendaftaranSendiriPage.btnSubmit();
        DriverSingleton.delay(2);
    }
    @Test(dependsOnMethods = "testNullNik")
    public void testNullNama(){
        pendaftaranSendiriPage.setTestrefresh();
        //WorkInformation
        pendaftaranSendiriPage.setHapusFoto();
        pendaftaranSendiriPage.inputNama("");
        pendaftaranSendiriPage.setUpFile();
        pendaftaranSendiriPage.pilihDivisi("Bank Central Asia");
        pendaftaranSendiriPage.pilihUnit("BCA");
        pendaftaranSendiriPage.pilihTipeKontrak("Magang");
        pendaftaranSendiriPage.pilihPosisiKerja("SQA Analyst");
        pendaftaranSendiriPage.pilihJabatan("Staff");
        pendaftaranSendiriPage.pilihAtasan("Elanda Nur Afwi Desto");
        pendaftaranSendiriPage.pilihAtasan2("test");
        pendaftaranSendiriPage.pilihAtasan3("Koswara");
        //Absensi
        pendaftaranSendiriPage.pilihLokasiKerja("BCA Life");
        pendaftaranSendiriPage.setPilihShift();
        pendaftaranSendiriPage.pilihJadwalKerja("BCA Life");
        pendaftaranSendiriPage.setNonSelfie();
        pendaftaranSendiriPage.jumlahCuti(1);
        pendaftaranSendiriPage.btnSubmit();
        DriverSingleton.delay(2);
    }
    @Test(dependsOnMethods = "testNullNama")
    public void testNullEmail(){
        pendaftaranSendiriPage.setTestrefresh();
        //WorkInformation
        pendaftaranSendiriPage.setHapusFoto();
        pendaftaranSendiriPage.email("test");
        pendaftaranSendiriPage.setUpFile();
        pendaftaranSendiriPage.pilihDivisi("Bank Central Asia");
        pendaftaranSendiriPage.pilihUnit("BCA");
        pendaftaranSendiriPage.pilihTipeKontrak("Magang");
        pendaftaranSendiriPage.pilihPosisiKerja("SQA Analyst");
        pendaftaranSendiriPage.pilihJabatan("Staff");
        pendaftaranSendiriPage.pilihAtasan("Elanda Nur Afwi Desto");
        pendaftaranSendiriPage.pilihAtasan2("test");
        pendaftaranSendiriPage.pilihAtasan3("Koswara");
        //Absensi
        pendaftaranSendiriPage.pilihLokasiKerja("BCA Life");
        pendaftaranSendiriPage.setPilihShift();
        pendaftaranSendiriPage.pilihJadwalKerja("BCA Life");
        pendaftaranSendiriPage.setNonSelfie();
        pendaftaranSendiriPage.jumlahCuti(1);
        pendaftaranSendiriPage.btnSubmit();
        DriverSingleton.delay(2);
    }
    @Test(dependsOnMethods = "testNullEmail")
    public void testInputValid(){
        pendaftaranSendiriPage.setTestrefresh();
        //WorkInformation
        pendaftaranSendiriPage.setHapusFoto();
        pendaftaranSendiriPage.setUpFile();
        pendaftaranSendiriPage.pilihDivisi("Bank Central Asia");
        pendaftaranSendiriPage.pilihUnit("BCA");
        pendaftaranSendiriPage.pilihTipeKontrak("Magang");
        pendaftaranSendiriPage.pilihPosisiKerja("SQA Analyst");
        pendaftaranSendiriPage.pilihJabatan("Staff");
        pendaftaranSendiriPage.pilihAtasan("Elanda Nur Afwi Desto");
        pendaftaranSendiriPage.pilihAtasan2("test");
        pendaftaranSendiriPage.pilihAtasan3("Koswara");
        //Absensi
        pendaftaranSendiriPage.pilihLokasiKerja("BCA Life");
        pendaftaranSendiriPage.setPilihShift();
        pendaftaranSendiriPage.pilihJadwalKerja("BCA Life");
        pendaftaranSendiriPage.setNonSelfie();
        pendaftaranSendiriPage.jumlahCuti(1);
        pendaftaranSendiriPage.btnSubmit();
        DriverSingleton.delay(2);
        Assert.assertEquals(pendaftaranSendiriPage.getTxtMessage(),"Berhasil edit user");
    }
    @Test(dependsOnMethods = "testInputValid")
    public void updateDiCeklis(){
        pendaftaranSendiriPage.setCeklis();
        pendaftaranSendiriPage.setUpDataDiceklis();
        pendaftaranSendiriPage.divisiCeklis("Bank Central Asia");
        pendaftaranSendiriPage.posisiCeklis("Admin");
        pendaftaranSendiriPage.jabatanCeklis("Direct Sales");
        pendaftaranSendiriPage.atasanCeklis("test123");
        pendaftaranSendiriPage.kontrakCeklis("Magang");
        pendaftaranSendiriPage.locCeklis("Bank Central Asia");
        pendaftaranSendiriPage.setJdwlCeklis("Admin Warung Bukalapak");
        pendaftaranSendiriPage.setBtnSubmitCeklis();
        pendaftaranSendiriPage.setTombolSilang();
        DriverSingleton.delay(4);
        Assert.assertTrue(pendaftaranSendiriPage.setTxtErrMessage().contains("Gagal edit user"));
    }
}
