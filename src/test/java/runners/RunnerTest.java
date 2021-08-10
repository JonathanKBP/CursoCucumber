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
        //features = "src\\test\\resources\\features\\aprender_cucumber.feature",
        //features = "src\\test\\resources\\features\\alugar_filme.feature",
        features = "src\\test\\resources\\features\\inserir_conta.feature",
        glue = "steps",
        tags = "not @ignore",
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class RunnerTest {
    @BeforeClass
    public static void reset(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonathan\\drivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://seubarriga.wcaquino.me/login");
        driver.findElement(By.id("email")).sendKeys("jkvin@gmail.com");
        driver.findElement(By.id("senha")).sendKeys("jkevin");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
