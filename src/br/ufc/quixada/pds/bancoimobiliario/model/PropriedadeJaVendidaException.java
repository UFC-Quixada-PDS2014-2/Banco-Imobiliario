package br.ufc.quixada.pds.bancoimobiliario.model;

public class PropriedadeJaVendidaException extends Exception{
	public PropriedadeJaVendidaException(){
		super("Propriedade já adquirida");
	}
}
