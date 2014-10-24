package br.ufc.quixada.pds.bancoimobiliario.model;

public class SaldoJogadorInsuficienteException extends Exception{
	public SaldoJogadorInsuficienteException(){
		super("O Jogador não possui saldo suficiente para comprar essa propriedade.");
	}
}
