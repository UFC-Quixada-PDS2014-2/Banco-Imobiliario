package br.ufc.quixada.pds.bancoImobiliario.model;

import java.util.LinkedList;
import java.util.List;

public class Tabuleiro {
	
	List<Logradouro> logradouros;
	
	public Tabuleiro(){
		logradouros = new LinkedList<Logradouro>();
	}
	
	public Logradouro obterLogradouro(Logradouro logradouroBase, int deslocamento){
		int posicaoLogradouroBase = logradouros.indexOf(logradouroBase);
		return logradouros.get(posicaoLogradouroBase + deslocamento);
	}
}
