package br.ufc.quixada.pds.bancoimobiliario.model.lugarespecial;

import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class LugarEspecial extends Logradouro {
	private List<AcaoLugarEspecial> listaDeAcoes;
	private String tipoDeAcao;
	
	@Override
	public AcaoLogradouroEnum acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
		for (AcaoLugarEspecial acaoLugarEspecial : listaDeAcoes) {
			acaoLugarEspecial.executar(jogador);
		}
		return AcaoLogradouroEnum.valueOf(tipoDeAcao);
	}

	@Override
	public void passeiPorAqui(Jogador jogador) {
		// TODO Auto-generated method stub
	}
}