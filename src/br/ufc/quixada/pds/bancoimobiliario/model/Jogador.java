package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.List;

public interface Jogador {


	public void atualizarPosicao(int novaPosicao);
	public void avancarPosicaoJogar(int quantidadeDePosicoes);
	public void voltarPosicaoJogador(int quantidadeDePosicoes);
	public void acrescentarSaldo(double valor) throws ValorInvalidoException;
	public void decrementarSaldo(double valor) throws JogadorComSaldoNegativoException, ValorInvalidoException;
	public String getNome();
	public double getSaldo();
	public int getPosicao();
	public List<Propriedade> getPropriedadesAdquiridas();
	public void adicionarPropriedadeAdquirida(Propriedade propriedade);
	public int pegarValorDoUltimoDeslocamento();
	public void atualizarValorDoUltimoDeslocamento(int novoDeslocamento);
	public boolean isDonoDaPropriedade(Propriedade propriedade);
	
}
