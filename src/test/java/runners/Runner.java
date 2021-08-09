package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = "src\\test\\resources\\features\\aprender_cucumber.feature",
        features = "src\\test\\resources\\features\\alugar_filme.feature",
        glue = "steps",
        tags = "not @ignore",
        plugin = "pretty",
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class Runner {

}
