package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.ufc.quixada.pds.bancoimobiliario.config.ReaderLogradouros;
import br.ufc.quixada.pds.bancoimobiliario.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.exception.MontadorTabuleiroException;

public class TabuleiroDirector {

	private TabuleiroBuilder builderTabuleiro;
	private ReaderLogradouros readerLogradouros;
	
	@Inject
	public TabuleiroDirector(TabuleiroBuilder builderTabuleiro, ReaderLogradouros readerLogradouros){
		this.builderTabuleiro = builderTabuleiro;
		this.readerLogradouros = readerLogradouros;
	}
	
	public void construirTabuleiro() throws ErroArquivoConfiguracoesException{
		
		PontoDePartida pontoDePartida = readerLogradouros.pegarPontoDePartida();
		List<Logradouro> listaLogradouros = readerLogradouros.lerLogradouros();
		
		try {
			builderTabuleiro.montarPontoPartida(pontoDePartida);
			
			Iterator<Logradouro> iteratorLogradouros = listaLogradouros.iterator();
			while(iteratorLogradouros.hasNext()){
				Logradouro logradouro = iteratorLogradouros.next();
				if(iteratorLogradouros.hasNext()){
					builderTabuleiro.montarCasaIntermediaria(logradouro);
				}else{
					builderTabuleiro.montarUltimaCasa(logradouro);
				}
			}
			
		} catch (MontadorTabuleiroException e) {
			e.printStackTrace();
			throw new ErroArquivoConfiguracoesException("Arquivo de configuração inválido");
		}
		
	}
	
	public Tabuleiro getTabuleiro() throws MontadorTabuleiroException{
		return builderTabuleiro.getTabuleiro();
	}
	
}
