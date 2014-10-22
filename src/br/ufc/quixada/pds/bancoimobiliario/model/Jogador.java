package br.ufc.quixada.pds.bancoimobiliario.model;

public class Jogador {

	private String nome;
	private Peca peca;
	private double saldo;
	private Tabuleiro tabuleiro;

	public void atualizarPosicao(int deslocamentoPosicao) {
		Logradouro logradouroBase = this.peca.pegarLocalizacao();
		Logradouro proximoLogradouro = this.tabuleiro.obterLogradouro(
				logradouroBase, deslocamentoPosicao);
		this.peca.atualizarLocalizacao(proximoLogradouro);
	}

	
	public void adicionarSaldo(double  valor){
		// TODO : Criar validacao pra valores negativos
		saldo += valor;
	}
	
	public void removerSaldo(double valor){
		// TODO : Criar validacao pra valores negativos
		saldo -= valor;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
		this.peca.atualizarLocalizacao(tabuleiro.pegarPontoDePartida());
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

}
