package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;

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
