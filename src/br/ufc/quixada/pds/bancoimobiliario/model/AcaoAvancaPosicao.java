package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoAvancaPosicao implements AcaoLugarEspecial{

	private int quantidadeDePosicoes;
	
	@Override
	public void executar(Jogador jogador) throws ValorInvalidoException{
		jogador.avancarPosicaoJogar(quantidadeDePosicoes);
	}
	
	public void setQuantidadeDePosicoes(int qtd){
		//TODO : Remover
		this.quantidadeDePosicoes = qtd;
	}
}
