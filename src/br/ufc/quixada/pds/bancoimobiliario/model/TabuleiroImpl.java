package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;

public class TabuleiroImpl implements Tabuleiro{
	
	private List<Logradouro> logradouros;
	
	public TabuleiroImpl(){
		logradouros = new ArrayList<Logradouro>();
	}

	List<Logradouro> getLogradouros(){
		return this.logradouros;
	}

	@Override
	public List<Logradouro> getCasasDoTabuleiro(){
		return Collections.unmodifiableList(this.logradouros);
	}
	
	@Override
	public Logradouro pegarPontoDePartida(){
		return this.logradouros.get(0);
	}
	
	@Override
	public Logradouro percorrerTabuleiro(int posicaoBase, int deslocamento){
		
		int posicaoJogador = posicaoBase;
		int deslocamentoJogador = deslocamento;
		
		while(deslocamentoJogador > 0){
			posicaoJogador++;
			if(posicaoJogador >= ConfiguracoesEnum.NUMERO_CASAS.getValor()){
				posicaoJogador -= ConfiguracoesEnum.NUMERO_CASAS.getValor();
			}

			Logradouro logradouro = getLogradouroPorPosicao(posicaoJogador);
			logradouro.passeiPorAqui();
			
			deslocamentoJogador--;
		}

		return logradouros.get(posicaoJogador);
	}

	private  Logradouro getLogradouroPorPosicao(int posicao){
		return this.logradouros.get(posicao);
	}

}
