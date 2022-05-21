package day11;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitis.TestBase;

public class C03_UploadFiles extends TestBase {

    //1.Tests packagenin altina bir class oluşturun : C05_ UploadFile
    //2. https://the-internet.herokuapp.com/upload adresine gidelim
    //3. chooseFile butonuna basalim
    //4. Yuklemek istediginiz dosyayi secelim
    //5. Upload butonuna bas alim
    //6. “File Uploaded!” textinin goruntulendigini test edelim


    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/upload");

        // 1.adim cjhoose file butonunu locate edelim
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));


        // 2.adim yuklenecek doyanin dosya yolunu olusturalim
        //   biz masaustundeki text.txt dosyasini yukleyelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim=("\\Desktop\\text.txt");
        String tumDosya=farkliKisim+ortakKisim;

        // 3. adim sendKeys ile dosya yolunu, secme butonuna yollayalim
        dosyaSecButonu.sendKeys(tumDosya);

        //Upload butonuna basalim.
        WebElement uploadButon=driver.findElement(By.id("file-submit"));
        uploadButon.click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim
        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());








    }
}
