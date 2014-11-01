package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoIncrementaSaldo implements AcaoLugarEspecial{

	final private double valorASerModificado;

	public AcaoIncrementaSaldo(double valorASerModificado) {
		this.valorASerModificado = valorASerModificado;
	}
	
	@Override
	public void executar(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
			jogador.acrescentarSaldo(this.valorASerModificado);
	}
}
