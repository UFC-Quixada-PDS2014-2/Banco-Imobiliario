package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.Peca;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;

public class PecaTeste {

	@Test
	public void pegarLocalizacaoQuandoLogradouroNulo() {
		
		Peca peca = new Peca();
		assertEquals(null, peca.pegarLocalizacao());
	}
	
	@Test
	public void pegarLocalizacaoRecemInserida(){
		
		Peca peca = new Peca();
		Logradouro logradouro = new Imovel();
		
		peca.atualizarLocalizacao(logradouro);
		
		assertEquals(logradouro, peca.pegarLocalizacao());
	}
	
	@Test
	public void testeAtualizarLocalizacao(){
		
		Peca peca = new Peca();
		Logradouro logradouro1 = new Imovel();
		peca.atualizarLocalizacao(logradouro1);
		
		Logradouro logradouro2 = new PontoDePartida();
		peca.atualizarLocalizacao(logradouro2);
		
		assertEquals(logradouro2, peca.pegarLocalizacao());
		
	}

}
