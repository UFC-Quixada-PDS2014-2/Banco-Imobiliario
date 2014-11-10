package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class Empresa extends Propriedade {

	private double valorDaTaxa;

	public Empresa(double valorDaPropriedade, double valorDaTaxa) {
		super(valorDaPropriedade);
		this.valorDaTaxa = valorDaTaxa;
	}

	@Override
	public AcaoLogradouroEnum acaoLogradouro(Jogador jogador)
			throws JogadorComSaldoNegativoException, ValorInvalidoException {

		if (jogador.equals(this.getDonoDaPropriedade())) {

			String mensagem = "Essa empresa é sua!";
			AcaoLogradouroEnum acaoLogradouro = AcaoLogradouroEnum.PERTENCE_AO_JOGADOR;
			acaoLogradouro.setMensagem(mensagem);
			
			return acaoLogradouro;

		} else if (this.propriedadeEstaVendida()) {

		    double valorTotal = this.valorDaTaxa
					* jogador.getValorDoUltimoDeslocamento();

			Jogador donoDaPropriedade = this.getDonoDaPropriedade();

			jogador.decrementarSaldo(valorTotal);
			donoDaPropriedade.acrescentarSaldo(valorTotal);

			String mensagem = "Essa empresa possui dono\n" + 
							  "Você pagou R$" + valorTotal + " para o " + 
							  this.getDonoDaPropriedade().getNome();
			AcaoLogradouroEnum acaoLogradouro = AcaoLogradouroEnum.PAGAR_TAXA_EMPRESA;
			acaoLogradouro.setMensagem(mensagem);
			
			return acaoLogradouro;
		}
	
		String mensagem = "Empresa disponível para compra";
		AcaoLogradouroEnum acaoLogradouro = AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA;
		acaoLogradouro.setMensagem(mensagem);
		
		return acaoLogradouro;
	}

	@Override
	public void passeiPorAqui(Jogador jogador) {
		// TODO Auto-generated method stub
	}

	@Override
	public double getTaxa() {
		return this.valorDaTaxa;
	}
	
	@Override
	public String toString() {
		String mensagemFinal = "\nEmpresa\n";

		String nome = "Nome: " + this.getNome() + "\n";
		String valorDaPropriedade = "Preço: R$"
				+ String.format("%.2f", this.getValorDaPropriedade()) + "\n";
		String valorDaTaxa = "Taxa de Uso: R$"
				+ String.format("%.2f", this.valorDaTaxa) + "\n";
		String dono = "Dono: ";

		if (this.propriedadeEstaVendida()) {
			dono += this.getDonoDaPropriedade().getNome() + "\n";
		} else {
			dono += "Esta empresa não possui dono!\n";
		}

		mensagemFinal += nome + valorDaPropriedade + valorDaTaxa + dono;

		return mensagemFinal;
	}

}
