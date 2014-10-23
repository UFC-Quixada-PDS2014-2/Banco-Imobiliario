package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.List;

public interface Jogador {

	public void atualizarPosicao(int deslocamentoPosicao);
	public String getNome();
	public double getSaldo();
	public int getPosicao();
	public List<Logradouro> getLogradourosAdquiridos();
	
	
}
