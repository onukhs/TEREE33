import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SdaWebPagetests {

    private WebDriver driver;

    @Test
    public void TestPrintSDAcademyTitleOnConsole(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://sdacademy.dev/");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.navigate().forward();
    }
}
