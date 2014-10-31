package br.ufc.quixada.pds.bancoimobiliario.model;

import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;

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
	public Logradouro getPontoDePartida(){
		return this.logradouros.get(0);
	}
	
	@Override
	public Logradouro percorrerTabuleiro(Jogador jogador, int deslocamento) throws JogadorComSaldoNegativoException, ValorInvalidoException{
		
		int deslocamentoJogador = deslocamento;
		
		while(deslocamentoJogador > 0){
			jogador.avancarPosicaoJogar(1);

			Logradouro logradouro = getLogradouroPorPosicao(jogador.getPosicao());
			logradouro.passeiPorAqui(jogador);
			
			deslocamentoJogador--;
		}
		
		return logradouros.get(jogador.getPosicao());
	}
	
	

	private  Logradouro getLogradouroPorPosicao(int posicao){
		return this.logradouros.get(posicao);
	}

	@Override
	public Logradouro pularPosicao(Jogador jogador, int posicaoAntiga) throws ValorInvalidoException, JogadorComSaldoNegativoException {

		int posicaoCursor = posicaoAntiga;
		
		while(posicaoCursor != jogador.getPosicao()){
			posicaoCursor = (posicaoCursor + 1) % ConfiguracoesEnum.NUMERO_CASAS.getValor();
			
			Logradouro logradouro = logradouros.get(posicaoCursor);
			logradouro.passeiPorAqui(jogador);
			
		}
		
		return logradouros.get(jogador.getPosicao());
	}

}
