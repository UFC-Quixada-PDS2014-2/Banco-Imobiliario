package br.ufc.quixada.pds.bancoimobiliario.model.enumeration;

public enum ConfiguracoesEnum {
	
	NUMERO_CASAS(40), VALOR_INCREMENTO_PONTODEPARTIDA(200), 
	NUMERO_JOGADORES(2), SALDO_INICIAL(1000)
	, POSICAO_INICIAL(0), SENTIDO_AVANCAR(1), SENTIDO_VOLTAR(-1), 
	CREDITAR(1), DEBITAR(-1);
	
	
	private ConfiguracoesEnum(int valor) {
		this.valor = valor;
	}
	
	private int valor; 
	
	public int getValor(){
		return this.valor;
	}
	
}
