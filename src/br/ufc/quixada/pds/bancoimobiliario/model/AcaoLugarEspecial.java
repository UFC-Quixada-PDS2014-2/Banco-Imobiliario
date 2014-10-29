package br.ufc.quixada.pds.bancoimobiliario.model;

public interface AcaoLugarEspecial {
	public void executar(Jogador jogador) throws  JogadorComSaldoNegativoException;
}
