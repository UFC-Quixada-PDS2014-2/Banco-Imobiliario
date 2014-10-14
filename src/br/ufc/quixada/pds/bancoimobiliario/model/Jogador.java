package br.ufc.quixada.pds.bancoimobiliario.model;

public class Jogador {

	private String nome;
	private Peca peca;
	private double saldo;
	private Tabuleiro tabuleiro;
	
	public void atualizarPosicao(int deslocamentoPosicao){
		Logradouro logradouroBase = this.peca.pegarLocalizacao();
		Logradouro proximoLogradouro = this.tabuleiro.obterLogradouro(logradouroBase, deslocamentoPosicao);
		this.peca.atualizarLocalizacao(proximoLogradouro);
	}
}
