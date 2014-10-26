package br.ufc.quixada.pds.bancoimobiliario.model;


public abstract class Propriedade extends Logradouro{

	private double valorDaPropriedade;
	private boolean adquirida;
	private Jogador donoDaPropriedade;
	
	public Propriedade(){
		this.adquirida = false;
	}
	
	public void setValorDaPropriedade(double valor){
		this.valorDaPropriedade = valor;
	}
	
	public Jogador getDonoDaPropriedade(){
		return this.donoDaPropriedade;
	}
	//TODO métodos de propriedade
	
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
