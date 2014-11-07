package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class PontoDePartida extends Logradouro {

	private double valorASerIncrementado;
	
	public PontoDePartida(double valorASerIncrementado) {
		this.valorASerIncrementado = valorASerIncrementado;
	}
	@Override
	public AcaoLogradouroEnum acaoLogradouro(Jogador jogador) throws ValorInvalidoException {
		return AcaoLogradouroEnum.POSICAO_INALTERADA; 
	}

	@Override
	public void passeiPorAqui(Jogador jogador) throws ValorInvalidoException {
			jogador.acrescentarSaldo(this.valorASerIncrementado);
	}
	
	@Override
	public boolean isDisponivelParaCompra() {
		return false;
	}
	@Override
	public void comprarLogradouro(Jogador compradorDoLogradouro) {
		//TODO : 
	}

}

