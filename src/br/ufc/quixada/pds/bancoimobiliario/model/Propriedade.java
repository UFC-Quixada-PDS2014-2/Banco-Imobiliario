package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.LogradouroIndisponivelCompraException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;


public abstract class Propriedade extends Logradouro{

	final private double valorDaPropriedade;
	private boolean adquirida;
	private Jogador donoDaPropriedade;
	
	public Propriedade(double valorDaPropriedade){
		this.valorDaPropriedade = valorDaPropriedade;
		this.adquirida = false;
	}
	
	public Jogador getDonoDaPropriedade(){
		return this.donoDaPropriedade;
	}
	
	public double getValorDaPropriedade(){
		return this.valorDaPropriedade;
	}
	
	@Override
	public boolean isDisponivelParaCompra() {
		if(propriedadeEstaVendida()){
			return false;
		} else{
			return true;
		}
	}
	
	public void comprarPropriedade(Jogador compradorDaPropriedade) throws SaldoJogadorInsuficienteException, LogradouroIndisponivelCompraException, JogadorInvalidoException, JogadorComSaldoNegativoException, ValorInvalidoException{
		
		if(compradorDaPropriedade == null){
			throw new JogadorInvalidoException();
		}
		
		if(!propriedadeEstaVendida()){
			if(compradorDaPropriedade.getSaldo() >= this.valorDaPropriedade){
				compradorDaPropriedade.decrementarSaldo(this.valorDaPropriedade);
				compradorDaPropriedade.adicionarPropriedadeAdquirida(this);
				this.donoDaPropriedade = compradorDaPropriedade;
				this.adquirida = true;
			}else{
				throw new SaldoJogadorInsuficienteException();
			}
		}else{
			throw new LogradouroIndisponivelCompraException();
		}
	}
	
	public boolean propriedadeEstaVendida(){
		return this.adquirida;
	}
}
