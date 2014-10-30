package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoDecrementaSaldo implements AcaoLugarEspecial{
	
	private int valorASerModificado;
	
	@Override
	public void executar(Jogador jogador)throws JogadorComSaldoNegativoException {
		
		try {
			jogador.decrementarSaldo(this.valorASerModificado);
			
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
		
		}
	}

}
