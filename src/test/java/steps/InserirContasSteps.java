package steps;

import java.io.File;
import java.io.IOException;

import gherkin.ast.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;
import utils.Generator;

import java.util.concurrent.TimeUnit;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("que desejo adicionar uma conta")
    public void queDesejoAdicionarUmaConta() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonathan\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://seubarriga.wcaquino.me/login");
        driver.findElement(By.id("email")).sendKeys("jkvin@gmail.com");
        driver.findElement(By.name("senha")).sendKeys("jkevin");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("adiciono a conta {string}")
    public void adicionoAConta(String arg0) {
        driver.findElement(By.id("nome")).sendKeys(arg0);
        driver.findElement(By.tagName("button")).click();
    }

    @Então("recebo a mensagem {string}")
    public void receboAMensagem(String arg0) {
        SoftAssert softAssert = new SoftAssert();

        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();

        softAssert.assertEquals(arg0, texto, "Validação da mensagem recebida");

        softAssert.assertAll();
    }

    @After(order = 1, value = "@funcionais")
    public void screenshot(Scenario cenario) {
        File file = ((TakesScreenshot)driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target\\screenshot\\"
                    + cenario.getName()
                    + "."
                    + Generator.dataHoraParaArquivo()
                    + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0, value = "@funcionais")
    public void fecharBrowser(){
        driver.quit();
    }
}
