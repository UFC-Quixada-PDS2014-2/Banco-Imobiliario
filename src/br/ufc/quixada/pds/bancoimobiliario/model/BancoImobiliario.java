package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

public interface BancoImobiliario {

	public void realizarTurnoJogador(int valorDados) throws FimDeJogoException, ErroArquivoConfiguracoesException;
	public Iterator<Jogador> obterJogadores();
	public Iterator<Logradouro> getCasasDoTabuleiro();
	public Jogador pegarJogadorDaVez();
	public void mudarJogadorDaVez();
	
}
