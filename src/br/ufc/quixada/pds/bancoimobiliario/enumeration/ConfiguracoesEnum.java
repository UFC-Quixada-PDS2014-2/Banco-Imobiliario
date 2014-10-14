package br.ufc.quixada.pds.bancoimobiliario.enumeration;

public enum ConfiguracoesEnum {
	
	NUMERO_CASAS(40);
	
	private ConfiguracoesEnum(int valor) {
		this.valor = valor;
	}
	
	private int valor; 
	
	public int getValor(){
		return this.valor;
	}
	
}
