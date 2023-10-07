package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features",
        glue={"StepDefinitions"},
        monochrome = true,
        plugin = {
                "pretty", "html:target/HtmlReports/index.html",
                "pretty", "json:target/JSONReports/report.json",
                "pretty", "junit:target/JUnitReports/report.xml"
        },
        tags="@regressiontest"
)
public class TestRunner {



}
