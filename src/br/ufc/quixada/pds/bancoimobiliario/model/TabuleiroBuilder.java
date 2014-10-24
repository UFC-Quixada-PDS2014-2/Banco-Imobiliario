package br.ufc.quixada.pds.bancoimobiliario.model;


public interface TabuleiroBuilder {

	public void montarPontoPartida(PontoDePartida pontoDePartida) throws MontadorTabuleiroException;
	public void montarCasaIntermediaria(Logradouro logradouro) throws MontadorTabuleiroException;
	public void montarUltimaCasa(Logradouro logradouro) throws MontadorTabuleiroException;
	public Tabuleiro getTabuleiro() throws MontadorTabuleiroException;
	
}
