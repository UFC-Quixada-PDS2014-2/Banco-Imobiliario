package br.ufc.quixada.pds.bancoimobiliario.model.enumeration;

public enum ConfiguracoesEnum {
	
	NUMERO_CASAS(28), NUMERO_JOGADORES(2), SALDO_INICIAL(1000)
	, POSICAO_INICIAL(0);
	
	
	private ConfiguracoesEnum(int valor) {
		this.valor = valor;
	}
	
	private int valor; 
	
	public int getValor(){
		return this.valor;
	}
	
}
