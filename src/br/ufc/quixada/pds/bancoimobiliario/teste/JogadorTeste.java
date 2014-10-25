package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;

public class JogadorTeste {

	@Test
	public void verificaSeJogadorIniciaSemPropriedades() {
		
		Jogador jogador = new JogadorImpl("Felipe", 200.00);
		assertEquals(0, jogador.getPropriedadesAdquiridas().size());
	}
	
	@Test
	public void testeIncrementarSaldo(){
		
		//TODO:
		Jogador jogador  = new JogadorImpl("Teste", 0.00);
		
		//jogador.acrescentarSaldo();
	}

}
