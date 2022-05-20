package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitis.TestBase;

import java.util.Set;

public class C02_ActionsMause extends TestBase {

    //1- Yeni bir class olusturalim: MouseActions1
    //2- https://the internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim


    @Test
    public void mauseActions1() {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement ciziliAlan=driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(ciziliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualalertYazi=driver.switchTo().alert().getText();
        String expectedalertYazi="You selected a context menu";
        Assert.assertEquals(expectedalertYazi,actualalertYazi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();

        Set<String> tumSayfaHandleDeg=driver.getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each:tumSayfaHandleDeg
             ) {
            if(!each.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=each;
            }
        }

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaHandle);
        WebElement h1TagiYazisi=driver.findElement(By.tagName("h1"));

        String actualH1Tagi=h1TagiYazisi.getText();
        String expectedH1Tagi="Elemental Selenium";
        Assert.assertEquals(expectedH1Tagi,actualH1Tagi);


    }
}
