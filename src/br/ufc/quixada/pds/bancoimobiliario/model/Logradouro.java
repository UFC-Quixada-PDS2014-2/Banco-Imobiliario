package br.ufc.quixada.pds.bancoimobiliario.model;

public abstract class Logradouro {

	private String nome;
	private int posicao;
	
	public int obterPosicao(){
		return this.posicao;
	}
	
	public String getNome(){
		return this.nome;
	}
}
