package ee.fooddocs.staging.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/smoke",
        glue = "ee.fooddocs.staging.definitions"
)
public class UITestsRunner {
}
