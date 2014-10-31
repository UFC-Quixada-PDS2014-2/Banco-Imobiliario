package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoIncrementaSaldo implements AcaoLugarEspecial{

	private int valorASerModificado;
	
	@Override
	public void executar(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
		
			jogador.acrescentarSaldo(this.valorASerModificado);
	}
}
