
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static cucumber.CucumbeReport.generateReports;
import static properties.PropertiesManager.addBuildNumber;

@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber/cucumber-json-report.json"},
        features = {"src/test/resources/features"},
        glue = {"steps", "hooks"},
        tags = {"@ID01"},
        strict = true)

public class RunTest extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void afterSuite() throws IOException {
        addBuildNumber();
        generateReports();
    }
}


