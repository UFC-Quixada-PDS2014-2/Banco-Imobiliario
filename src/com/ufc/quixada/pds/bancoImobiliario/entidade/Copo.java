package com.ufc.quixada.pds.bancoImobiliario.entidade;

public class Copo {

	private int valorDosDados;
	
	public void lancarDados(int valorDosDados){
		
		this.valorDosDados = valorDosDados;
	}
	
	public int obterValorDosDados(){
		return valorDosDados;
	}
}
