package br.ufc.quixada.pds.bancoimobiliario.model;

public class Copo {
	// TODO : Validar o valor dos dados
	
	private int valorDosDados;
	
	public void lancarDados(int valorDosDados){
		
		this.valorDosDados = valorDosDados;
	}
	
	public int obterValorDosDados(){
		return valorDosDados;
	}
}
