package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

public class BancoImobiliario {

	// TODO : adicionar injeção de dependências
	private List<Jogador> jogadores;
	private Tabuleiro tabuleiro;
	private Copo copo;

	public BancoImobiliario(List<Jogador> jogadores, Tabuleiro tabuleiro, Copo copo){
		this.jogadores = jogadores;
		this.tabuleiro = tabuleiro;
		this.copo = copo;
	}
	
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
	
	public List<Logradouro> getCasasDoTabuleiro(){
		return this.tabuleiro.getCasasDoTabuleiro();
	}
}
