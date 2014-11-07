package br.ufc.quixada.pds.bancoimobiliario.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AcaoAvancaPosicaoTeste.class,
	AcaoDecrementaSaldoTeste.class,
   AcaoIncrementaSaldoTeste.class,
   AcaoVoltaPosicaoTeste.class,
   EmpresaTeste.class,
   ImovelTeste.class,
  // JogadorTeste.class,
   PontoDePartidaTeste.class,
   PropriedadeTeste.class  
})
public class TestSuite {
}
