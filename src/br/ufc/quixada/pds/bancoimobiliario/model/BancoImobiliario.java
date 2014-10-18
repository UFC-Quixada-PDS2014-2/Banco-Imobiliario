package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

public class BancoImobiliario {

	// TODO :
	private List<Jogador> jogadores;
	private Tabuleiro tabuleiro;
	private Copo copo;
	
	public void realizarRodada(){
		Iterator<Jogador> jogadores = this.obterJogadores();
		while(jogadores.hasNext()){
			realizarTurnoJogador(jogadores.next());
		}
	}
	
	public void realizarTurnoJogador(Jogador jogador){
		int valorDados = copo.obterValorDosDados();
		jogador.atualizarPosicao(valorDados);
		
	}
	
	public Iterator<Jogador> obterJogadores(){
		return jogadores.iterator();
	}
}
