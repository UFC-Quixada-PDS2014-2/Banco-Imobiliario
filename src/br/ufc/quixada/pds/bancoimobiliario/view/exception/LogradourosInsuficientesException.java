package br.ufc.quixada.pds.bancoimobiliario.view.exception;

public class LogradourosInsuficientesException extends Exception{

	public LogradourosInsuficientesException(){
		super("Quantidade de logradouros carregados não é igual ao planejado pela interface");
	}

}
