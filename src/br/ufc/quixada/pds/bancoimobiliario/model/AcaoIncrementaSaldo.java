package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoIncrementaSaldo extends AcaoModificarSaldo{

	@Override
	public void executar(Jogador jogador) throws JogadorComSaldoNegativoException {
		
		try {
			jogador.acrescentarSaldo(this.getValorASerModificado());
		} catch (ValorInvalidoException e) {
			//TODO : 
		}
	}
	

}
