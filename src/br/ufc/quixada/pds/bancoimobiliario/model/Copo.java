package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.exception.ValorDosDadosInvalidosException;

public class Copo {
	
	private int valorDosDados;
	
	public void lancarDados(int valorDosDados) throws ValorDosDadosInvalidosException{
		
		if(valorDosDados >= 2 && valorDosDados <= 12){
			this.valorDosDados = valorDosDados;
		} else{
			throw new ValorDosDadosInvalidosException("O valor dos dados devem estar entre 2 e 12");
		}
	}
	
	public int obterValorDosDados(){
		return valorDosDados;
	}
}
