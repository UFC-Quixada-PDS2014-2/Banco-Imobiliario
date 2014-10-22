package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tabuleiro {
	
	private List<Logradouro> logradouros;
	
	public Tabuleiro(){
		logradouros = new ArrayList<Logradouro>();
	}

	List<Logradouro> getLogradouros(){
		return this.logradouros;
	}
	
	public List<Logradouro> getCasasDoTabuleiro(){
		return Collections.unmodifiableList(this.logradouros);
	}
	
	public Logradouro pegarPontoDePartida(){
		return this.logradouros.get(0);
	}
	
	public Logradouro obterLogradouro(Logradouro logradouroBase, int deslocamento){
		int posicaoLogradouroBase = logradouros.indexOf(logradouroBase);
		int novaPosicao;
		if(posicaoLogradouroBase + deslocamento >= logradouros.size()){
			novaPosicao = posicaoLogradouroBase + deslocamento - logradouros.size();	
		} else{
			novaPosicao = posicaoLogradouroBase + deslocamento;
		}
		return logradouros.get(novaPosicao);
	}
}
