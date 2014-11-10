package br.ufc.quixada.pds.bancoimobiliario.model.lugarespecial;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class AcaoDecrementaSaldo implements AcaoLugarEspecial{
	
	private double valorASerModificado;
	
	public AcaoDecrementaSaldo(double valorAserModificado) {
		this.valorASerModificado = valorAserModificado;
	}
	
	@Override
	public void executar(Jogador jogador)throws JogadorComSaldoNegativoException, ValorInvalidoException {
			jogador.decrementarSaldo(this.valorASerModificado);
	}
}