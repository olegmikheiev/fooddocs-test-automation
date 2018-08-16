package ee.fooddocs.staging.ui.pages;

import ee.fooddocs.staging.ui.config.Config;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends FooddocsBasePage {
    @FindBy(css = "div.index-top-wrapper")
    private WebElementFacade homePageIndicator;

    public boolean isOpen() {
        return homePageIndicator.withTimeoutOf(1, TimeUnit.SECONDS).isPresent();
    }

    public void navigateTo() {
        setDefaultBaseUrl(Config.getBASE_URL());
        open();
    }
}
