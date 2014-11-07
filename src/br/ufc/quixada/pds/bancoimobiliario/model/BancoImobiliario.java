package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.FimDeJogoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.PropriedadeJaVendidaException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public interface BancoImobiliario {

	public AcaoLogradouroEnum realizarTurnoJogador(int valorDosDados) throws FimDeJogoException, ErroArquivoConfiguracoesException;
	public Iterator<Jogador> getJogadores();
	public Iterator<Logradouro> getCasasDoTabuleiro();
	public Jogador getJogadorDaVez();
	public void comprarPropriedade(Propriedade propriedade) throws SaldoJogadorInsuficienteException, PropriedadeJaVendidaException, JogadorInvalidoException, FimDeJogoException, ErroArquivoConfiguracoesException;
	public Logradouro getLogradouroPelaPosicao(int posicao) throws ValorInvalidoException;
}
