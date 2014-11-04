package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public interface Tabuleiro {

	public List<Logradouro> getCasasDoTabuleiro();
	public Logradouro getPontoDePartida();
	public Logradouro percorrerTabuleiro(Jogador jogador, int deslocamento) throws JogadorComSaldoNegativoException, ValorInvalidoException;
	public Logradouro pularPosicao(Jogador jogador, int posicaoAntiga) throws ValorInvalidoException, JogadorComSaldoNegativoException;
	
	
}
