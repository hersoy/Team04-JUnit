package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_soruCozumu {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3. Login alanine “username" yazdirin
        WebElement loginBox=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");

        //4. Password alanine “password" yazdirin
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");

        //5. Sign in buttonuna tiklayin (sonra back yapın)
        WebElement singInButonu=driver.findElement(By.xpath("//input[@type='submit']"));
        singInButonu.click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
       driver.findElement(By.xpath("//strong[text()=\"Online Banking\"]")).click();
       WebElement payBills=driver.findElement(By.id("pay_bills_link"));
       payBills.click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount=driver.findElement(By.xpath("//input[@id=\"sp_amount\"]"));
        amount.sendKeys("250");

        //8. tarih kismina “2020 0 9 10 yazdirin
        WebElement tarih=driver.findElement(By.id("sp_date"));
        tarih.sendKeys("2020 09 10");

        //9. Pay buttonuna tiklayin
        WebElement payButon=driver.findElement(By.id("pay_saved_payees"));
        payButon.click();


        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement paymentSuccessfully=driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if (paymentSuccessfully.isDisplayed()){
            System.out.println("test PASSED");
        }else {
            System.out.println("test FAİLED");

                }
        driver.close();
    }
}
