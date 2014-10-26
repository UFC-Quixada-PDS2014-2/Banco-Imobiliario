package br.ufc.quixada.pds.bancoimobiliario.model;

public abstract class Logradouro {

	private String nome;
	
	public String obterNome(){
		return this.nome;
	}
	
	public abstract void acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException;
	
	public abstract void passeiPorAqui(Jogador jogador);
	
}
