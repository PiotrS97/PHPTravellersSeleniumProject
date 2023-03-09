import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SignUpTest extends BaseTest{
    @Test
    public void signUpTest(){

        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys("Piotr");
        driver.findElement(By.name("lastname")).sendKeys("Szatkowski");
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.name("email")).sendKeys("abc"+ System.currentTimeMillis() +"@cbz.pl");
        driver.findElement(By.name("password")).sendKeys("pass123");
        driver.findElement(By.name("confirmpassword")).sendKeys("pass123");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//h3[@class='RTL']")).getText()
        , "Hi, Piotr Szatkowski");
    }
}
