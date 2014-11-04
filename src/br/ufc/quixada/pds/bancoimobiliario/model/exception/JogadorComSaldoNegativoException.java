package br.ufc.quixada.pds.bancoimobiliario.model.exception;

public class JogadorComSaldoNegativoException extends Exception {
	
	public JogadorComSaldoNegativoException(){
		super("Jogador com saldo negativo.");
	}
}
