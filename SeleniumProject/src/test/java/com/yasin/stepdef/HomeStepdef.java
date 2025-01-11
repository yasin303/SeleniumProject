package com.yasin.stepdef;

import com.yasin.BaseTest;
import io.cucumber.java.en.Then;
import page.HomePage;

public class HomeStepdef extends BaseTest {
    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        homePage = new HomePage(driver);
        homePage.validateProductItemDisplayed();
    }
}
