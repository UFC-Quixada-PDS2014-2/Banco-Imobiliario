package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoDecrementaSaldo extends AcaoModificarSaldo{

	@Override
	public void executar(Jogador jogador)throws JogadorComSaldoNegativoException {
		
		try {
			jogador.decrementarSaldo(this.getValorASerModificado());
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
		
		}
	}

}
