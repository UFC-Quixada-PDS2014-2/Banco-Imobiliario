package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.LogradouroIndisponivelCompraException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public abstract class Logradouro {

	private String nome;
	private String descricao;
	
	public String getNome(){
		return this.nome;
	}
	
	public abstract AcaoLogradouroEnum acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException;
	public abstract void passeiPorAqui(Jogador jogador) throws JogadorComSaldoNegativoException,ValorInvalidoException;
	public abstract boolean isDisponivelParaCompra();
	public abstract void comprarLogradouro(Jogador compradorDoLogradouro) throws SaldoJogadorInsuficienteException, LogradouroIndisponivelCompraException, JogadorInvalidoException, JogadorComSaldoNegativoException, ValorInvalidoException;
	
	@Override
	public String toString() {
		return this.nome + "\n" + this.descricao;
	}
	
}
