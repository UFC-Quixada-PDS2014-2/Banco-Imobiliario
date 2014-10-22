package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.config.ConfiguracaoCasasTabuleiroComXStream;
import br.ufc.quixada.pds.bancoimobiliario.config.ReaderLogradouros;
import br.ufc.quixada.pds.bancoimobiliario.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.exception.ErroNaLeituraDoXML;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroBuilder;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroBuilderConcrete;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroDirector;

public class TabuleiroTeste {

	@Test
	public void testeTabuleiroCasaInicialEhPontoDePartida() {
		
		TabuleiroBuilder builderTabuleiro = new TabuleiroBuilderConcrete();
		ReaderLogradouros readerLogradouros = null;
		try {
			readerLogradouros = new ConfiguracaoCasasTabuleiroComXStream();
			TabuleiroDirector td = new TabuleiroDirector(builderTabuleiro, readerLogradouros);
			td.construirTabuleiro();
			Tabuleiro tabuleiro = td.getTabuleiro();
			
			assertThat(tabuleiro.pegarPontoDePartida(), instanceOf(PontoDePartida.class));
			
		} catch (Exception e) {
			fail();
		}
	}
		
	@Test
	public void testeGetPosicaoComVoltaCompleta(){
		
		TabuleiroBuilder builderTabuleiro = new TabuleiroBuilderConcrete();
		ReaderLogradouros readerLogradouros = null;
		try {
			readerLogradouros = new ConfiguracaoCasasTabuleiroComXStream();
			TabuleiroDirector td = new TabuleiroDirector(builderTabuleiro, readerLogradouros);
			td.construirTabuleiro();
			Tabuleiro tabuleiro = td.getTabuleiro();
			
			Logradouro logradouroBase = tabuleiro.pegarPontoDePartida();
			
			Logradouro novoLogradouro = tabuleiro.obterLogradouro(logradouroBase, 40);
			
			assertThat(novoLogradouro, instanceOf(PontoDePartida.class));
			
		} catch (Exception e) {
			fail();
		}
	}
	
	
		
	
		
		
	

}
