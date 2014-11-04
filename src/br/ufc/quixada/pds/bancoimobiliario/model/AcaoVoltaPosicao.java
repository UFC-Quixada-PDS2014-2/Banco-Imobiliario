package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoVoltaPosicao implements AcaoLugarEspecial{

	private int quantidadeDePosicoes;
	
	public AcaoVoltaPosicao(int quantidadeDePosicoes) {
		this.quantidadeDePosicoes = quantidadeDePosicoes;
	}
	
	@Override
	public void executar(Jogador jogador) throws ValorInvalidoException{
		jogador.voltarPosicaoJogador(quantidadeDePosicoes);
	}
}
