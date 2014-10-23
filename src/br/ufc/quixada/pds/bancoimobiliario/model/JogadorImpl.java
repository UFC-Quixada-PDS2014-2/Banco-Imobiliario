package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;

public class JogadorImpl implements Jogador{

	private String nome;
	private double saldo;
	private int posicao;
	private List<Propriedade> propriedadesAdquiridas;

	public JogadorImpl(String nome, double saldo){
		this.nome = nome;
		this.saldo = saldo;
		this.posicao = ConfiguracoesEnum.POSICAO_INICIAL.getValor();
		this.propriedadesAdquiridas = new ArrayList<>();
	}

	@Override
	public void atualizarPosicao(int deslocamentoPosicao) {
		this.posicao += deslocamentoPosicao;
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
	public void acrescentarSaldo(double saldo) {
		this.saldo += saldo;
	}

	@Override
	public void decrementarSaldo(double saldo) {
		this.saldo -= saldo;		
	}

}