package br.ufc.quixada.pds.bancoimobiliario.exception;

public class LimiteValorDadosException extends Exception {

	public LimiteValorDadosException(){
		super("O valor dos dados deve estar entre 2 e 12");
	}
}
