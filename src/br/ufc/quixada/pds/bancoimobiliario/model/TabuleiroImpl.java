package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class TabuleiroImpl implements Tabuleiro{
	
	private List<Logradouro> logradouros;
	
	public TabuleiroImpl(){
		logradouros = new ArrayList<Logradouro>();
	}

	public void addLogradouro(Logradouro logradouro){
		this.logradouros.add(logradouro);
	}

	@Override
	public Iterator<Logradouro> getCasasDoTabuleiro(){
		return this.logradouros.iterator();
	}
	
	@Override
	public Logradouro getPontoDePartida(){
		return this.logradouros.get(0);
	}
	
	@Override
	public Logradouro percorrerTabuleiro(Jogador jogador, int deslocamento) throws JogadorComSaldoNegativoException, ValorInvalidoException{
		
		int deslocamentoJogador = deslocamento;
		
		while(deslocamentoJogador > 0){
			jogador.avancarPosicaoJogador(1);

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

	@Override
	public Logradouro getLogradouroPelaPosicao(int posicao) throws ValorInvalidoException {
		
		if(posicao < 0 || posicao > this.logradouros.size() - 1){
			throw new ValorInvalidoException();
		}
		
		return this.logradouros.get(posicao);
	}
}