package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class PontoDePartidaTeste {

	@Test
	public void testaSeSaldoDeJogadorEhIncrementadoAoPassar(){
		
		Jogador jogador = new JogadorImpl("Teste", 500.00);
		
		PontoDePartida pontoDePartida = new PontoDePartida();
		try {
			pontoDePartida.passeiPorAqui(jogador);
		} catch (ValorInvalidoException e) {
			fail();
			e.printStackTrace();
		}
		
		assertTrue(jogador.getSaldo() > 500.00);
	}
	

}
