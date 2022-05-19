package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindow {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {

       //● Amazon anasayfa adresine gidin.
       driver.get("https://www.amazon.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHamdle=driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");

        //● Sayfa title’nin “TECHPROEDUCATION” icermedigini test edin
        String actualTitleTehPrEdc=driver.getTitle();
        String istenenTitle="TECHPROEDUCATION";
        Assert.assertFalse(actualTitleTehPrEdc.contains(istenenTitle));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitleWalWart=driver.getTitle();
        String arananTitle="Walmart";
        Assert.assertTrue(actualTitleWalWart.contains(arananTitle));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHamdle);
        System.out.println();

    }

}
