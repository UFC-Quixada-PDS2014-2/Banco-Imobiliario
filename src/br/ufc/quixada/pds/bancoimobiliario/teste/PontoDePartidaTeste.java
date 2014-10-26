package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;

public class PontoDePartidaTeste {

	@Test
	public void testaSeSaldoDeJogadorEhIncrementadoAoPassar() {
		
		Jogador jogador = new JogadorImpl("Teste", 500.00);
		
		PontoDePartida pontoDePartida = new PontoDePartida();
		pontoDePartida.passeiPorAqui(jogador);
		
		assertTrue(jogador.getSaldo() > 500.00);
	}
	
	@Test
	public void testaValorIncrementadoAoPassar(){
		
		Jogador jogador = new JogadorImpl("Teste", 500.00);
		double valorEsperado = 500.00 + ConfiguracoesEnum.VALOR_INCREMENTO_PONTODEPARTIDA.getValor();
		
		PontoDePartida pontoDePartida = new PontoDePartida();
		pontoDePartida.passeiPorAqui(jogador);
		
		
		assertEquals(valorEsperado, jogador.getSaldo(), 0.00);
	}

}
