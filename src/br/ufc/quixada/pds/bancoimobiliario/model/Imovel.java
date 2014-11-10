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
			
			String mensagem = "Este imóvel é seu!";
			
			return AcaoLogradouroEnum.PERTENCE_AO_JOGADOR;
			
		} else if(this.propriedadeEstaVendida()){	
			Jogador donoDaPropriedade = this.getDonoDaPropriedade();
			
			jogador.decrementarSaldo(valorDoAluguel);
			donoDaPropriedade.acrescentarSaldo(valorDoAluguel);
		
			String mensagem = "Imóvel possui dono\n" + 
							  "Você pagou R$ " + 
							  String.format("%.2f", this.valorDoAluguel)
							  + " ao jogador " + 
							  this.getDonoDaPropriedade().getNome();
			
			return AcaoLogradouroEnum.PAGAR_ALUGUEL;
		}
		
		String mensagem = "Disponível para compra";

		return AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA;
	}


	@Override
	public String getMensagemDeAcao(Jogador jogadorDaVez) {

		String mensagem;
		
		if (jogadorDaVez.equals(this.getDonoDaPropriedade())) {

			mensagem = "Esse imóvel é seu!";

			return mensagem;
			
		} else if (this.propriedadeEstaVendida()) {
			mensagem = "Imóvel possui dono\n" + 
							  "Você pagou R$ " + 
							  String.format("%f.2", this.valorDoAluguel)
							  + " ao jogador " + 
							  this.getDonoDaPropriedade().getNome();
			
			return mensagem;
		}
	
		mensagem = "Imóvel disponível para compra";

		return mensagem;
	}

	
	@Override
	public void passeiPorAqui(Jogador jogador) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		String mensagemFinal = "\nImóvel\n";
		
		String nome = "Nome: " + this.getNome() + "\n";
		String valorDaPropriedade = "Preço: R$" + String.format("%.2f", this.getValorDaPropriedade()) + "\n";
		String valorDoAluguel = "Aluguel: R$" + String.format("%.2f", this.valorDoAluguel) + "\n";
		String dono = "Dono: ";
		
		if(this.propriedadeEstaVendida()){
			dono +=  this.getDonoDaPropriedade().getNome() + "\n";
		} else{
			dono += "Este imovel não possui dono!\n"; 
		}
		
		mensagemFinal += nome + valorDaPropriedade + valorDoAluguel + dono;
		
		return mensagemFinal;
	}

	@Override
	public double getTaxa() {
		return this.valorDoAluguel;
	}
	
}
