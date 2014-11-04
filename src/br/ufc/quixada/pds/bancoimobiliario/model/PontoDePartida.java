package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class PontoDePartida extends Logradouro {

	@Override
	public AcaoLogradouroEnum acaoLogradouro(Jogador jogador) {
		return AcaoLogradouroEnum.POSICAO_INALTERADA; 
	}

	@Override
	public void passeiPorAqui(Jogador jogador) throws ValorInvalidoException {
			jogador.acrescentarSaldo(ConfiguracoesEnum.VALOR_INCREMENTO_PONTODEPARTIDA.getValor());
	}

	

}
