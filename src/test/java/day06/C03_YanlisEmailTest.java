package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_YanlisEmailTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void yanlisEmailTest() {
        //1- http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");

        //2- Sign in butonuna basalim
       driver.findElement(By.xpath("//a[@title=\"Log in to your customer account\"]")).click();

        //3- Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        WebElement mailKutusu=driver.findElement(By.xpath("//input[@id=\"email_create\"]"));
        mailKutusu.sendKeys("alivel.gmail.com"+ Keys.ENTER);

        WebElement uyari = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyari.isDisplayed());


    }






}
