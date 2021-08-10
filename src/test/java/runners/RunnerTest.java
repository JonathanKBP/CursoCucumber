package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\",
        glue = "steps",
        tags = {"not @ignore", "@unitários"},
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class RunnerTest {

}
