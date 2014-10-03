package com.ufc.quixada.pds.bancoImobiliario.entidade;

public class Jogador {

	private String nome;
	private Peca peca;
	private double saldo;
	private Tabuleiro tabuleiro;
	
	public void atualizarPosicao(int deslocamentoPosicao){
		Logradouro logradouroBase = this.peca.buscarLocalizacao();
		Logradouro proximoLogradouro = this.tabuleiro.obterLogradouro(logradouroBase, deslocamentoPosicao);
		this.peca.atualizarLocalizacao(proximoLogradouro);
	}
}
