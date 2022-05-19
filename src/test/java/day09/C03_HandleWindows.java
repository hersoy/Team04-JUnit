package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_HandleWindows {

    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandleDeg=driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaText=driver.findElement(By.xpath("//h3"));
        String actualText=sayfaText.getText();
        String expectedText="Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.
        WebElement clickHereButon=driver.findElement(By.linkText("Click Here"));
        clickHereButon.click();

        Set<String>tumSayfaWindowHandleDeg=driver.getWindowHandles();
        System.out.println(ilkSayfaWindowHandleDeg);
        System.out.println(tumSayfaWindowHandleDeg);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String ikinciSayfaWindowHandleDeg="";
        for (String each:tumSayfaWindowHandleDeg
             ) {
            if (!each.equals(ilkSayfaWindowHandleDeg)){
                ikinciSayfaWindowHandleDeg=each;
            }
        }
       driver.switchTo().window(ikinciSayfaWindowHandleDeg).switchTo();
       String actualTitleYeni=driver.getTitle();
       String expectedTitleYeni="New Window";
       Assert.assertEquals(expectedTitleYeni,actualTitleYeni);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement sayfaTextYazisi=driver.findElement(By.xpath("(//*[.='New Window'])[2]"));
        String actualTextYazisi=sayfaTextYazisi.getText();
        String expectedTextYazisi="New Window";
        Assert.assertEquals(expectedTextYazisi,actualTextYazisi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın
       driver.switchTo().window(ilkSayfaWindowHandleDeg);
        actualTitle= driver.getTitle();
        expectedTitle="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);



    }

}
