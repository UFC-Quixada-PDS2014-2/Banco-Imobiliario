package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoIncrementaSaldo implements AcaoLugarEspecial{

	private int valorASerModificado;
	
	@Override
	public void executar(Jogador jogador) throws JogadorComSaldoNegativoException {
		
		try {
			jogador.acrescentarSaldo(this.valorASerModificado);
		
		} catch (ValorInvalidoException e) {
			//TODO : 
		}
	}
	

}
