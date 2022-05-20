package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitis.TestBase;

public class C01_Actions extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        // amazon ana sayfaya gidip
        // account menusunden create a list linkine tiklayin

        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement accoundElementi=driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        actions.moveToElement(accoundElementi).perform();

        driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();

        Thread.sleep(3000);




    }
}
