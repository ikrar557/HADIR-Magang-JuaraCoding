package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendaftaranSendiriPage {
    private WebDriver driver;

    public PendaftaranSendiriPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    //Management
    @FindBy(xpath = "//body/div[@id='__next']/div[@class='css-10f63sf']/div[@class='MuiBox-root css-k008qs']/div[@class='MuiDrawer-root MuiDrawer-docked css-1tu59u4']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation0 MuiDrawer-paper MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft css-1yw4omu']/div[@data-simplebar='init']/div[@class='simplebar-wrapper']/div[@class='simplebar-mask']/div[@class='simplebar-offset']/div[@aria-label='scrollable content']/div[@class='simplebar-content']/div[@class='MuiBox-root css-10klw3m']/div[@class='sidebar MuiBox-root css-ftf74w']/div[@class='MuiBox-root css-old1by']/div[3]/div[1]/div[1]/div[1]/div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M23.5501 8')]")
    private WebElement btnManagement;
    @FindBy(xpath = "//body/div[@id='__next']/div[@class='css-10f63sf']/div[@class='MuiBox-root css-k008qs']/div[@class='MuiDrawer-root MuiDrawer-docked css-1tu59u4']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation0 MuiDrawer-paper MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft css-1yw4omu']/div[@data-simplebar='init']/div[@class='simplebar-wrapper']/div[@class='simplebar-mask']/div[@class='simplebar-offset']/div[@aria-label='scrollable content']/div[@class='simplebar-content']/div[@class='MuiBox-root css-10klw3m']/div[@class='sidebar MuiBox-root css-ftf74w']/div[@class='MuiBox-root css-old1by']/div[@class='MuiBox-root css-mkf7ch']/div[@class='MuiBox-root css-8atqhb']/div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']/div[@class='MuiCollapse-wrapper MuiCollapse-vertical css-hboir5']/div[@class='MuiCollapse-wrapperInner MuiCollapse-vertical css-8atqhb']/div[@class='MuiBox-root css-uewl2b']/div[3]/div[1]//*[name()='svg']")
    private WebElement btnPendaftaran;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement txtPendaftaran;
    //Search By Name and Nik
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/form/div/div/div[1]/div[1]/div")
    private WebElement btnPilihNikNama;
    @FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[1]")
    private WebElement nama;
    @FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[2]")
    private WebElement nik;
    @FindBy(xpath = "//input[@id='search']")
    private WebElement cari;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnCari;
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement btnResetCari;
    @FindBy(xpath = "//h3[@class='MuiTypography-root MuiTypography-h3 css-uq1m47']")
    private WebElement txtDataUserReg;
    //Filter Data
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/form/div/div/div[4]/button")
    private WebElement btnFilter;
    @FindBy(xpath = "//*[@id=\"mui-component-select-unit_name\"]")
    private WebElement filterBy;
    @FindBy(xpath = "//*[@id=\"menu-unit_name\"]/div[3]/ul/li[21]")
    private WebElement isiIT;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    private WebElement batalFilter;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[2]")
    private WebElement terapkanFilter;
    //Btn Data Perhalaman
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]")
    private WebElement dataPerhalaman;
    @FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[1]")
    private WebElement data5;
    @FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[2]")
    private WebElement data10;
    @FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[3]")
    private WebElement data25;
    //Btn Next, Previous, First, Last Page
    @FindBy(xpath = "//button[@title='Go to next page']//*[name()='svg']")
    private WebElement nextPage;
    @FindBy(xpath = "//button[@title='Go to previous page']//*[name()='svg']")
    private WebElement pervPage;
    @FindBy(xpath = "//button[@title='Go to last page']//*[name()='svg']")
    private WebElement lastPage;
    @FindBy(xpath = "//button[@title='Go to first page']")
    private WebElement firstPage;
    //Update Data Di Ceklis
    @FindBy(xpath = "//tbody/tr[1]/td[1]/span[1]/input[1]")
    private  WebElement ceklis;
    @FindBy(xpath = "//button[normalize-space()='Update dichecklist']")
    private WebElement upDataDiceklis;
    @FindBy(xpath = "//*[@id=\"free-solo-with-text-demo\"]")
    private WebElement divisiCeklis;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/form/div[2]/div/div[2]/div/div/div/input")
    private WebElement posisiCeklis;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/form/div[2]/div/div[3]/div/div/div/input")
    private WebElement jabatanCeklis;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/form/div[2]/div/div[4]/div/div/div/input")
    private WebElement atasanCeklis;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/form/div[2]/div/div[5]/div/div/div/input")
    private WebElement kontrakCeklis;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/form/div[4]/div/div[1]/div/div/div/input")
    private WebElement locCeklis;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/form/div[4]/div/div[3]/div/div/div/input")
    private WebElement jdwlCeklis;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/form/div[5]/div/button")
    private WebElement btnSubmit;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div[1]")
    private WebElement txtErrMessage;
    @FindBy(xpath = "//*[@id=\"alert-dialog-slide-title\"]/button")
    private WebElement tombolSilang;
    //Btn Hapus User
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[10]/button[2]")
    private WebElement btnHapusUser;
    @FindBy (xpath = "/html/body/div[3]/div[3]/div/form/div/div[2]/button[2]")
    private WebElement batalHapus;
    @FindBy (xpath = "/html/body/div[3]/div[3]/div/form/div/div[2]/button[1]")
    private WebElement yaHapus;
    //Update Data btn View
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[10]/button[1]")
    private WebElement btnView;
    @FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1 css-czbdxj']")
    private WebElement txtEditData;
    @FindBy(xpath = "//button[@aria-label='Hapus']//*[name()='svg']")
    private WebElement hapusFoto;
    @FindBy(id = "upload-image")
    private WebElement upFile;
    @FindBy (xpath = "//input[@id='nik']")
    private WebElement inputNik;
    @FindBy(xpath = "//input[@id='fullname']")
    private WebElement inputNama;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='divisi']")
    private WebElement pilihDivisi;
    @FindBy(xpath = "//li[@id='divisi-option-0']")
    private WebElement klikDivisi;
    @FindBy(xpath = "//input[@id='unit']")
    private WebElement pilihUnit;
    @FindBy(xpath = "//li[@id='unit-option-0']")
    private WebElement pUnit;
    @FindBy (xpath = "//input[@id='tipe-kontrak']")
    private WebElement pilihTipeKontrak;
    @FindBy(xpath = "//li[@id='tipe-kontrak-option-0']")
    private WebElement tipeKontrak;
    @FindBy(xpath = "//input[@id='posisi-kerja']")
    private WebElement pilihPosisiKerja;
    @FindBy(xpath = "//li[@id='posisi-kerja-option-0']")
    private WebElement posisiKerja;
    @FindBy(xpath = "//input[@id='jabatan']")
    private WebElement pilihJabatan;
    @FindBy(xpath = "//li[@id='jabatan-option-0']")
    private WebElement pJabatan;
    @FindBy(xpath = "//input[@id='atasan']")
    private WebElement pilihAtasan;
    @FindBy (xpath = "//li[@id='atasan-option-0']")
    private WebElement atasan;
    @FindBy(xpath = "//input[@id='atasan-v2']")
    private WebElement pilihAtasan2;
    @FindBy(xpath = "//li[@id='atasan-v2-option-0']")
    private WebElement atasan2;
    @FindBy(xpath = "//input[@id='atasan-v3']")
    private WebElement pilihAtasan3;
    @FindBy(xpath = "//li[@id='atasan-v3-option-0']")
    private WebElement atasan3;
    @FindBy (xpath = "//input[@id='lokasi-kerja']")
    private WebElement pilihLokasiKerja;
    @FindBy(xpath = "//li[@id='lokasi-kerja-option-0']")
    private WebElement lokasiKerja;

    @FindBy(xpath = "//*[@id=\"tipe-shift\"]")
    private WebElement pilihShift;
    @FindBy(xpath = "//*[@id=\"menu-shift_type\"]/div[3]/ul/li[1]")
    private WebElement shift;
    @FindBy(xpath = "//*[@id=\"menu-shift_type\"]/div[3]/ul/li[2]")
    private WebElement nonShift;
    @FindBy(xpath = "//input[@id='jadwal-kerja']")
    private WebElement pilihJadwalKerja;
    @FindBy(xpath = "//li[@id='jadwal-kerja-option-0']")
    private WebElement jadwalKerja;
    @FindBy(xpath = "//div[@id='required_selfie']")
    private WebElement pilihSelfie;
    @FindBy(xpath = "//*[@id=\"menu-required_selfie\"]/div[3]/ul/li[2]")
    private WebElement nonSelfie;
    @FindBy(xpath = "//input[@id='jumlah-cuti']")
    private WebElement jumlahCuti;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement txtMessage;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div[1]")
    private WebElement user;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement txtUser;
    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container css-1t9m8lh']")
    private WebElement testrefresh;
    public String getValidMessageNik(){
        DriverSingleton.delay(2);
        return inputNik.getAttribute("validationMessage");
    }
    public String getValidMessageName(){
        DriverSingleton.delay(2);
        return inputNama.getAttribute("validationMessage");
    }
    public String getValidMessageEmail(){
        DriverSingleton.delay(2);
        return email.getAttribute("validationMessage");
    }
    public String getTxtBerhasil(){
        DriverSingleton.delay(2);
        return txtUser.getText();
    }
    public void setUser(){
        DriverSingleton.delay(1);
        user.click();
        DriverSingleton.delay(1);
    }
    public void setTestrefresh(){
        DriverSingleton.delay(1);
        driver.navigate().refresh();
        DriverSingleton.delay(1);
    }

    public void setBtnManagement() {
        DriverSingleton.delay(1);
        btnManagement.click();
        DriverSingleton.delay(1);
    }

    public void setBtnPendaftaran() {
        DriverSingleton.delay(1);
        btnPendaftaran.click();
        DriverSingleton.delay(1);
    }

    public String getTxtPendaftaran() {
        DriverSingleton.delay(2);
        return txtPendaftaran.getText();
    }

    public void setBtnPilihNikNama() {
        DriverSingleton.delay(2);
        btnPilihNikNama.click();
        DriverSingleton.delay(2);
    }

    public void setNama(String userReg) {
        DriverSingleton.delay(2);
        nama.click();
        DriverSingleton.delay(2);
        this.cari.sendKeys(userReg);
        DriverSingleton.delay(2);
    }
    public void setNik(String userNik){
        DriverSingleton.delay(2);
        nik.click();
        DriverSingleton.delay(2);
        this.cari.sendKeys(userNik);
        DriverSingleton.delay(2);
    }

    public void setBtnCari() {
        DriverSingleton.delay(2);
        btnCari.click();
        DriverSingleton.delay(2);
    }

    public void setBtnResetCari() {
        DriverSingleton.delay(2);
        btnResetCari.click();
        DriverSingleton.delay(2);
    }
    public void setBtnFilter(){
        DriverSingleton.delay(2);
        btnFilter.click();
        DriverSingleton.delay(2);
    }
    public void setBatalFilter(){
        DriverSingleton.delay(2);
        batalFilter.click();
        DriverSingleton.delay(2);
    }
    public void setFilterBy(){
        DriverSingleton.delay(2);
        filterBy.click();
        DriverSingleton.delay(2);
    }
    public void isiIT(){
        DriverSingleton.delay(2);
        isiIT.click();
        DriverSingleton.delay(2);
    }
    public void setTerapkanFilter(){
        DriverSingleton.delay(2);
        terapkanFilter.click();
        DriverSingleton.delay(2);
    }
    public String getTxtDataUser(){
        DriverSingleton.delay(2);
        return txtDataUserReg.getText();
    }
    public void setDataPerhalaman(){
        DriverSingleton.delay(2);
        dataPerhalaman.click();
        DriverSingleton.delay(2);
    }
    public void setData5(){
        DriverSingleton.delay(2);
        data5.click();
        DriverSingleton.delay(2);
    }
    public void setData10(){
        DriverSingleton.delay(2);
        data10.click();
        DriverSingleton.delay(2);
    }
    public void setData25(){
        DriverSingleton.delay(2);
        data25.click();
        DriverSingleton.delay(2);
    }
    public void setNextPage(){
        DriverSingleton.delay(2);
        nextPage.click();
        DriverSingleton.delay(2);
    }
    public void setPervPage(){
        DriverSingleton.delay(2);
        pervPage.click();
        DriverSingleton.delay(2);
    }
    public void setLastPage(){
        DriverSingleton.delay(2);
        lastPage.click();
        DriverSingleton.delay(2);
    }
    public void setFirstPage(){
        DriverSingleton.delay(2);
        firstPage.click();
        DriverSingleton.delay(2);
    }
    public void setCeklis(){
        DriverSingleton.delay(2);
        ceklis.click();
        DriverSingleton.delay(2);
    }
    public void setBtnHapusUser(){
        DriverSingleton.delay(2);
        btnHapusUser.click();
    }
    public void setBatalHapus(){
        DriverSingleton.delay(2);
        batalHapus.click();
        DriverSingleton.delay(2);
    }
    public void setYaHapus(){
        DriverSingleton.delay(2);
        yaHapus.click();
        DriverSingleton.delay(2);
    }
    public void setBtnView(){
        DriverSingleton.delay(2);
        btnView.click();
        DriverSingleton.delay(2);
    }
    public String getTxtEditData(){
        DriverSingleton.delay(2);
        return txtEditData.getText();
    }
    public void setUpFile(){
        DriverSingleton.delay(2);
        upFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/upFile/foto.jpeg");
        DriverSingleton.delay(2);
    }
    public void setHapusFoto(){
        DriverSingleton.delay(2);
        hapusFoto.click();
        DriverSingleton.delay(2);
    }
    public void upFileDoc(){
        DriverSingleton.delay(2);
        upFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/upFile/doc.txt");
        DriverSingleton.delay(2);
    }
    public void inputNik(String inNik){
        DriverSingleton.delay(2);
        this.inputNik.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.inputNik.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.inputNik.sendKeys(inNik);
        DriverSingleton.delay(2);
    }
    public void inputNama(String inNama){
        DriverSingleton.delay(2);
        this.inputNama.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.inputNama.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.inputNama.sendKeys(inNama);
        DriverSingleton.delay(2);
    }
    public void email(String inputEmail){
        DriverSingleton.delay(2);
        this.email.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.email.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.email.sendKeys(inputEmail);
        DriverSingleton.delay(2);
    }
    public void pilihDivisi(String pDivisi){
        DriverSingleton.delay(2);
        this.pilihDivisi.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.pilihDivisi.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.pilihDivisi.sendKeys(pDivisi);
        DriverSingleton.delay(3);
        klikDivisi.click();
        DriverSingleton.delay(2);
    }
    public void pilihUnit(String units){
        DriverSingleton.delay(2);
        this.pilihUnit.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.pilihUnit.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.pilihUnit.sendKeys(units);
        DriverSingleton.delay(2);
        pUnit.click();
        DriverSingleton.delay(2);
    }
    public void pilihTipeKontrak(String tpKontrak){
        DriverSingleton.delay(2);
        this.pilihTipeKontrak.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.pilihTipeKontrak.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.pilihTipeKontrak.sendKeys(tpKontrak);
        DriverSingleton.delay(2);
        tipeKontrak.click();
        DriverSingleton.delay(2);
    }
    public void pilihPosisiKerja(String posisis){
        DriverSingleton.delay(2);
        this.pilihPosisiKerja.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.pilihPosisiKerja.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.pilihPosisiKerja.sendKeys(posisis);
        DriverSingleton.delay(2);
        posisiKerja.click();
        DriverSingleton.delay(2);
    }
    public void pilihJabatan(String jabatn){
        DriverSingleton.delay(2);
        this.pilihJabatan.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.pilihJabatan.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.pilihJabatan.sendKeys(jabatn);
        DriverSingleton.delay(2);
        pJabatan.click();
        DriverSingleton.delay(2);
    }
    public void pilihAtasan(String atasan1){
        DriverSingleton.delay(2);
        this.pilihAtasan.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.pilihAtasan.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.pilihAtasan.sendKeys(atasan1);
        DriverSingleton.delay(2);
        atasan.click();
        DriverSingleton.delay(2);
    }
    public void atasanFailed(){
        DriverSingleton.delay(2);
        this.pilihAtasan.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.pilihAtasan.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        pilihAtasan.click();
        DriverSingleton.delay(2);
        atasan.click();
        DriverSingleton.delay(2);
    }
    public void pilihAtasan2(String atasanv2){
        DriverSingleton.delay(2);
        this.pilihAtasan2.sendKeys(atasanv2);
        DriverSingleton.delay(2);
        atasan2.click();
        DriverSingleton.delay(2);
    }
    public void pilihAtasan3(String atasanv3){
        DriverSingleton.delay(2);
        this.pilihAtasan3.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.pilihAtasan3.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.pilihAtasan3.sendKeys(atasanv3);
        DriverSingleton.delay(2);
        atasan3.click();
        DriverSingleton.delay(2);
    }
    public void pilihLokasiKerja(String locKerja){
//        DriverSingleton.delay(2);
//        this.pilihLokasiKerja.sendKeys(Keys.CONTROL + "A");
//        DriverSingleton.delay(2);
//        this.pilihLokasiKerja.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.pilihLokasiKerja.sendKeys(locKerja);
        DriverSingleton.delay(2);
        lokasiKerja.click();
        DriverSingleton.delay(2);
    }
    public void setPilihShift(){
        DriverSingleton.delay(2);
        pilihShift.click();
        DriverSingleton.delay(2);
        shift.click();
        DriverSingleton.delay(2);
    }
    public void setNonShift(){
        DriverSingleton.delay(2);
        pilihShift.click();
        DriverSingleton.delay(2);
        nonShift.click();
        DriverSingleton.delay(2);
    }
    public void pilihJadwalKerja(String Jdw){
        DriverSingleton.delay(2);
        this.pilihJadwalKerja.sendKeys(Keys.CONTROL + "A");
        DriverSingleton.delay(2);
        this.pilihJadwalKerja.sendKeys(Keys.DELETE);
        DriverSingleton.delay(2);
        this.pilihJadwalKerja.sendKeys(Jdw);
        DriverSingleton.delay(2);
        jadwalKerja.click();
        DriverSingleton.delay(2);
    }
    public void setNonSelfie(){
        DriverSingleton.delay(2);
        pilihSelfie.click();
        DriverSingleton.delay(2);
        nonSelfie.click();
        DriverSingleton.delay(2);
    }
    public void jumlahCuti(int no){
        DriverSingleton.delay(2);
        jumlahCuti.sendKeys(Keys.ARROW_UP);
        // for (int i = 0; i < ; i++) {
        // }
        DriverSingleton.delay(2);
    }
    public void btnSubmit(){
        DriverSingleton.delay(2);
        submit.click();
        DriverSingleton.delay(2);
    }

    public String getTxtMessage(){
        DriverSingleton.delay(2);
        return txtMessage.getText();
    }

    public void setUpDataDiceklis(){
        DriverSingleton.delay(2);
        upDataDiceklis.click();
        DriverSingleton.delay(2);
    }
    public void divisiCeklis(String inputDivisi){
        DriverSingleton.delay(2);
        this.divisiCeklis.sendKeys(inputDivisi);
        DriverSingleton.delay(2);
        divisiCeklis.sendKeys(Keys.ARROW_DOWN);
        DriverSingleton.delay(2);
        divisiCeklis.sendKeys(Keys.ENTER);
        DriverSingleton.delay(2);
        divisiCeklis.sendKeys(Keys.TAB);
        DriverSingleton.delay(2);
    }
    public void posisiCeklis(String inputPosisi){
        DriverSingleton.delay(2);
        this.posisiCeklis.sendKeys(inputPosisi);
        DriverSingleton.delay(2);
        posisiCeklis.sendKeys(Keys.ARROW_DOWN);
        DriverSingleton.delay(2);
        posisiCeklis.sendKeys(Keys.ENTER);
        DriverSingleton.delay(2);
        posisiCeklis.sendKeys(Keys.TAB);
        DriverSingleton.delay(2);
    }
    public void jabatanCeklis(String inputJabatan) {
        DriverSingleton.delay(2);
        this.jabatanCeklis.sendKeys(inputJabatan);
        DriverSingleton.delay(2);
        jabatanCeklis.sendKeys(Keys.ARROW_DOWN);
        DriverSingleton.delay(2);
        jabatanCeklis.sendKeys(Keys.ENTER);
        DriverSingleton.delay(2);
        jabatanCeklis.sendKeys(Keys.TAB);
        DriverSingleton.delay(2);
    }
    public void atasanCeklis(String inputAtasan) {
        DriverSingleton.delay(2);
        this.atasanCeklis.sendKeys(inputAtasan);
        DriverSingleton.delay(2);
        atasanCeklis.sendKeys(Keys.ARROW_DOWN);
        DriverSingleton.delay(2);
        atasanCeklis.sendKeys(Keys.ENTER);
        DriverSingleton.delay(2);
        atasanCeklis.sendKeys(Keys.TAB);
        DriverSingleton.delay(2);
    }
    public void kontrakCeklis(String inputKontrak) {
        DriverSingleton.delay(2);
        this.kontrakCeklis.sendKeys(inputKontrak);
        DriverSingleton.delay(2);
        kontrakCeklis.sendKeys(Keys.ARROW_DOWN);
        DriverSingleton.delay(2);
        kontrakCeklis.sendKeys(Keys.ENTER);
        DriverSingleton.delay(2);
        kontrakCeklis.sendKeys(Keys.TAB);
        DriverSingleton.delay(2);
    }
    public void locCeklis(String inputLocCeklis) {
        DriverSingleton.delay(2);
        this.locCeklis.sendKeys(inputLocCeklis);
        DriverSingleton.delay(2);
        locCeklis.sendKeys(Keys.ARROW_DOWN);
        DriverSingleton.delay(2);
        locCeklis.sendKeys(Keys.ENTER);
        DriverSingleton.delay(2);
        locCeklis.sendKeys(Keys.TAB);
        DriverSingleton.delay(2);
    }
    public void setJdwlCeklis(String inputJadwal) {
        DriverSingleton.delay(2);
        this.jdwlCeklis.sendKeys(inputJadwal);
        DriverSingleton.delay(2);
        jdwlCeklis.sendKeys(Keys.ARROW_DOWN);
        DriverSingleton.delay(2);
        jdwlCeklis.sendKeys(Keys.ENTER);
        DriverSingleton.delay(2);
        jdwlCeklis.sendKeys(Keys.TAB);
        DriverSingleton.delay(2);
    }
    public void setBtnSubmitCeklis(){
        DriverSingleton.delay(2);
        btnSubmit.click();
        DriverSingleton.delay(2);
    }
    public String setTxtErrMessage(){
        DriverSingleton.delay(2);
        return txtErrMessage.getText();
    }
    public void setTombolSilang(){
        DriverSingleton.delay(2);
        tombolSilang.click();
        DriverSingleton.delay(2);
    }
}