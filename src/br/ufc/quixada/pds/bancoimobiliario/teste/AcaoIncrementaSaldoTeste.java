package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.AcaoIncrementaSaldo;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.ValorInvalidoException;

public class AcaoIncrementaSaldoTeste {

	@Test
	public void testeIcrementandoSaldoJogador() {
		
		final double saldoInicial = 500.00;
		final double incremento = 25.00;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		AcaoIncrementaSaldo acao = new AcaoIncrementaSaldo(incremento);
		
		try {
			acao.executar(jogador);
		} catch (Exception e) {
			fail();
		}
		
		assertEquals(saldoInicial + incremento, jogador.getSaldo(), 0.00);
	}
	
	@Test
	public void testeIcrementandoSaldoJogadorComValorNegativo() {
		
		final double saldoInicial = 500.00;
		final double incremento = -25.00;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		AcaoIncrementaSaldo acao = new AcaoIncrementaSaldo(incremento);
		
		try {
			acao.executar(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void testeIcrementandoSaldoJogadorComValorZero() {
		
		final double saldoInicial = 500.00;
		final double incremento = 0.00;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		AcaoIncrementaSaldo acao = new AcaoIncrementaSaldo(incremento);
		
		try {
			acao.executar(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}

}
