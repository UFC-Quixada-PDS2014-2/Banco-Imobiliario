package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoVoltaPosicao implements AcaoLugarEspecial{

	private int quantidadeDePosicoes;
	
	@Override
	public void executar(Jogador jogador){
		
		jogador.voltarPosicaoJogador(quantidadeDePosicoes);
	}

}
