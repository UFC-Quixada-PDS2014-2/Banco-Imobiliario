package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;

public abstract class AcaoModificarSaldo implements AcaoLugarEspecial{

	private int valorASerModificado;
	
	@Override
	abstract public void executar(Jogador jogador) throws JogadorComSaldoNegativoException;
	
	
	protected int getValorASerModificado(){
		return this.valorASerModificado;
	}
	

}
