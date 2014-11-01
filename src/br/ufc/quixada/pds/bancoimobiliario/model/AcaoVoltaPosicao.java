package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoVoltaPosicao implements AcaoLugarEspecial{

	private int quantidadeDePosicoes;
	
	@Override
	public void executar(Jogador jogador) throws ValorInvalidoException{
		jogador.voltarPosicaoJogador(quantidadeDePosicoes);
	}
	
	public void setQuantidadeDePosicoes(int qtd){
		// TODO : Remover apos testes
		
		this.quantidadeDePosicoes = qtd;
	}

}
