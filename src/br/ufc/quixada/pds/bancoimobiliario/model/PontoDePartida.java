package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;

public class PontoDePartida extends Logradouro {

	@Override
	public void acaoLogradouro(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passeiPorAqui(Jogador jogador) {
		
		try {
			jogador.acrescentarSaldo(ConfiguracoesEnum.VALOR_INCREMENTO_PONTODEPARTIDA.getValor());
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
