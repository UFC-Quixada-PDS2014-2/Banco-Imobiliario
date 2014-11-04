package br.ufc.quixada.pds.bancoimobiliario.model.exception;

public class ValorInvalidoException extends Exception {

	public ValorInvalidoException(){
		super("Valor deve ser maior que zero.");
	}
}
