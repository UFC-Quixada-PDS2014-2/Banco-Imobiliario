package br.ufc.quixada.pds.bancoimobiliario.model.exception;

public class LogradouroIndisponivelCompraException extends Exception{
	public LogradouroIndisponivelCompraException(){
		super("Propriedade já adquirida");
	}
}
