package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilitis.TestBase;

import java.util.List;

public class C05_TekrarTesti extends TestBase {

    //Test01:
    //1 amazon gidin
    //2 Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    //3 drop down menude 40 eleman olduğunu doğrulayın

    //Test02
    //1 dropdown menuden elektronik bölümü seç in
    //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırı n
    //3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
    //4 ikinci ürüne relative locater kullanarak tıklay in
    //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

    //Test03
    //1 yeni bir sekme açarak amazon a nasayfaya gid in
    //2 dropdown’dan bebek bölümüne secin
    //3 bebek puset aratıp bulundan sonuç sayısını yazdırın
    //4 sonuç yazsının puset içerdiğini te st edin
    //5 üçüncü ürüne relative locater kullanarak tıklay in
    //6 title ve fiyat bilgilerini assign edelim ve ürünü sepete ekley in

    //Test 4
    //1sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


    @Test
    public void test01() {
        //1 amazon gidin
        driver.get("https://www.amazon.com");

        //2 Arama kutusunun solundaki drop down menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownMenu=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(dropDownMenu);
        List<WebElement> ddmListe =select.getOptions();
        ddmListe.stream().map(WebElement::getText).forEach(System.out::println);

        //3- dropdown menude 28 eleman olduğunu doğrulayın
        int actualListe =ddmListe.size();
        int expectedListe=28;
        Assert.assertEquals(expectedListe,actualListe);

    }
    @Test
    public void test02() throws InterruptedException {
        //1- dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com");
        WebElement dropDownMenu=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(dropDownMenu);
        select.selectByVisibleText("Electronics");

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);
        WebElement sonucSayisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));



        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        String aranacakKelime = "iphone";
        Assert.assertTrue(sonucYazisi.contains(aranacakKelime));

        //4 ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        driver.findElement(RelativeLocator.with(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']")).below(ilkUrun)).click();
        Thread.sleep(5000);

        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String title = driver.getTitle();
        WebElement yazı = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-price'])[1]"));
        Assert.assertTrue(yazı.isDisplayed());
        driver.findElement(By.xpath("//a[@title='Add to List']")).click();
    }

    @Test
    public void Test03() {

        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //2- dropdown’dan bebek bölümüne secin
        WebElement dropDownMenu=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(dropDownMenu);
        select.selectByVisibleText("Baby");

        //3- baby stroller aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller"+ Keys.ENTER);


        //4- sonuç yazsının "stroller" içerdiğini test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String actualSonucYazisi=sonucYazisi.getText();
        String arananKelime="stroller";
        Assert.assertTrue(actualSonucYazisi.contains(arananKelime));

        //5- üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ucuncuUrun=driver.findElement(By.xpath("(//img[@class=\"s-image\"])[2]"));
        WebElement dorduncuUrun=driver.findElement(By.xpath("(//img[@class=\"s-image\"])[4]"));
        driver.findElement(RelativeLocator.with(By.className("s-image")).below(ucuncuUrun).above(dorduncuUrun)).click();

        //6- title ve fiyat bilgilerini yazdirin ve ürünü sepete ekleyin
        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String fiyatBilgisi=driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-price\"])[1]")).getText();
        System.out.println("fiyatBilgisi = " + fiyatBilgisi);
        driver.findElement(By.xpath("//*[@id='wishListMainButton']")).click();


    }
}
