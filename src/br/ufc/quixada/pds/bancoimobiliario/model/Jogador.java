package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.List;

public interface Jogador {


	public void atualizarPosicao(int deslocamentoPosicao);
	public void acrescentarSaldo(double saldo);
	public void decrementarSaldo(double saldo);
	public String getNome();
	public double getSaldo();
	public int getPosicao();
	public List<Propriedade> getPropriedadesAdquiridas();
	
}
