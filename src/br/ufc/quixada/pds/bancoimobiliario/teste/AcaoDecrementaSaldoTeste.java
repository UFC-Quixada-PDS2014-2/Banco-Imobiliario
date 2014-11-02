package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.AcaoDecrementaSaldo;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.ValorInvalidoException;

public class AcaoDecrementaSaldoTeste {

	@Test
	public void testeDecrementandoSaldoDoJogador() {
		
		final double saldoInicial = 1000.00;
		final double valorDecrementado = 200.00;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		AcaoDecrementaSaldo acao = new AcaoDecrementaSaldo(valorDecrementado);
		
		try {
			acao.executar(jogador);
		} catch (Exception e) {
			fail();
		}
		
		assertEquals(saldoInicial - valorDecrementado, jogador.getSaldo(), 0.00);
	}
	
	@Test
	public void testeDecrementandoSaldoDoJogadorComValorNegativo() {
		
		final double saldoInicial = 1000.00;
		final double valorDecrementado = -200.00;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		AcaoDecrementaSaldo acao = new AcaoDecrementaSaldo(valorDecrementado);
		
		try {
			acao.executar(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void testeDecrementandoSaldoDoJogadorComValorZero() {
		
		final double saldoInicial = 1000.00;
		final double valorDecrementado = 0.00;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		AcaoDecrementaSaldo acao = new AcaoDecrementaSaldo(valorDecrementado);
		
		try {
			acao.executar(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void testeJogadorComSaldoNegativoAposDecremento() {
		
		final double saldoInicial = 1000.00;
		final double valorDecrementado = 2000.00;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		AcaoDecrementaSaldo acao = new AcaoDecrementaSaldo(valorDecrementado);
		
		try {
			acao.executar(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Jogador com saldo negativo.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void testeJogadorComSaldoZeroAposDecremento() {
		
		final double saldoInicial = 1000.00;
		final double valorDecrementado = 1000.00;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		AcaoDecrementaSaldo acao = new AcaoDecrementaSaldo(valorDecrementado);
		
		try {
			acao.executar(jogador);
		} catch (Exception e) {
			fail();
		}
		
		assertEquals(0.00, jogador.getSaldo(), 0.00);
	}

}
