package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.FimDeJogoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.PropriedadeJaVendidaException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public abstract class BancoImobiliario extends Observable{

	public abstract AcaoLogradouroEnum realizarTurnoJogador(int valorDosDados) throws FimDeJogoException, ErroArquivoConfiguracoesException, GameOverJogadorException;
	public abstract Iterator<Jogador> getJogadores();
	public abstract Iterator<Logradouro> getCasasDoTabuleiro();
	public abstract Jogador getJogadorDaVez();
	public abstract void comprarPropriedade(Propriedade propriedade) throws SaldoJogadorInsuficienteException, PropriedadeJaVendidaException, JogadorInvalidoException, FimDeJogoException, ErroArquivoConfiguracoesException;
	public abstract Logradouro getLogradouroPelaPosicao(int posicao) throws ValorInvalidoException;
}
