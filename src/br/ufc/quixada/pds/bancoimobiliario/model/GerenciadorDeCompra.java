package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;

import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.LogradouroIndisponivelCompraException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public interface GerenciadorDeCompra {

	public void comprarPropriedade(Jogador compradorDaPropriedade, Logradouro logradouro) throws LogradouroIndisponivelCompraException, SaldoJogadorInsuficienteException, JogadorInvalidoException, JogadorComSaldoNegativoException, ValorInvalidoException;
	public Iterator<Imovel> getImoveisDoJogador(Jogador jogador);
	public Iterator<Empresa> getEmpresasDoJogador(Jogador jogador);
}
