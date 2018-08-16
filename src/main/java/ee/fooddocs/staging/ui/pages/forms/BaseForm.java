package ee.fooddocs.staging.ui.pages.forms;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@Slf4j
public abstract class BaseForm extends PageObject {
    @FindBy(css = "div.modal")
    private WebElementFacade modalDivContainer;

    @FindBy(css = "div.modal-body h2")
    private WebElementFacade formTitle;

    public String getFormTitle() {
        final String title = formTitle.isCurrentlyVisible() ? formTitle.getText().trim() : "";
        log.info("Form title is <{}>", title);
        return title;
    }

    // TODO: Find a way to dismiss forms in the normal way
    public void closeForm() {
        find(By.xpath("//html")).click();
        formTitle.waitUntilNotVisible();
    }
}
