package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.List;

public interface Jogador {


	public void avancarPosicaoJogador(int quantidadeDePosicoes) throws ValorInvalidoException;
	public void voltarPosicaoJogador(int quantidadeDePosicoes) throws ValorInvalidoException;
	public void acrescentarSaldo(double valor) throws ValorInvalidoException;
	public void decrementarSaldo(double valor) throws JogadorComSaldoNegativoException, ValorInvalidoException;
	public String getNome();
	public double getSaldo();
	public int getPosicao();
	public List<Propriedade> getPropriedadesAdquiridas();
	public void adicionarPropriedadeAdquirida(Propriedade propriedade);
	public int getValorDoUltimoDeslocamento();
	public void setValorDoUltimoDeslocamento(int novoDeslocamento);
	
}
