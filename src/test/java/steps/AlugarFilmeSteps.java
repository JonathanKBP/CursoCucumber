package steps;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.testng.asserts.SoftAssert;
import servicos.AluguelService;
import utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {
    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

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
            nota = aluguel.alugar(filme, tipoAluguel);
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

    @Dado("^que o tipo de aluguel seja (.*)$")
    public void queOTipoDeAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
    }

    @Então("^a data de entrega será em (\\d+) dias?$")
    public void aDataDeEntregaSeráEmDias(int arg0) {
        SoftAssert softAssert = new SoftAssert();

        Date dataEsperada = DateUtils.obterDataDiferenciaDias(arg0);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");


        softAssert.assertEquals(format.format(dataEsperada), format.format(dataReal), "Validação data de entrega extendida");

        softAssert.assertAll();
    }

    @Então("a pontuação será de {int} pontos")
    public void aPontuaçãoSeráDePontos(int arg0) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(arg0, nota.getPontuacao(), "Validação data pontuação");

        softAssert.assertAll();
    }
}
