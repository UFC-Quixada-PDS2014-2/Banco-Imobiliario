package br.ufc.quixada.pds.bancoimobiliario.builder;

import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.MontadorTabuleiroException;


public interface TabuleiroBuilder {

	public void montarPontoPartida(PontoDePartida pontoDePartida) throws MontadorTabuleiroException;
	public void montarCasaIntermediaria(Logradouro logradouro) throws MontadorTabuleiroException;
	public void montarUltimaCasa(Logradouro logradouro) throws MontadorTabuleiroException;
	public Tabuleiro getTabuleiro() throws MontadorTabuleiroException;
	
}
