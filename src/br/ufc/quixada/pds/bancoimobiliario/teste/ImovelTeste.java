package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.PropriedadeJaVendidaException;
import br.ufc.quixada.pds.bancoimobiliario.model.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.ValorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;

public class ImovelTeste {

	@Test
	public void verifiaAcaoExecutadaEmImovelSemDono() {
		
		Jogador jogador = new JogadorImpl("Teste", 500);
		Imovel imovel = new Imovel();
		
		try {
			AcaoLogradouroEnum acao = imovel.acaoLogradouro(jogador);
			
			assertEquals(AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA, acao);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void JogadorSemSaldoTentaComprarImovel(){
		
		final double saldoInicial = 500;
		final double valorImovel = 600;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		Imovel imovel = new Imovel();
		imovel.setValorDaPropriedade(valorImovel);
		
		try {
			imovel.comprarPropriedade(jogador);
			fail("Deveria Ter Disparado a Exception JogadorComSaldoNegativo");
		} catch (Exception e) {

			final String mensagemEsperada = "O Jogador não possui saldo suficiente para comprar essa propriedade.";
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void testaSaldoDosJogadoresAposPararEmUmImovelComDono(){
		
		final double saldoInicial = 1000.00;
		final double valorImovel = 500.00;
		final double valorAluguel = 60.00;
		
		Jogador jogador1 = new JogadorImpl("Teste", saldoInicial);
		Jogador jogador2 = new JogadorImpl("Teste2", saldoInicial);
		
		Imovel imovel = new Imovel();
		imovel.setValorDaPropriedade(valorImovel);
		imovel.setValorAluguel(valorAluguel);
		
		try {
			imovel.comprarPropriedade(jogador1);
			imovel.acaoLogradouro(jogador2);
			
			final double valorFinalEsperadoJogador1 = (saldoInicial - valorImovel) + valorAluguel;
			final double valorFinalEsperadoJogador2 = saldoInicial - valorAluguel;
			
			assertEquals(valorFinalEsperadoJogador1, jogador1.getSaldo(), 0.00);
			assertEquals(valorFinalEsperadoJogador2, jogador2.getSaldo(), 0.00);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void jogadorFicaSemSaldoAposPararEmImovelComDono(){
		
		final double saldoInicialJogador1 = 2000.00;
		final double saldoInicialJogador2 = 200.00;
		final double valorDoImovel = 1000.00;
		final double valorDoAluguel = 300.00;
		
		Jogador jogador1 = new JogadorImpl("Teste", saldoInicialJogador1);
		Jogador jogador2 = new JogadorImpl("Teste2", saldoInicialJogador2);
		
		Imovel imovel = new Imovel();
		imovel.setValorAluguel(valorDoAluguel);
		imovel.setValorDaPropriedade(valorDoImovel);
		
		try {
			imovel.comprarPropriedade(jogador1);
			imovel.acaoLogradouro(jogador2);
			fail();
			
		} catch (Exception e) {
			
			final String mensagemEsperada = "Jogador com saldo negativo.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}

}
