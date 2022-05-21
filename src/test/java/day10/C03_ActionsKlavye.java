package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitis.TestBase;

import java.security.Key;

public class C03_ActionsKlavye extends TestBase {

    // facebook ana sayfaya gidip
    // yeni kayit olustur butonuna basin
    // isim kutusunu locate edip,
    // geriye kalan alanlari TAB ile dolasarak formu doldurun


    @Test
    public void test01() {
        driver.get("https://www.facebook.com");
        WebElement hesapOlusturButonu=driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]"));
        hesapOlusturButonu.click();

        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.click(isimKutusu).sendKeys("Furkan").sendKeys(Keys.TAB).
                sendKeys("Ersoy").sendKeys(Keys.TAB).
                sendKeys("ersoy@gmail.com").sendKeys(Keys.TAB).
                sendKeys("ersoy@gmail.com").sendKeys(Keys.TAB).
                sendKeys("123456").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("21").sendKeys(Keys.TAB).
                sendKeys("may").sendKeys(Keys.TAB).
                sendKeys("1990").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();


    }
}
