package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoDecrementaSaldo implements AcaoLugarEspecial{
	
	private int valorASerModificado;
	
	@Override
	public void executar(Jogador jogador)throws JogadorComSaldoNegativoException, ValorInvalidoException {
			jogador.decrementarSaldo(this.valorASerModificado);
	}

}
