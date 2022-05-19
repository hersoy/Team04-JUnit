package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_Nutella {
    // 1 C01_TekrarTesti isimli bir class olusturun
    //2 https://www.google.com/ adresine gidin
    //3 cookies uyarisini kabul ederek kapatin
    //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5 Arama cubuguna “Nutella” yazip aratin
    //6 Bulunan sonuc sayisini yazdirin
    //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8 Sayfayi kapatin

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        // driver.close();
    }

    @Test
    public void test() {
        //2 https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Google")) {
            System.out.println("test PASSED");
        } else {
            System.out.println("test FAİLED");
        }
            //5 Arama cubuguna “Nutella” yazip aratin
            WebElement nutellaAra = driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]"));
            nutellaAra.sendKeys("Nutella"+ Keys.ENTER);

            //6 Bulunan sonuc sayisini yazdirin
            WebElement sonucSayisi=driver.findElement(By.xpath("//div[@id=\"result-stats\"]"));
            System.out.println(sonucSayisi.getText());

            //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        List<WebElement> sonucList=new ArrayList<>(Arrays.asList(sonucSayisi));



    }
}