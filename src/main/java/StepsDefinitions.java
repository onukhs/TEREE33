import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class StepsDefinitions {

    private WebDriver driver = BrowserSetup.getDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("I click on Login button")
    public void i_click_on_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be logged in")
    public void i_should_logged_in() {
        driver.findElement(By.id("shopping_cart_container"));
    }

    @When("I enter invalid {} and valid password")
    public void i_enter_invalid_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("I should not be logged in")
    public void i_should_not_be_logged_in() {
        driver.findElement(By.id("login-button"));
    }

    @Then("Error message {} should be displayed")
    public void error_message_should_be_displayed(String error) {
        driver.findElement(By.xpath(".//*[contains(text(), 'Epic sadface: " + error + "')]"));
    }
}
