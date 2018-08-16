package ee.fooddocs.staging.ui.pages.forms;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class LoginForm extends BaseForm {
    @FindBy(id = "login-modal")
    private WebElementFacade loginModalDiv;

    @FindBy(css = "div.warning-notification")
    private WebElementFacade errorMessage;

    @FindBy(css = "input[type='email']")
    private WebElementFacade emailInput;

    @FindBy(css = "input[type='password']")
    private WebElementFacade passwordInput;

    @FindBy(css = "button.btn-next")
    private WebElementFacade loginButton;

    public boolean isOpen() {
        return loginModalDiv.hasClass("active")
                && getFormTitle().toUpperCase().contains("LOGI");
    }

    public void loginAs(String email, String password) {
        log.info("Logging in with email <{}> and password <{}>", email, password);
        emailInput.waitUntilEnabled().sendKeys(email);
        passwordInput.waitUntilEnabled().sendKeys(password);
        loginButton.waitUntilEnabled().click();
    }

    public String getErrorMessage() {
        return errorMessage.waitUntilVisible().getText().trim();
    }
}
