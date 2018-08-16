package ee.fooddocs.staging.ui.pages;

import ee.fooddocs.staging.ui.utils.WebDriverUtils;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public abstract class FooddocsBasePage extends PageObject {
    @FindBy(id = "btn-login")
    private WebElementFacade loginButton;

    @FindBy(id = "btn-register")
    private WebElementFacade signUpButton;

    @FindBy(css = "div#lang-select select")
    private WebElementFacade languageSelect;

    public void openLoginForm() {
        WebDriverUtils.scrollIntoView(loginButton, this).click();
    }

    public void openSignUpForm() {
        WebDriverUtils.scrollIntoView(signUpButton, this).click();
    }

    public void selectLanguage(String language) {
        if (!language.equalsIgnoreCase(languageSelect.getText().trim())) {
            languageSelect.click();
            languageSelect.find(By.xpath(String.format("//option[.='%s']", language.toUpperCase())))
                    .waitUntilEnabled().click();
        }
    }
}
