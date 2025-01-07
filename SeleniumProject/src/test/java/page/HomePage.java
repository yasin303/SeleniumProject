package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    WebDriver driver;

    By productItem = By.xpath("//*[@id=\"item_4_title_link\"]/div");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void validateProductItemDisplayed(){
        assertTrue(driver.findElement(productItem).isDisplayed());
    }
}
