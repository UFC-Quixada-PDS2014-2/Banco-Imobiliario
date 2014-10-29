package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

public interface BancoImobiliario {

	public void realizarTurnoJogador(int valorDados) throws FimDeJogoException;
	public Iterator<Jogador> obterJogadores();
	public List<Logradouro> getCasasDoTabuleiro();
	public Jogador pegarJogadorDaVez();
	
}
