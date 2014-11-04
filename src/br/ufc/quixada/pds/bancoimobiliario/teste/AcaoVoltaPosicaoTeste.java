package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.lugarespecial.AcaoVoltaPosicao;

public class AcaoVoltaPosicaoTeste {

	@Test
	public void testeJogadorVoltandoPosicoes(){
		
		Jogador jogador = new JogadorImpl("Teste", 2000);
		
		final int posicaoInicial = jogador.getPosicao();
		final int qtdDeslocamento = 2;
		
		AcaoVoltaPosicao acao = new AcaoVoltaPosicao(qtdDeslocamento);
		
		try {
			acao.executar(jogador);
			
			assertEquals(38, jogador.getPosicao());
		} catch (ValorInvalidoException e) {
			fail();
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testeJogadorVoltandoPosicoesComVoltaCompleta(){
		
		Jogador jogador = new JogadorImpl("Teste", 2000);
		
		final int posicaoInicial = jogador.getPosicao();
		final int qtdDeslocamento = 40;
		
		AcaoVoltaPosicao acao = new AcaoVoltaPosicao(qtdDeslocamento);
		
		try {
			acao.executar(jogador);
			
			assertEquals(0, jogador.getPosicao());
		} catch (ValorInvalidoException e) {
			fail();
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testeJogadorVoltandoPosicoesComDeslocamentoNegativo(){
		
		Jogador jogador = new JogadorImpl("Teste", 2000);
		
		final int posicaoInicial = jogador.getPosicao();
		final int qtdDeslocamento = -2;
		
		AcaoVoltaPosicao acao = new AcaoVoltaPosicao(qtdDeslocamento);
		
		try {
			acao.executar(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
		
	}
	
	@Test
	public void testeJogadorVoltandoPosicoesComDeslocamentoZero(){
		
		Jogador jogador = new JogadorImpl("Teste", 2000);
		
		final int posicaoInicial = jogador.getPosicao();
		final int qtdDeslocamento = 0;
		
		AcaoVoltaPosicao acao = new AcaoVoltaPosicao(qtdDeslocamento);
		
		try {
			acao.executar(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
		
	}

}
