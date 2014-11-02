package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;

public abstract class Logradouro {

	private String nome;
	
	public String getNome(){
		return this.nome;
	}
	
	public abstract AcaoLogradouroEnum acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException;
	
	public abstract void passeiPorAqui(Jogador jogador) throws JogadorComSaldoNegativoException,ValorInvalidoException;
	
}
