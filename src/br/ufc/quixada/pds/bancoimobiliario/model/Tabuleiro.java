package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.List;

public interface Tabuleiro {

	public List<Logradouro> getCasasDoTabuleiro();
	public Logradouro pegarPontoDePartida();
	public Logradouro percorrerTabuleiro(int posicaoBase, int deslocamento);
	
	
}
