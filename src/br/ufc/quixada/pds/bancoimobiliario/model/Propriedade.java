package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.exception.PropriedadeJaVendidaException;
import br.ufc.quixada.pds.bancoimobiliario.exception.SaldoJogadorInsuficienteException;

public abstract class Propriedade extends Logradouro{

	private double valorDaPropriedade;
	private boolean adquirida;
	private Jogador donoDaPropriedade;
	
	public Propriedade(){
		this.adquirida = false;
	}
	
	//TODO métodos de propriedade
	
	public void comprarPropriedade(Jogador compradorDaPropriedade) throws SaldoJogadorInsuficienteException, PropriedadeJaVendidaException{
		if(!propriedadeEstaVendida()){
			if(compradorDaPropriedade.getSaldo() >= this.valorDaPropriedade){
				compradorDaPropriedade.decrementarSaldo(this.valorDaPropriedade);
				this.donoDaPropriedade = compradorDaPropriedade;
				this.adquirida = true;
			}else{
				throw new SaldoJogadorInsuficienteException();
			}
		}else{
			throw new PropriedadeJaVendidaException();
		}
	}
	
	public boolean propriedadeEstaVendida(){
		return this.adquirida;
	}
	
}
