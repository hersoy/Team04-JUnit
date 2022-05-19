package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleAlert {

    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //      “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @After
    public void tearDown(){
          driver.close();
    }

    @Test
    public void acceptAlert() {
        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //      “You successfully clicked an alert” oldugunu test edin.

        WebElement birinciButon = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        birinciButon.click();
        driver.switchTo().alert().accept();

        String resultYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, resultYazisi);
    }
    @Test
    public void dismissAlert(){
        //● Bir metod olusturun: dismissAlert
        //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //      “successfuly” icermedigini test edin.

        WebElement ikinciButon=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        ikinciButon.click();
        driver.switchTo().alert().dismiss();

        String resultMetni = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String istenmeyenKelime="successfuly";
        Assert.assertFalse(resultMetni.contains(istenmeyenKelime));

        }
    @Test
    public void sendKeysAlert() {
        //● Bir metod olusturun: sendKeysAlert
        //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        WebElement ucuncuButon=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        ucuncuButon.click();
        driver.switchTo().alert().sendKeys("Hamza Ersoy");
        driver.switchTo().alert().accept();

        String actualResort=driver.findElement(By.xpath("//*[.='You entered: Hamza Ersoy']")).getText();
        String expectedResult="Hamza Ersoy";
        Assert.assertTrue(actualResort.contains(expectedResult));





    }
    }



