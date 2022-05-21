package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitis.TestBase;

public class C01_PageDown extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // 1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));
        driver.switchTo().frame(iframe);
        WebElement playTusu=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        playTusu.click();

        //5- videoyu calistirdiginizi test edin
        WebElement youtubeYazisi=driver.findElement(By.xpath("//a[@class=\"ytp-youtube-button ytp-button yt-uix-sessionlink\"]"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());


    }
}
