package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class JogadorImpl implements Jogador{

	private String nome;
	private double saldo;
	private int posicao;
	private int ultimoDeslocamento;
	private List<Propriedade> propriedadesAdquiridas;

	public JogadorImpl(String nome, double saldo){
		this.nome = nome;
		this.saldo = saldo;
		this.posicao = ConfiguracoesEnum.POSICAO_INICIAL.getValor();
		this.propriedadesAdquiridas = new ArrayList<>();
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public double getSaldo() {
		return saldo;
	}

	@Override
	public int getPosicao() {
		return posicao;
	}

	@Override
	public Iterator<Propriedade> getPropriedadesAdquiridas() {
		return this.propriedadesAdquiridas.iterator();
	}

	@Override
	public void acrescentarSaldo(double valor) throws ValorInvalidoException {
		if(valor <= 0.00){
			throw new ValorInvalidoException();
		} 
			
		this.saldo += valor;
	}

	@Override
	public void decrementarSaldo(double valor) throws JogadorComSaldoNegativoException, ValorInvalidoException {
		
		if(valor <= 0.00){
			throw new ValorInvalidoException();
		}
		
		this.saldo -= valor;
		
		if(this.saldo < 0.00){
			throw new JogadorComSaldoNegativoException();
		}
	}

	@Override
	public void adicionarPropriedadeAdquirida(Propriedade propriedade) {
		this.propriedadesAdquiridas.add(propriedade);
	}

	@Override
	public int getValorDoUltimoDeslocamento() {
		return this.ultimoDeslocamento;
	}

	@Override
	public void setValorDoUltimoDeslocamento(int novoDeslocamento) {	
		this.ultimoDeslocamento = novoDeslocamento;
	}

	@Override
	public void avancarPosicaoJogador(int quantidadeDePosicoes) throws ValorInvalidoException {
		
		if(quantidadeDePosicoes <= 0)
			throw new ValorInvalidoException();
		
		this.posicao = (this.posicao + quantidadeDePosicoes) % ConfiguracoesEnum.NUMERO_CASAS.getValor();
		
	}

	@Override
	public void voltarPosicaoJogador(int quantidadeDePosicoes) throws ValorInvalidoException {
		
		if(quantidadeDePosicoes <= 0)
			throw new ValorInvalidoException();
		
		//TODO rever logica 
		
		quantidadeDePosicoes = quantidadeDePosicoes % ConfiguracoesEnum.NUMERO_CASAS.getValor();
		
		int novaPosicao = this.posicao - quantidadeDePosicoes;
		
		if(novaPosicao < 0){
			novaPosicao = (ConfiguracoesEnum.NUMERO_CASAS.getValor() + novaPosicao) % ConfiguracoesEnum.NUMERO_CASAS.getValor();
		}
		this.posicao = novaPosicao;
	}
}