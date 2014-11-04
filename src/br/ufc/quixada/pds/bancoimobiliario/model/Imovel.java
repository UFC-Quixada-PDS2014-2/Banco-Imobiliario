package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class Imovel extends Propriedade {

	private double valorDoAluguel;

	public Imovel(double valorDaPropriedade, double valorDoAluguel) {
		super(valorDaPropriedade);
		this.valorDoAluguel = valorDoAluguel;
	}
	
	@Override
	public AcaoLogradouroEnum acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
		
		if(jogador.equals(this.getDonoDaPropriedade())){
			
			return AcaoLogradouroEnum.PERTENCE_AO_JOGADOR;
			
		} else if(this.propriedadeEstaVendida()){	
			Jogador donoDaPropriedade = this.getDonoDaPropriedade();
			
			jogador.decrementarSaldo(valorDoAluguel);
			donoDaPropriedade.acrescentarSaldo(valorDoAluguel);
		
			return AcaoLogradouroEnum.POSICAO_INALTERADA;
		}
		return AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA;
	}

	@Override
	public void passeiPorAqui(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}
}
