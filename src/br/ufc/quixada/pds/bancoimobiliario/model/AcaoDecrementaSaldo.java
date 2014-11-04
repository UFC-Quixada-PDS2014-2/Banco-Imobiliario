package br.ufc.quixada.pds.bancoimobiliario.model;

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
