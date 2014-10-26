package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

public class BancoImobiliarioImpl implements BancoImobiliario{

	private List<Jogador> jogadores;
	private Jogador jogadorDaVez;
	private Tabuleiro tabuleiro;
	
	public BancoImobiliarioImpl(List<Jogador> jogadores, Tabuleiro tabuleiro){
		this.jogadores = jogadores;
		this.tabuleiro = tabuleiro;
		this.jogadorDaVez = this.jogadores.get(0);
	}
	
	@Override
	public void realizarTurnoJogador(int valorDados){
		Logradouro logradouro = this.tabuleiro.percorrerTabuleiro(this.jogadorDaVez, valorDados);
		
		try {
			logradouro.acaoLogradouro(jogadorDaVez);
		} catch (JogadorComSaldoNegativoException | ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO Mudar jogadorDaVez
	}
	
	@Override
	public Iterator<Jogador> obterJogadores(){
		return jogadores.iterator();
	}
	
	@Override
	public List<Logradouro> getCasasDoTabuleiro(){
		return this.tabuleiro.getCasasDoTabuleiro();
	}

	@Override
	public Jogador pegarJogadorDaVez(){
		return this.jogadorDaVez;
	}

}
