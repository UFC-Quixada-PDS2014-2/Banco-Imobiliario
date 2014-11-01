package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoDecrementaSaldo implements AcaoLugarEspecial{
	
	private double valorASerModificado;
	
	@Override
	public void executar(Jogador jogador)throws JogadorComSaldoNegativoException, ValorInvalidoException {
			jogador.decrementarSaldo(this.valorASerModificado);
	}

	public void setValorASerModificado(double valor){
		//TODO : Remover apos testes
		this.valorASerModificado = valor;
	}
}
