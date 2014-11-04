package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.lugarespecial.AcaoAvancaPosicao;

public class AcaoAvancaPosicaoTeste {

	@Test
	public void verificaPosicaoDoJogadorAposAvancar() {
		
		Jogador jogador = new JogadorImpl("teste", 2000);
		
		final int posicaoAtual = jogador.getPosicao();
		final int quantidadeDePosicoes = 10;
		
		AcaoAvancaPosicao acao = new AcaoAvancaPosicao(quantidadeDePosicoes);
		
		try {
			acao.executar(jogador);
		} catch (ValorInvalidoException e) {
			fail();
		}
		
		final int posicaoFinal = jogador.getPosicao();
		
		assertEquals(posicaoAtual + quantidadeDePosicoes ,posicaoFinal);
	}
	
	@Test
	public void verificaPosicaoDoJogadorAposAvancarVoltaCompleta() {
		
		Jogador jogador = new JogadorImpl("teste", 2000);
		
		final int posicaoAtual = jogador.getPosicao();
		final int quantidadeDePosicoes = 40;
		
		AcaoAvancaPosicao acao = new AcaoAvancaPosicao(quantidadeDePosicoes);
		
		try {
			acao.executar(jogador);
		} catch (ValorInvalidoException e) {
			fail();
		}
		
		final int posicaoFinal = jogador.getPosicao();
		
		assertEquals(0 ,posicaoFinal);
	}
	
	@Test
	public void tentarAvancarComValorNegativo() {
		
		Jogador jogador = new JogadorImpl("teste", 2000);
		
		final int posicaoAtual = jogador.getPosicao();
		final int quantidadeDePosicoes = -10;
		
		AcaoAvancaPosicao acao = new AcaoAvancaPosicao(quantidadeDePosicoes);
		
		try {
			acao.executar(jogador);
			fail();
		} catch (Exception e) {
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void tentarAvancarComValorZero() {
		
		Jogador jogador = new JogadorImpl("teste", 2000);
		
		final int posicaoAtual = jogador.getPosicao();
		final int quantidadeDePosicoes = 0;
		
		AcaoAvancaPosicao acao = new AcaoAvancaPosicao(quantidadeDePosicoes);
		
		try {
			acao.executar(jogador);
			fail();
		} catch (Exception e) {
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}

}
