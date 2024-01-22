import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "E:\\IdeaProjects\\Automation_F\\src\\test\\java\\features.feature",
        glue = {""}, //
        plugin = {"pretty", "html:target/cucumber-html-report"})
public class Runner extends TestBase {
    // ...
}






