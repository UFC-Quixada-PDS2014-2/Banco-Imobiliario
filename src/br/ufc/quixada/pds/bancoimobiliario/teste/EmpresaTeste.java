package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Empresa;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;

public class EmpresaTeste {

	@Test
	public void verificaEmpresaRecemCriadaSeEstaDisponivelParaCompra() {
		
		final double valorDaPropriedade = 500;
		final double valorDaTaxa = 20;
		final double saldoInicial = 1000;
		
		Empresa empresa = new Empresa(valorDaPropriedade,valorDaTaxa);
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		try {
			AcaoLogradouroEnum acaoEnum = empresa.acaoLogradouro(jogador);
			
			assertEquals(AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA, acaoEnum);
			assertEquals(saldoInicial, jogador.getSaldo(), 0.00);
			
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void verificaEmpresaComDonoSeEstaDisponivelParaVenda(){
	
		final double saldoInicial = 1000;
		final double valorPropriedade = 500;
		final double valorDaTaxa = 50;
		final int valorDosDados = 5;
		
		Empresa empresa = new Empresa(valorPropriedade, valorDaTaxa);
		
		Jogador jogador1 = new JogadorImpl("Teste", saldoInicial);
		Jogador jogador2 = new JogadorImpl("Teste2", saldoInicial);
		
		jogador2.setValorDoUltimoDeslocamento(valorDosDados);
		
		try {
			
			empresa.comprarLogradouro(jogador1);
			
			AcaoLogradouroEnum acaoEnum = empresa.acaoLogradouro(jogador2);
			
			assertNotEquals(AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA, acaoEnum);
			
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void verificaSaldoDosJogadoresAposPararEmPropriedadeComDono(){
	
		final double saldoInicial = 1000;
		final double valorDaPropriedade = 500;
		final double valorDaTaxa = 50;
		final int valorDosDados = 5;
		
		Empresa empresa = new Empresa(valorDaPropriedade,valorDaTaxa);
		
		Jogador jogador1 = new JogadorImpl("Teste", saldoInicial);
		Jogador jogador2 = new JogadorImpl("Teste2", saldoInicial);
		
		jogador2.setValorDoUltimoDeslocamento(valorDosDados);
		
		try {
			
			empresa.comprarLogradouro(jogador1);
			
			empresa.acaoLogradouro(jogador2);
			
			final double saldoFinalEsperadoJogador1 = (saldoInicial - valorDaPropriedade) + valorDaTaxa * valorDosDados;
			final double saldoFinalEsperadoJogador2 = (saldoInicial) - (valorDaTaxa * valorDosDados);
			
			
			assertEquals(saldoFinalEsperadoJogador1, jogador1.getSaldo(), 0.00);
			assertEquals(saldoFinalEsperadoJogador2, jogador2.getSaldo(), 0.00);
			
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void verificaAcaoExecutadaComDonoDaPropriedade(){
	
		final double saldoInicial = 1000;
		final double valorDaPropriedade = 500;
		final double valorDaTaxa = 20;
		
		Empresa empresa = new Empresa(valorDaPropriedade, valorDaTaxa);
		
		Jogador jogador1 = new JogadorImpl("Teste", saldoInicial);
		
		try {
			
			empresa.comprarLogradouro(jogador1);
			
			AcaoLogradouroEnum acaoEnum = empresa.acaoLogradouro(jogador1);
			
			assertEquals(AcaoLogradouroEnum.PERTENCE_AO_JOGADOR, acaoEnum);
			
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void jogadorAcabaOSaldoAposPararEmPropriedadeDeOutro(){
	
		final double saldoInicialJogador1 = 1000;
		final double saldoInicialJogador2 = 200;
		final double valorPropriedade = 500;
		final double valorDaTaxa = 50;
		final int valorDosDados = 5;
		
		Empresa empresa = new Empresa(valorPropriedade,valorDaTaxa);
		
		Jogador jogador1 = new JogadorImpl("Teste", saldoInicialJogador1);
		Jogador jogador2 = new JogadorImpl("Teste2", saldoInicialJogador2);
		
		jogador2.setValorDoUltimoDeslocamento(valorDosDados);
		
		try {
			
			empresa.comprarLogradouro(jogador1);
			empresa.acaoLogradouro(jogador2);
			fail();
			
		} catch (Exception e) {
			
			final String mensagemEsperada = "Jogador com saldo negativo.";
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void jogadorTentacomprarLogradouroSemTerSaldoSuficiente(){
	
		final double saldoInicialJogador1 = 500;
		final double valorDaPropriedade = 1000;
		final double valorDaTaxa = 20;
		Empresa empresa = new Empresa(valorDaPropriedade,valorDaTaxa);
		
		Jogador jogador1 = new JogadorImpl("Teste", saldoInicialJogador1);
		
		try {
			empresa.comprarLogradouro(jogador1);
			fail();
			
		} catch (Exception e) {
			
			final String mensagemEsperada = "O Jogador não possui saldo suficiente para comprar essa propriedade.";
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
}
