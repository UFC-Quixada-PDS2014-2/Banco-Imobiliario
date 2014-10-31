package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;

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
	public void atualizarPosicao(int novaPosicao) {
		this.posicao = novaPosicao;
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
	public List<Propriedade> getPropriedadesAdquiridas() {
		return this.propriedadesAdquiridas;
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
	public int pegarValorDoUltimoDeslocamento() {
		return this.ultimoDeslocamento;
	}

	@Override
	public void atualizarValorDoUltimoDeslocamento(int novoDeslocamento) {	
		this.ultimoDeslocamento = novoDeslocamento;
	}

	@Override
	public void avancarPosicaoJogar(int quantidadeDePosicoes) {
		//TODO impedir que quantidade seja maior que o tamanho da lista
		
		this.posicao = (this.posicao + quantidadeDePosicoes) % ConfiguracoesEnum.NUMERO_CASAS.getValor();
		
	}

	@Override
	public void voltarPosicaoJogador(int quantidadeDePosicoes) {
		
		//TODO impedir que quantidade seja negativa
		
		//TODO refazer logica 
		
		int novaPosicao = this.posicao - quantidadeDePosicoes;
		
		if(novaPosicao < 0){
			novaPosicao += ConfiguracoesEnum.NUMERO_CASAS.getValor();
		}
		
		this.posicao = novaPosicao;
		
	}

	@Override
	public boolean isDonoDaPropriedade(Propriedade propriedade) {
		
		return this.propriedadesAdquiridas.contains(propriedade);
	}
	
	

}