import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceDemoTests {
    private WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofNanos(10));
    }

    //@Test
    public void testLoginInsideSauceDemo(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        String url = driver.getCurrentUrl();
        String urlExpected = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(urlExpected, url);
    }

    @Test
    public void testLoginWithoutUsername(){
        driver.get("https://www.saucedemo.com/");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String text = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals("Epic sadface: Username is required", text);
    }
}
