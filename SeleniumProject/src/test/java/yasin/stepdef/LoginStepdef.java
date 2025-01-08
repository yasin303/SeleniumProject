package yasin.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdef {
    @Given("user is on login page")
    public void userIsOnLoginPage() {

    }

    @When("user input username text box with {string}")
    public void userInputUsernameTextBoxWith(String username) {
    }

    @And("user input password text box with {string}")
    public void userInputPasswordTextBoxWith(String password) {
    }

    @And("user click login button")
    public void userClickLoginButton() {
    }

    @Then("user will redirect to hompage")
    public void userWillRedirectToHompage() {
    }
}
