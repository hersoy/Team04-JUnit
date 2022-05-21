package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitis.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExist extends TestBase {

    //1. Tests packagenin altina bir class oluşturalim
    ///1. Tests packagenin altina bir class oluşturalim
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. dumy.txt dosyasını indirelim
    //4. dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void test01() {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. dumy.txt dosyasını indirelim
        WebElement dummyLinki =driver.findElement(By.xpath("//a[@href=\"download/dummy.txt\"]"));
        dummyLinki.click();

        //4. dosyanın başarıyla indirilip indirilmediğini test edelim

        String fakliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\dummy.txt";
        String tamDosyaYolu=fakliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(tamDosyaYolu)));

    }
}
