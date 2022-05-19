package day07;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_HandleDropDown {

    /*
        amazon'a gidip
       dropdown'dan books secenegini secip
       Java aratalim
       ve arama sonuclarinin Java icerdigini test edelim
     */
    WebDriver driver;

    @Before
    public void sutup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
    driver.get("https://www.amazon.com");
    // dropdown icin
        // önce lacete edilir
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // sonra select objesi olusturulur
        Select select=new Select(dropDownMenu);
        // select classından 3 secenekten birisi secilir( bu 3 secenek asagidaki gibi yapılır fakat birisi kullanilir)
        select.selectByVisibleText("Bebek");
        // select.selectByIndex(3);
        // select.selectByValue("search-alias=baby-products-intl-ship");

        // Java aratalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edelim
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[text()=\"için 48 sonuç arasından 1-24\"]"));
        String arananKelime="Java";
        String sonucYazisi=aramaSonucu.getText();
        Assert.assertTrue(sonucYazisi.contains(arananKelime));

    }

}
