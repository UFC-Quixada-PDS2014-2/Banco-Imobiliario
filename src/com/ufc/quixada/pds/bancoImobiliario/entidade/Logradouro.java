package com.ufc.quixada.pds.bancoImobiliario.entidade;

public abstract class Logradouro {

	private String nome;
	private int posicao;
	
	public int obterPosicao(){
		return this.posicao;
	}
}
