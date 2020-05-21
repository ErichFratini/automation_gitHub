package scenario;

        import io.cucumber.java.Scenario;

public class ScenarioManager {

    public static Scenario scenarioName;

    public static void setScenario(Scenario scenario) {
        scenarioName = scenario;
    }

    public static Scenario getScenario() {
        return scenarioName;
    }
}
