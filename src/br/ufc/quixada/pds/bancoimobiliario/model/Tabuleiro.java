package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.List;

public interface Tabuleiro {

	public List<Logradouro> getCasasDoTabuleiro();
	public Logradouro getPontoDePartida();
	public Logradouro percorrerTabuleiro(Jogador jogador, int deslocamento);
	
	
}
