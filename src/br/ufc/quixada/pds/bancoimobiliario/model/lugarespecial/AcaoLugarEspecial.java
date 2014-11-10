package br.ufc.quixada.pds.bancoimobiliario.model.lugarespecial;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public interface AcaoLugarEspecial {
	public void executar(Jogador jogador) throws  JogadorComSaldoNegativoException, ValorInvalidoException;
}