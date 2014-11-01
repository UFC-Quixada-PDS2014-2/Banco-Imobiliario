package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;

public class Empresa extends Propriedade {

	private double valorDaTaxa;

	@Override
	public AcaoLogradouroEnum acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
		
		if(jogador.isDonoDaPropriedade(this)){
			
			return AcaoLogradouroEnum.PERTENCE_AO_JOGADOR;
		
		} else if(this.propriedadeEstaVendida()){
			
			final double valorTotal = this.valorDaTaxa * jogador.pegarValorDoUltimoDeslocamento();
			
			Jogador donoDaPropriedade = this.pegarDonoDaPropriedade();
			
			jogador.decrementarSaldo(valorTotal);
			donoDaPropriedade.acrescentarSaldo(valorTotal);
			
			return AcaoLogradouroEnum.POSICAO_INALTERADA;
		}
		
		return AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA;
		
	}

	@Override
	public void passeiPorAqui(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}
	
	public void setValorDaTaxa(double valor){
		//TODO : Remover apos testes
		this.valorDaTaxa = valor;
	}
	
	

}
