package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assrtions {

      /*
    amazon ana sayfaya gidin
    3 farkli tet metodu olusturarak asagidaki gorevleri yapin;
        1- url'in amazon icerdigini test edin
        2- title'nin facebook icermedigini test edin
        3- sol ust kosede amazon logosunu gorundugunu test edin
      */


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

        @AfterClass
    public static void tearDown(){
        driver.close();

    }
    @Test
    public void test1(){
        // 1- url'in amazon icerdigini test edin
        String arananKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));
    }
    @Test
    public void test2(){
      //  2- title'nin facebook icermedigini test edin
        String arananTitle="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(arananTitle));
    }
    @Test
    public void test3(){
        //  3- sol ust kosede amazon logosunu gorundugunu test edin
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }

}
