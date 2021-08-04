import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumber {
    @Given("que criei o arquivo corretamente")
    public void que_criei_o_arquivo_corretamente() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("executá-lo")
    public void executá_lo() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("a especificação deve finalizar com sucesso")
    public void a_especificação_deve_finalizar_com_sucesso() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    private int contador = 0;

    @Dado("que o valor do contador é {int}")
    public void que_o_valor_do_contador_é(Integer int1) throws Throwable{
       contador = int1;
    }

    @Quando("eu incrementar em {int}")
    public void eu_incrementar_em(Integer int1) {
        contador = contador + int1;
    }

    @Então("o valor do contador será {int}")
    public void o_valor_do_contador_será(Integer int1) {
        System.out.println(int1);
        System.out.println(contador);
        //Assert.assertTrue(int1 == contador);
        //Assert.assertEquals(int1, contador);
    }

    Date entrega = new Date();

    @Dado("que a entrega é dia {int}\\/{int}\\/{int}")
    public void que_a_entrega_é_dia(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes - 1);
        cal.set(Calendar.YEAR, ano);
        entrega = cal.getTime();
    }
    @Quando("a entrega atrasar em {int} dias")
    public void a_entrega_atrasar_em_dias(Integer int1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        cal.add(Calendar.DAY_OF_MONTH, int1);
        entrega = cal.getTime();
    }
    @Então("a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})")
    public void a_entrega_será_efetuada_em(String data) {
        DateFormat format = new SimpleDateFormat("dd/MMMM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }
}
