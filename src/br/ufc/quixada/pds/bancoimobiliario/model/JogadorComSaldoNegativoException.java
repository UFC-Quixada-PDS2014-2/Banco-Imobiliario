package br.ufc.quixada.pds.bancoimobiliario.model;

public class JogadorComSaldoNegativoException extends Exception {
	
	public JogadorComSaldoNegativoException(){
		super("Jogador com saldo negativo.");
	}
}
