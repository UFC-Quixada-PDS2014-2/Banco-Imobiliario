package br.ufc.quixada.pds.bancoimobiliario.model;

public class Empresa extends Propriedade {

	private double valorDaTaxa;

	@Override
	public void acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
		
		if(this.propriedadeEstaVendida()){
			final double valorTotal = this.valorDaTaxa * jogador.pegarValorDoUltimoDeslocamento();
			
			Jogador donoDaPropriedade = this.pegarDonoDaPropriedade();
			
			jogador.decrementarSaldo(valorTotal);
			donoDaPropriedade.acrescentarSaldo(valorTotal);
		}
		
	}

	@Override
	public void passeiPorAqui(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}
	
	

}
