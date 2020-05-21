package hooks;

import report.ReportPDF;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import resourcesmanager.ResourcesManager;

import java.io.IOException;

import static properties.PropertiesManager.addBuildNumber;
import static scenario.ScenarioManager.setScenario;
import static webdriver.SetupDriver.getChromeDriver;
import static webdriver.SetupDriver.quitDriver;

public class Hooks{

    public static ReportPDF reportPDF;
    public static final Logger logger = LogManager.getLogger();

    @Before
    public void setupTest(Scenario scenario) {
        setScenario(scenario);
        getChromeDriver();
        reportPDF = new ReportPDF();
        reportPDF.setCover(scenario.getName(), "");
}

    @After
    public void tearDown(Scenario scenario) throws IOException {
        logger.info(scenario.getName()+"- status: "+scenario.getStatus());
        reportPDF.save(!scenario.isFailed());
        ResourcesManager.deleteTrashPdf();
        quitDriver();

    }





}
