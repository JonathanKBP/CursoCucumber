package steps;

import cucumber.api.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AprenderCucumberSteps {
    @Given("^que criei o arquivo corretamente$")
    public void queCrieiOArquivoCorretamente() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^executá-lo$")
    public void executáLo() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^a especificação deve finalizar com sucesso$")
    public void aEspecificaçãoDeveFinalizarComSucesso() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    private int contador = 0;

    @Dado("que o valor do contador é {int}")
    public void queOValorDoContadorÉ(Integer int1) throws Throwable{
       contador = int1;
    }

    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(Integer int1) {
        contador = contador + int1;
    }

    @Então("o valor do contador será {int}")
    public void oValorDoContadorSerá(Integer int1) {
        System.out.println(int1);
        System.out.println(contador);
        //Assert.assertTrue(int1 == contador);
        //Assert.assertEquals(int1, contador);
    }

    Date entrega = new Date();

    @Dado("que a entrega é dia {data}")
    public void queAEntregaÉDia(Date data) {

        entrega = data;
    }

    @Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
    public void aEntregaAtrasarEmDias(Integer int1, String tempo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if(tempo.equals("dias")) {
            cal.add(Calendar.DAY_OF_MONTH, int1);
        }
        if(tempo.equals("meses")) {
            cal.add(Calendar.MONTH, int1);
        }
        entrega = cal.getTime();
    }
    @Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
        SoftAssert softAssert = new SoftAssert();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);

        softAssert.assertEquals(data, dataFormatada, "Validação data iguais");
        //Assert.assertEquals(data, dataFormatada);

        softAssert.assertAll();
    }

    @Dado("^que o ticket( especial)? é (A.\\d{3})$")
    public void queOTicketÉAF(String tipo, String arg1) {

    }

    @Dado("que o valor da passagem é R$ {double}")
    public void queOValorDaPassagemÉR$(Double double1) {

    }
    @Dado("^que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroÉ(String string) {

    }
    @Dado("^que o telefone do passageiro é (9\\d{3})-(\\d{4})$")
    public void queOTelefoneDoPassageiroÉ(Integer int1, Integer int2) {

    }
    @Quando("criar os steps")
    public void criarOsSteps() {

    }
    @Então("o teste vai funcionar")
    public void oTesteVaiFuncionar() {

    }

}
