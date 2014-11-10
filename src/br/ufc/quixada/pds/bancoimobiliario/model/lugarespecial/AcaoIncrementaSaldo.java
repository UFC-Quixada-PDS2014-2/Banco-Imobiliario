package br.ufc.quixada.pds.bancoimobiliario.model.lugarespecial;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class AcaoIncrementaSaldo implements AcaoLugarEspecial{

	private double valorASerModificado;

	public AcaoIncrementaSaldo(double valorASerModificado) {
		this.valorASerModificado = valorASerModificado;
	}
	
	@Override
	public void executar(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
			jogador.acrescentarSaldo(this.valorASerModificado);
	}
}