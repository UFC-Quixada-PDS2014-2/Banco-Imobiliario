package br.ufc.quixada.pds.bancoimobiliario.model.lugarespecial;

import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.LogradouroIndisponivelCompraException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class LugarEspecial extends Logradouro {
	private List<AcaoLugarEspecial> listaDeAcoes;
	private String tipoDeAcao;
	private String mensagemDeAcao;
	
	@Override
	public AcaoLogradouroEnum acaoLogradouro(Jogador jogador) throws JogadorComSaldoNegativoException, ValorInvalidoException {
		for (AcaoLugarEspecial acaoLugarEspecial : listaDeAcoes) {
			acaoLugarEspecial.executar(jogador);
		}

		AcaoLogradouroEnum acaoLogradouro = AcaoLogradouroEnum.valueOf(tipoDeAcao);
		
		return acaoLogradouro;
	}

	@Override
	public String getMensagemDeAcao(Jogador jogadorDaVez) {
		return this.mensagemDeAcao;
	}
	
	@Override
	public void passeiPorAqui(Jogador jogador) {

	}
	
	@Override
	public String toString() {
		String mensagemFinal = "Lugar Especial\n";
		mensagemFinal += super.toString();
		return mensagemFinal;
	}

	@Override
	public boolean isDisponivelParaCompra() {
		return false;
	}

	@Override
	public void comprarLogradouro(Jogador compradorDoLogradouro) throws LogradouroIndisponivelCompraException {
		throw new LogradouroIndisponivelCompraException();
	}
}