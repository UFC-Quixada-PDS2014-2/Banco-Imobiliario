package br.ufc.quixada.pds.bancoImobiliario.model;

public abstract class Logradouro {

	private String nome;
	private int posicao;
	
	public int obterPosicao(){
		return this.posicao;
	}
}
