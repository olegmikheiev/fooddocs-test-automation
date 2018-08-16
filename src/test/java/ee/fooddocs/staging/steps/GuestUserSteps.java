package ee.fooddocs.staging.steps;

import ee.fooddocs.staging.ui.pages.HomePage;
import ee.fooddocs.staging.ui.pages.forms.LoginForm;
import ee.fooddocs.staging.ui.pages.forms.SignUpForm;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import static org.assertj.core.api.Assertions.assertThat;

public class GuestUserSteps {
    @Page
    private HomePage homePage;

    @Page
    private LoginForm loginForm;

    @Page
    private SignUpForm signUpForm;

    @Step
    public void userIsOnHomePage() {
        if (!homePage.isOpen()) {
            homePage.navigateTo();
        }
    }

    @Step
    public void setLanguageTo(String language) {
        homePage.selectLanguage(language);
    }

    @Step
    public void openLoginForm() {
        homePage.openLoginForm();
    }

    @Step
    public void openSignUpForm() {
        homePage.openSignUpForm();
    }

    @Step
    public void verifyLoginFormIsOpen() {
        assertThat(loginForm.isOpen()).as("Login form is not currently open").isTrue();
    }

    @Step
    public void verifySignUpFormIsOpen() {
        assertThat(signUpForm.isOpen()).as("Sign Up form is not currently open").isTrue();
    }

    @Step
    public void loginAs(String email, String password) {
        homePage.openLoginForm();
        loginForm.loginAs(email, password);
    }

    @Step
    public void verifyLoginFormError(String message) {
        assertThat(loginForm.getErrorMessage())
                .as("Login error message verification failed")
                .contains(message);
    }
}
