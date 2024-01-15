package com.juaracoding;

import com.juaracoding.pages.admin.PendaftaranSendiriPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PendaftaranSendiriTest {
    private static WebDriver driver;
    private static ExtentTest extentTest;
    public static PendaftaranSendiriPage pendaftaranSendiriPage = new PendaftaranSendiriPage();

    public PendaftaranSendiriTest() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }
    @Given("Admin go to menu management")
    public void admin_go_to_menu_management(){
        pendaftaranSendiriPage.setBtnManagement();
        extentTest.log(LogStatus.PASS,"Admin go to menu management ");
    }
    @And("go to pendaftaran sendiri")
    public void go_to_pendaftaran_sendiri(){
        pendaftaranSendiriPage.setBtnPendaftaran();
        extentTest.log(LogStatus.PASS,"go to pendaftaran sendiri");
    }
    @Then("page pendaftaran sendiri")
    public void page_pendaftaran_sendiri(){
        Assert.assertEquals(pendaftaranSendiriPage.getTxtPendaftaran(),"Pendaftaran Sendiri");
        extentTest.log(LogStatus.PASS,"page pendaftaran sendiri");
    }
    @Given("Search by name")
    public void search_by_name(){
        pendaftaranSendiriPage.setBtnPilihNikNama();
        extentTest.log(LogStatus.PASS,"Search by name");
    }
    @When("admin iputkan nama user")
    public void admin_inputkan_nama_user(){
        pendaftaranSendiriPage.setNama("Aldi Sonic");
        extentTest.log(LogStatus.PASS,"admin iputkan nama user");
    }
    @And("admin klik btn search")
    public void admin_klik_btn_search(){
        pendaftaranSendiriPage.setBtnCari();
        extentTest.log(LogStatus.PASS,"admin klik btn search");
    }
    @Then("data tampil")
    public void data_tampil(){
        Assert.assertTrue(pendaftaranSendiriPage.getTxtDataUser().contains("Data User Registrasi Mobile"));
        extentTest.log(LogStatus.PASS,"data tampil");
    }
    @And("Reset Search")
    public void reset_search(){
        pendaftaranSendiriPage.setBtnResetCari();
        extentTest.log(LogStatus.PASS,"Reset Search");
    }
    @And("Search by nik")
    public void search_by_nik(){
        pendaftaranSendiriPage.setBtnPilihNikNama();
        extentTest.log(LogStatus.PASS,"Search by nik");
    }
    @And("admin inputkan nik user")
    public void admin_inputkan_nik_user(){
        pendaftaranSendiriPage.setNik("Aldi Sonic");
        extentTest.log(LogStatus.PASS,"admin inputkan nik user");
    }
    @And("inputkan nama user")
    public void inputkan_nama_user(){
        pendaftaranSendiriPage.setNik("Aldi Sonic");
        extentTest.log(LogStatus.PASS,"inputkan nama user");
    }
    @And("inputkan nik user")
    public void inputkan_nik_user(){
        pendaftaranSendiriPage.setNama("Test1234");
        extentTest.log(LogStatus.PASS,"inputkan nik user");
    }
    @And("klik btn Filter")
    public void klik_btn_filter(){
        pendaftaranSendiriPage.setBtnFilter();
        extentTest.log(LogStatus.PASS,"klik btn Filter");
    }
    @And("klik batal filter")
    public void klik_batal_filter(){
        pendaftaranSendiriPage.setBatalFilter();
        extentTest.log(LogStatus.PASS,"klik batal filter");
    }
    @And("pilih filter by")
    public void pilih_filter_by(){
        pendaftaranSendiriPage.setFilterBy();
        extentTest.log(LogStatus.PASS,"pilih filter by");
    }
    @And("klik IT")
    public void klik_it(){
        pendaftaranSendiriPage.isiIT();
        extentTest.log(LogStatus.PASS,"klik IT");
    }
    @And("Terapkan")
    public void terapkan(){
        pendaftaranSendiriPage.setTerapkanFilter();
        extentTest.log(LogStatus.PASS,"Terapkan");
    }

    @And("Klik btn data perhalaman")
    public void klik_btn_data_perhalaman(){
        pendaftaranSendiriPage.setDataPerhalaman();
        extentTest.log(LogStatus.PASS,"Klik btn data perhalaman");
    }
    @And("klik 25")
    public void klik_25(){
        pendaftaranSendiriPage.setData10();
        extentTest.log(LogStatus.PASS,"klik 25");
    }
    @And("klik 10")
    public void klik_10(){
        pendaftaranSendiriPage.setData10();
        extentTest.log(LogStatus.PASS,"klik 10");
    }
    @And("klik 5")
    public void klik_5(){
        pendaftaranSendiriPage.setData10();
        extentTest.log(LogStatus.PASS,"klik 5");
    }
    @And("Klik next page")
    public void klik_next_page(){
        pendaftaranSendiriPage.setNextPage();
        extentTest.log(LogStatus.PASS,"Klik next page");
    }
    @And("Klik previous page")
    public void klik_previous_page(){
        pendaftaranSendiriPage.setPervPage();
        extentTest.log(LogStatus.PASS,"Klik previous page");
    }
    @And("Klik last page")
    public void klik_last_page(){
        pendaftaranSendiriPage.setLastPage();
        extentTest.log(LogStatus.PASS,"Klik last page");
    }
    @And("Klik first page")
    public void klik_first_page(){
        pendaftaranSendiriPage.setFirstPage();
        extentTest.log(LogStatus.PASS,"Klik first page");
    }
    @And("klik tombol hapus user")
    public void klik_tombol_hapus_user(){
        pendaftaranSendiriPage.setBtnHapusUser();
        extentTest.log(LogStatus.PASS,"klik tombol hapus user");
    }
    @And("klik tombol batal")
    public void klik_tombol_batal(){
        pendaftaranSendiriPage.setBatalHapus();
        extentTest.log(LogStatus.PASS,"klik tombol batal");
    }
    @And("klik tombol ya")
    public void klik_tombol_ya(){
        pendaftaranSendiriPage.setYaHapus();
        extentTest.log(LogStatus.PASS,"klik tombol ya");
    }
    @And("ceklis user")
    public void ceklis_user(){
        pendaftaranSendiriPage.setCeklis();
        extentTest.log(LogStatus.PASS,"ceklis user");
    }
    @And("klik tombol view button")
    public void klik_tombol_view_button(){
        pendaftaranSendiriPage.setBtnView();
        extentTest.log(LogStatus.PASS,"klik tombol view button");
    }
    @Then("berada di tab user")
    public void berada_di_tab_user(){
        Assert.assertEquals(pendaftaranSendiriPage.getTxtEditData(),"Edit User");
        extentTest.log(LogStatus.PASS,"berada di tab user");
    }
    @When("Hapus foto karyawan")
    public void hapus_foto(){
        pendaftaranSendiriPage.setHapusFoto();
        extentTest.log(LogStatus.PASS,"Hapus foto karyawan");
    }
    @And("pilih divisi")
    public void pilih_divisi(){
        pendaftaranSendiriPage.pilihDivisi("Bank Central Asia");
        extentTest.log(LogStatus.PASS,"pilih divis");
    }
    @And("pilih unit")
    public void pilih_unit(){
        pendaftaranSendiriPage.pilihUnit("BCA");
        extentTest.log(LogStatus.PASS,"pilih unit");
    }
    @And("pilih tipe kontrak")
    public void pilih_tipe_kontrak(){
        pendaftaranSendiriPage.pilihTipeKontrak("Magang");
        extentTest.log(LogStatus.PASS,"pilih tipe kontrak");
    }
    @And("pilih posisi kerja")
    public void pilih_posisi_kerja(){
        pendaftaranSendiriPage.pilihPosisiKerja("SQA Analyst");
        extentTest.log(LogStatus.PASS,"pilih posisi kerja");
    }
    @And("pilih jabatan")
    public void pilih_jabatan(){
        pendaftaranSendiriPage.pilihJabatan("Staff");
        extentTest.log(LogStatus.PASS,"pilih jabatan");
    }
    @And("pilih atasan1")
    public void pilih_atasan1(){
        pendaftaranSendiriPage.pilihAtasan("Elanda Nur Afwi Desto");
        extentTest.log(LogStatus.PASS,"pilih atasan1");
    }
    @And("pilih atasan2")
    public void pilih_atasan2(){
        pendaftaranSendiriPage.pilihAtasan2("test");
        extentTest.log(LogStatus.PASS,"pilih atasan2");
    }
    @And("pilih atasan3")
    public void pilih_atasan3(){
        pendaftaranSendiriPage.pilihAtasan3("Koswara");
        extentTest.log(LogStatus.PASS,"pilih3atasan3");
    }
    @And("pilih lokasi kerja")
    public void pilih_lokasi_kerja(){
        pendaftaranSendiriPage.pilihLokasiKerja("BCA Life");
        extentTest.log(LogStatus.PASS,"pilih lokasi kerja");
    }
    @And("pilih tipe shift")
    public void pilih_tipe_shift(){
        pendaftaranSendiriPage.setPilihShift();
        extentTest.log(LogStatus.PASS,"pilih tipe shift");
    }
    @And("pilih jadwal kerja")
    public void pilih_jadwal_kerja(){
        pendaftaranSendiriPage.pilihJadwalKerja("BCA Life");
        extentTest.log(LogStatus.PASS,"pilih jadwal kerja");
    }
    @And("pilih selfie")
    public void pilih_selfie(){
        pendaftaranSendiriPage.setNonSelfie();
        extentTest.log(LogStatus.PASS,"pilih selfie");
    }
    @And("input jumlah cuti")
    public void input_jumlah_cuti(){
        pendaftaranSendiriPage.jumlahCuti(1);
        extentTest.log(LogStatus.PASS,"input jumlah cuti");
    }
    @And("klik submit")
    public void submit(){
        pendaftaranSendiriPage.btnSubmit();
        extentTest.log(LogStatus.PASS,"submit");
    }
    @Then("pemberitahuan1")
    public void pemberitahuan1(){
        Assert.assertEquals(pendaftaranSendiriPage.getTxtMessage(), "Foto tidak boleh kosong");
        extentTest.log(LogStatus.PASS,"pemberitahuan1");
    }
    @Then("pemberitahuan2")
    public void pemberitahuan2(){
        Assert.assertEquals(pendaftaranSendiriPage.getValidMessageNik(),"Please fill out this field.");
        extentTest.log(LogStatus.PASS,"pemberitahuan2");
    }
    @Then("pemberitahuan3")
    public void pemberitahuan3(){
        Assert.assertEquals(pendaftaranSendiriPage.getValidMessageName(),"Please fill out this field.");
        extentTest.log(LogStatus.PASS,"pemberitahuan3");
    }
    @Then("pemberitahuan4")
    public void pemberitahuan4(){
        Assert.assertEquals(pendaftaranSendiriPage.getValidMessageEmail(),"Please fill out this field.");
        extentTest.log(LogStatus.PASS,"pemberitahuan4");
    }
    @Then("pemberitahuan5")
    public void pemberitahuan5(){
        Assert.assertEquals(pendaftaranSendiriPage.getValidMessageNik(),"Please lengthen this text to 2 characters or more (you are currently using 1 character).");
        extentTest.log(LogStatus.PASS,"pemberitahuan5");
    }
    @Then("pemberitahuan6")
    public void pemberitahuan6(){
        Assert.assertEquals(pendaftaranSendiriPage.getValidMessageName(),"Please lengthen this text to 2 characters or more (you are currently using 1 character).");
        extentTest.log(LogStatus.PASS,"pemberitahuan6");
    }
    @Then("pemberitahuan7")
    public void pemberitahuan7(){
        Assert.assertEquals(pendaftaranSendiriPage.getValidMessageEmail(),"Please include an '@' in the email address. 'test' is missing an '@'.");
        extentTest.log(LogStatus.PASS,"pemberitahuan7");
    }
    @Then("pemberitahuan8")
    public void pemberitahuan8(){
        Assert.assertEquals(pendaftaranSendiriPage.getTxtMessage(),"Terjadi kesalahan pada server");
        extentTest.log(LogStatus.PASS,"pemberitahuan8");
    }
    @Then("pemberitahuan9")
    public void pemberitahuan9(){
        Assert.assertEquals(pendaftaranSendiriPage.getTxtBerhasil(),"User");
        extentTest.log(LogStatus.PASS,"pemberitahuan9");
    }

    @And("upload file foto")
    public void upload_file_foto(){
        pendaftaranSendiriPage.setUpFile();
        extentTest.log(LogStatus.PASS,"upload file foto");
    }
    @And("refresh page")
    public void refresh_page(){
        pendaftaranSendiriPage.setTestrefresh();
        extentTest.log(LogStatus.PASS,"refresh page");
    }
    @And("upload file doc")
    public void upload_file_doc(){
        pendaftaranSendiriPage.upFileDoc();
        extentTest.log(LogStatus.PASS,"upload file doc");
    }
    @And("kosongkan nik")
    public void kosongkan_nik(){
        pendaftaranSendiriPage.inputNik("");
        extentTest.log(LogStatus.PASS,"kosongkan nik");
    }
    @And("kosongkan nama")
    public void kosongkan_nama(){
        pendaftaranSendiriPage.inputNama("");
        extentTest.log(LogStatus.PASS,"kosongkan nama");
    }
    @And("kosongkan email")
    public void kosongkan_email(){
        pendaftaranSendiriPage.email("");
        extentTest.log(LogStatus.PASS,"kosongkan email");
    }
    @And("isi nik 1 huruf")
    public void isi_nik_1_huruf(){
        pendaftaranSendiriPage.inputNik("A");
        extentTest.log(LogStatus.PASS,"isi nik 1 huruf");
    }
    @And("isi nama 1 huruf")
    public void isi_nama_1_huruf(){
        pendaftaranSendiriPage.inputNama("B");
        extentTest.log(LogStatus.PASS,"isi nama 1 huruf");
    }
    @And("inputkan email tanpa et")
    public void inputkan_email_tanpa_et(){
        pendaftaranSendiriPage.email("test");
        extentTest.log(LogStatus.PASS,"inputkan email tanpa et");
    }
    @And("pilih atasan sesuai user")
    public void pilih_atasan_sesuai_user(){
        pendaftaranSendiriPage.atasanFailed();
        extentTest.log(LogStatus.PASS,"pilih atasan sesuai user");
    }
    @And("klik user")
    public void klik_user(){
        pendaftaranSendiriPage.setUser();
        extentTest.log(LogStatus.PASS,"klik user");
    }
    @And("klik btn update data diceklis")
    public void klik_btn_update_data_diceklis(){
        pendaftaranSendiriPage.setUpDataDiceklis();
        extentTest.log(LogStatus.PASS,"klik btn update data diceklis");
    }
    @And("isi divisi")
    public void isi_divisi(){
        pendaftaranSendiriPage.divisiCeklis("Bank Central Asia");
        extentTest.log(LogStatus.PASS,"isi divisi");
    }
    @And("isi posisi")
    public void isi_posisi(){
        pendaftaranSendiriPage.posisiCeklis("Admin");
        extentTest.log(LogStatus.PASS,"isi posisi");
    }
    @And("isi jabatan")
    public void isi_jabatan(){
        pendaftaranSendiriPage.jabatanCeklis("Direct Sales");
        extentTest.log(LogStatus.PASS,"isi jabatan");
    }
    @And("isi atasan")
    public void isi_atasan(){
        pendaftaranSendiriPage.atasanCeklis("Elanda Nur Afwi Desto");
        extentTest.log(LogStatus.PASS,"isi atasan");
    }
    @And("isi kontrak")
    public void isi_kontrak(){
        pendaftaranSendiriPage.kontrakCeklis("Magang");
        extentTest.log(LogStatus.PASS,"isi kontrak");
    }
    @And("isi lokasi")
    public void isi_lokasi(){
        pendaftaranSendiriPage.locCeklis("Bank Central Asia");
        extentTest.log(LogStatus.PASS,"isi lokasi");
    }
    @And("isi jadwal")
    public void isi_jadwal(){
        pendaftaranSendiriPage.setJdwlCeklis("Admin Warung Bukalapak");
        extentTest.log(LogStatus.PASS,"isi_jadwal");
    }
    @And("klik btn submit")
    public void klik_btn_submit(){
        pendaftaranSendiriPage.setBtnSubmitCeklis();
        extentTest.log(LogStatus.PASS,"klik btn submit");
    }
    @Then("pemberitahuan edit")
    public void pemberitahuan_edit(){
        Assert.assertEquals(pendaftaranSendiriPage.setTxtErrMessage(),"Gagal edit user");
        extentTest.log(LogStatus.PASS,"pemberitahuan edit");
    }
    @And("klik silang")
    public void klik_silang(){
        pendaftaranSendiriPage.setTombolSilang();
        extentTest.log(LogStatus.PASS,"klik silang");
    }
}
