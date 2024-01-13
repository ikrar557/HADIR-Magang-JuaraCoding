package TestNG.admin;

import TestNG.TestBase;
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
   @Test(dependsOnMethods = "testValidLogin")
   public void testMenuPendaftaran(){
       pendaftaranSendiriPage.setBtnManagement();
       pendaftaranSendiriPage.setBtnPendaftaran();
       Assert.assertTrue(pendaftaranSendiriPage.getTxtPendaftaran().contains("Pendaftaran Sendiri"));
   }
   @Test(dependsOnMethods = "testMenuPendaftaran")
   public void testSearchByName() {
       pendaftaranSendiriPage.setBtnPilihNikNama();
       pendaftaranSendiriPage.setNama("Aldi Sonic");
       pendaftaranSendiriPage.setBtnCari();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testSearchByName")
   public void testSearchByNik() {
       pendaftaranSendiriPage.setBtnResetCari();
       pendaftaranSendiriPage.setBtnPilihNikNama();
       pendaftaranSendiriPage.setNik("TEST1234");
       pendaftaranSendiriPage.setBtnCari();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testSearchByNik")
   public void testNameByNik(){
       pendaftaranSendiriPage.setBtnResetCari();
       pendaftaranSendiriPage.setBtnPilihNikNama();
       pendaftaranSendiriPage.setNik("Aldi Sonic");
       pendaftaranSendiriPage.setBtnCari();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testNameByNik")
   public void testNikByName(){
       pendaftaranSendiriPage.setBtnResetCari();
       pendaftaranSendiriPage.setBtnPilihNikNama();
       pendaftaranSendiriPage.setNama("D6192283");
       pendaftaranSendiriPage.setBtnCari();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testNikByName")
   public void testBatalFilter(){
       pendaftaranSendiriPage.setBtnResetCari();
       pendaftaranSendiriPage.setBtnFilter();
       pendaftaranSendiriPage.setBatalFilter();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testBatalFilter")
   public void testFilter(){
       pendaftaranSendiriPage.setBtnFilter();
       pendaftaranSendiriPage.setFilterBy();
       pendaftaranSendiriPage.isiIT();
       pendaftaranSendiriPage.setTerapkanFilter();
       pendaftaranSendiriPage.setBtnResetCari();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testFilter")
   public void testPage25(){
       pendaftaranSendiriPage.setDataPerhalaman();
       pendaftaranSendiriPage.setData25();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testPage25")
   public void testPage10(){
       pendaftaranSendiriPage.setDataPerhalaman();
       pendaftaranSendiriPage.setData10();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testPage10")
   public void testPage5(){
       pendaftaranSendiriPage.setDataPerhalaman();
       pendaftaranSendiriPage.setData5();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testPage5")
   public void testNextPage(){
       pendaftaranSendiriPage.setNextPage();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testNextPage")
   public void testPreviousPage(){
       pendaftaranSendiriPage.setPervPage();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testPreviousPage")
   public void testLastPage(){
       pendaftaranSendiriPage.setLastPage();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testLastPage")
   public void testFirstPage(){
       pendaftaranSendiriPage.setFirstPage();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testFirstPage")
   public void testBatalHapusUser(){
       pendaftaranSendiriPage.setBtnHapusUser();
       pendaftaranSendiriPage.setBatalHapus();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testBatalHapusUser")
   public void testHapusUser(){
       pendaftaranSendiriPage.setBtnHapusUser();
       pendaftaranSendiriPage.setYaHapus();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtDataUser(),"Data User Registrasi Mobile");
   }
   @Test(dependsOnMethods = "testMenuPendaftaran")
   public void testUpdateViewButton(){
       pendaftaranSendiriPage.setBtnView();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtEditData(),"Edit User");
   }
   @Test(dependsOnMethods = "testUpdateViewButton")
   public void testUpdateHapusFoto(){
       //WorkInformation
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
       Assert.assertEquals(pendaftaranSendiriPage.getTxtMessage(), "Foto tidak boleh kosong");
   }
   @Test(dependsOnMethods = "testFotoDoc")
   public void testNullNik(){
       pendaftaranSendiriPage.setTestrefresh();
       //WorkInformation
       pendaftaranSendiriPage.setHapusFoto();
       pendaftaranSendiriPage.inputNik("");
       pendaftaranSendiriPage.setUpFile();
       pendaftaranSendiriPage.btnSubmit();
       Assert.assertEquals(pendaftaranSendiriPage.getValidMessageNik(),"Please fill out this field.");
   }

   @Test(dependsOnMethods = "testNullNik")
   public void testNullNama(){
       pendaftaranSendiriPage.setTestrefresh();
       //WorkInformation
       pendaftaranSendiriPage.setHapusFoto();
       pendaftaranSendiriPage.inputNama("");
       pendaftaranSendiriPage.setUpFile();
       pendaftaranSendiriPage.btnSubmit();
       Assert.assertEquals(pendaftaranSendiriPage.getValidMessageName(),"Please fill out this field.");
   }
   @Test(dependsOnMethods = "testNullNama")
   public void testNullEmail(){
       pendaftaranSendiriPage.setTestrefresh();

       //WorkInformation
       pendaftaranSendiriPage.setHapusFoto();
       pendaftaranSendiriPage.setUpFile();
       pendaftaranSendiriPage.email("");
       pendaftaranSendiriPage.btnSubmit();
       Assert.assertEquals(pendaftaranSendiriPage.getValidMessageEmail(),"Please fill out this field.");
   }
   @Test(dependsOnMethods = "testNullEmail")
   public void test1CharNik(){
       pendaftaranSendiriPage.setTestrefresh();
       //WorkInformation
       pendaftaranSendiriPage.setHapusFoto();
       pendaftaranSendiriPage.setUpFile();
       pendaftaranSendiriPage.inputNik("a");
       pendaftaranSendiriPage.btnSubmit();
       Assert.assertEquals(pendaftaranSendiriPage.getValidMessageNik(),"Please lengthen this text to 2 characters or more (you are currently using 1 character).");
   }
   @Test(dependsOnMethods = "test1CharNik")
   public void test1CharNama(){
       pendaftaranSendiriPage.setTestrefresh();
       //WorkInformation
       pendaftaranSendiriPage.setHapusFoto();
       pendaftaranSendiriPage.setUpFile();
       pendaftaranSendiriPage.inputNama("A");
       pendaftaranSendiriPage.btnSubmit();
       Assert.assertEquals(pendaftaranSendiriPage.getValidMessageName(),"Please lengthen this text to 2 characters or more (you are currently using 1 character).");
   }
   @Test(dependsOnMethods = "test1CharNama")
   public void testEmailNoFull(){
       pendaftaranSendiriPage.setTestrefresh();
       //WorkInformation
       pendaftaranSendiriPage.setHapusFoto();
       pendaftaranSendiriPage.setUpFile();
       pendaftaranSendiriPage.email("test");
       pendaftaranSendiriPage.btnSubmit();
       Assert.assertEquals(pendaftaranSendiriPage.getValidMessageEmail(),"Please include an '@' in the email address. 'test' is missing an '@'.");
   }

   @Test(dependsOnMethods = "testEmailNoFull")
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
       Assert.assertEquals(pendaftaranSendiriPage.getTxtMessage(),"Terjadi kesalahan pada server");
   }
   @Test(dependsOnMethods = "testAtasanInvalid")
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
       pendaftaranSendiriPage.setUser();
       Assert.assertEquals(pendaftaranSendiriPage.getTxtBerhasil(),"User");
   }
   @Test(dependsOnMethods = "testInputValid")
   public void updateDiCeklis(){
       pendaftaranSendiriPage.setBtnPendaftaran();
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
       Assert.assertEquals(pendaftaranSendiriPage.setTxtErrMessage(),"Gagal edit user");
   }
}
