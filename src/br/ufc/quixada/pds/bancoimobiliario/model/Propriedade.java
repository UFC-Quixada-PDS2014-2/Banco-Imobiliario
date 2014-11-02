package br.ufc.quixada.pds.bancoimobiliario.model;


public abstract class Propriedade extends Logradouro{

	final private double valorDaPropriedade;
	private boolean adquirida;
	private Jogador donoDaPropriedade;
	
	public Propriedade(double valorDaPropriedade){
		this.valorDaPropriedade = valorDaPropriedade;
		this.adquirida = false;
	}
	
	public Jogador pegarDonoDaPropriedade(){
		return this.donoDaPropriedade;
	}
	
	public void comprarPropriedade(Jogador compradorDaPropriedade) throws SaldoJogadorInsuficienteException, PropriedadeJaVendidaException, JogadorInvalidoException, JogadorComSaldoNegativoException, ValorInvalidoException{
		
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
			throw new PropriedadeJaVendidaException();
		}
	}
	
	public boolean propriedadeEstaVendida(){
		return this.adquirida;
	}
}
