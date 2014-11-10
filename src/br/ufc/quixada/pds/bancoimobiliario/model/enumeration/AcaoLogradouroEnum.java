package br.ufc.quixada.pds.bancoimobiliario.model.enumeration;

public enum AcaoLogradouroEnum {
	
	
	POSICAO_INALTERADA, AVANCA_POSICAO, VOLTA_POSICAO, PERTENCE_AO_JOGADOR,
	DISPONIVEL_PARA_COMPRA, AUMENTA_SALDO, DECREMENTA_SALDO, PAGAR_ALUGUEL, PAGAR_TAXA_EMPRESA;  
	
	private String mensagemAcao;

	public void setMensagem(String mensagem){
		this.mensagemAcao = mensagem;
	}
	
	public String getMensagem(){
		return this.mensagemAcao;
	}

}
