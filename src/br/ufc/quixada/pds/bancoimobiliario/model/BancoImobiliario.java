package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

public interface BancoImobiliario {

	public void realizarTurnoJogador(int valorDosDados) throws FimDeJogoException, ErroArquivoConfiguracoesException;
	public Iterator<Jogador> getJogadores();
	public Iterator<Logradouro> getCasasDoTabuleiro();
	public Jogador getJogadorDaVez();
	public void mudarJogadorDaVez();
	
}
