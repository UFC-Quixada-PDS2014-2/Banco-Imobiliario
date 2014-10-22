package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.ArrayList;
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
	
	public Logradouro obterLogradouro(Logradouro logradouroBase, int deslocamento){
		int posicaoLogradouroBase = logradouros.indexOf(logradouroBase);
		return logradouros.get(posicaoLogradouroBase + deslocamento);
	}
}
