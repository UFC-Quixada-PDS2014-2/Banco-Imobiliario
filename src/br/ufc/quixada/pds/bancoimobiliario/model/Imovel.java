package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;

public class Imovel extends Propriedade {

	private double valorDoAluguel;

	@Override
	public AcaoLogradouroEnum acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
		
		if(jogador.isDonoDaPropriedade(this)){
			
			return AcaoLogradouroEnum.PERTENCE_AO_JOGADOR;
			
		} else if(this.propriedadeEstaVendida()){	
			Jogador donoDaPropriedade = this.pegarDonoDaPropriedade();
			
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
	
	public void setValorAluguel(double valor){
		//TODO : Remover apos testes
		this.valorDoAluguel = valor;
	}
	
	
	
}
