package br.ufc.quixada.pds.bancoimobiliario.builder;

import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.MontadorTabuleiroException;

public interface TabuleiroDirector {

	public void construirTabuleiro() throws ErroArquivoConfiguracoesException;
	public Tabuleiro getTabuleiro() throws MontadorTabuleiroException;
	
}
