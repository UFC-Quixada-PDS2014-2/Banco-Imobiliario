package br.ufc.quixada.pds.bancoimobiliario.enumeration;

public enum ConfiguracoesEnum {
	
	NUMERO_CASAS(40), NUMERO_JOGADORES(2), SALDO_INICIAL(1000)
	, POSICAO_INICIAL(0), SENTIDO_AVANCAR(1), SENTIDO_VOLTAR(-1);
	
	
	private ConfiguracoesEnum(int valor) {
		this.valor = valor;
	}
	
	private int valor; 
	
	public int getValor(){
		return this.valor;
	}
	
}
