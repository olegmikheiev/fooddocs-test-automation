package ee.fooddocs.staging.definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ee.fooddocs.staging.steps.GuestUserSteps;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Steps;

@Slf4j
public class GuestUserStepsDef {
    @Steps
    private GuestUserSteps userSteps;

    @Given("^User is a '(.*)' user$")
    public void userIsAGuestUser(String role) {
        log.info("User role is {}", role);
    }

    @Given("^User is on a Home page$")
    public void userIsOnHomePage() {
        userSteps.userIsOnHomePage();
    }

    @When("^User navigates to the Login screen$")
    public void userNavigatesToTheLoginScreen() {
        userSteps.openLoginForm();
    }

    @When("^User navigates to the Sign Up screen$")
    public void userNavigatesToTheSignUpScreen() {
        userSteps.openSignUpForm();
    }

    @When("^User performs login with email '(.*)' and password '(.*)'$")
    public void userEntersLoginCredentials(String email, String password) {
        userSteps.loginAs(email, password);
    }

    @Then("Login screen is open")
    public void loginScreenIsOpen() {
        userSteps.verifyLoginFormIsOpen();
    }

    @Then("^Registration screen is open$")
    public void registrationScreenIsOpen() {
        userSteps.verifySignUpFormIsOpen();
    }

    @And("^language is set to '(.*)'$")
    public void languageIsSetTo(String language) {
        userSteps.setLanguageTo(language);
    }


    @Then("^Login screen shows error message '(.*)'$")
    public void loginScreenShowsError(String message) {
        userSteps.verifyLoginFormError(message);
    }
}
