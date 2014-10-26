package br.ufc.quixada.pds.bancoimobiliario.model;

public class Imovel extends Propriedade {

	private double valorDoAluguel;

	@Override
	public void acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
		
		if(this.propriedadeEstaVendida()){
			
			Jogador donoDaPropriedade = this.getDonoDaPropriedade();
			
			jogador.decrementarSaldo(valorDoAluguel);
			donoDaPropriedade.acrescentarSaldo(valorDoAluguel);
		}
		
	}

	@Override
	public void passeiPorAqui(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
