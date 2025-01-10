package com.yasin.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepdef {
    WebDriver driver;

    @Before
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void afterTest(){
        driver.close();
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user input username text box with {string}")
    public void userInputUsernameTextBoxWith(String username) {
        By usernameInputText = By.cssSelector("input#user-name");
        driver.findElement(usernameInputText).sendKeys(username);
    }

    @And("user input password text box with {string}")
    public void userInputPasswordTextBoxWith(String password) {
        By passwordInputText = By.xpath("//*[@id=\"password\"]");
        driver.findElement(passwordInputText).sendKeys(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        By loginButton = By.id("login-button");
        driver.findElement(loginButton).click();
    }

    @Then("user will redirect to hompage")
    public void userWillRedirectToHompage() {
        By productItem = By.xpath("//*[@id=\"item_4_title_link\"]/div");
        WebElement productElement = driver.findElement(productItem);
        assertTrue(driver.findElement(productItem).isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }

    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String errorMessage) {
        assertTrue(driver.getPageSource().contains(errorMessage));
    }
}
