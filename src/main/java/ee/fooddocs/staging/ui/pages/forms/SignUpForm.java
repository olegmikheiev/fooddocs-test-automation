package ee.fooddocs.staging.ui.pages.forms;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SignUpForm extends BaseForm {
    @FindBy(id = "register-modal")
    private WebElementFacade signUpModalDiv;


    public boolean isOpen() {
        return signUpModalDiv.hasClass("active");
    }
}
