package br.ufc.quixada.pds.bancoimobiliario.model;

public class ValorInvalidoException extends Exception {

	public ValorInvalidoException(){
		super("Valor deve ser maior que zero.");
	}
}
