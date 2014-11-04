package br.ufc.quixada.pds.bancoimobiliario.model.exception;

public class PropriedadeJaVendidaException extends Exception{
	public PropriedadeJaVendidaException(){
		super("Propriedade já adquirida");
	}
}
