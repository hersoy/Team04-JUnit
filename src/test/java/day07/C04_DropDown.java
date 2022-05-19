package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class C04_DropDown {

    // ●Bir class oluşturun: C3_ DropDown Amazon
    // ●https://www.amazon.com/ adresine gidin.
    //-
    //Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    //-
    //Test 2
    //1.
    //Kategori menusunden Books secenegini secin
    //2.
    //Arama kutusuna Java yazin ve aratin
    //3.
    //Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;

    @Before
    public void setup(){
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
        driver.get("https://www.amazon.com/");
       //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement aramaKutusu=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(aramaKutusu);
        int elemanSayisi=select.getOptions().size();
        int expectedSayi=28;
        Assert.assertEquals("test FAILED",expectedSayi,elemanSayisi);


        //Kategori menusunden Books secenegini secin
        select.selectByIndex(5);

        //Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucSayisi.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        String istenenKelime="Java";
        String actualKelime=sonucSayisi.getText();
        Assert.assertTrue(actualKelime.contains(istenenKelime));


    }
}
