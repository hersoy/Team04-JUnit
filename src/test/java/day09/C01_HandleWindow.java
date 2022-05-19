package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindow {

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

        // 1- amazonana sayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandDeg =driver.getWindowHandle();

        // 2- Url'nin amazon icerdigini test edelim
        String actualUrl=driver.getCurrentUrl();
        String expectedWord="amazon";
        Assert.assertTrue(actualUrl.contains(expectedWord));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        // 4- title'nin Best Buy icerdigini test edelim
        String actualTitle=driver.getTitle();
        String expectedWord2="Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedWord2));

        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaWindowHandDeg);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);

    }
}