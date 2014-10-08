package br.ufc.quixada.pds.bancoImobiliario.exception;

public class LimiteValorDadosException extends Exception {

	public LimiteValorDadosException(){
		super("O valor dos dados deve estar entre 2 e 12");
	}
}
