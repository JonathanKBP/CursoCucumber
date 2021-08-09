package steps;

import entidades.Filme;
import entidades.NotaAluguel;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.testng.asserts.SoftAssert;
import servicos.AluguelService;

import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {
    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Dado("que o preço do aluguel seja R$ {int}")
    public void queOPreçoDoAluguelSejaR$(Integer int1) {
        filme.setAluguel(int1);
    }

    @Quando("alugar")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme);
        } catch (RuntimeException e){
            erro = e.getMessage();
        }

    }

    @Então("o preço do aluguel será R$ {int}")
    public void oPreçoDoAluguelSeráR$(int int1) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(int1, nota.getPreco(), "Validação preço igual");

        softAssert.assertAll();
    }

    @Então("a data de entrega será no dia seguinte")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
        SoftAssert softAssert = new SoftAssert();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = nota.getDataEntrega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        softAssert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH), "Validação do dia do mês");
        softAssert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH), "Validação do mês");
        softAssert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR), "Validação do ano");

        softAssert.assertAll();
    }

    @Então("o estoque do filme será {int} unidades")
    public void oEstoqueDoFilmeSeráUnidades(int int1) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(int1, filme.getEstoque(), "Validação quantidade estoque");

        softAssert.assertAll();
    }

    @Então("não será possivel por falta de estoque")
    public void nãoSeráPossivelPorFaltaDeEstoque() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("Filme sem estoque", erro, "Validação filme sem estoque");

        softAssert.assertAll();
    }
}
