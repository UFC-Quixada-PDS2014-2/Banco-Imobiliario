package br.ufc.quixada.pds.bancoimobiliario.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Propriedade;

public class PropriedadeTeste {

	@Test
	public void comprarLogradouroJaAdquirida() {
		
		final double saldo = 200.00;
		final double valorDaPropriedade = 50;
		final double valorDoAluguel = 2;
		
		Jogador jogador1 = new JogadorImpl("Jogador1", saldo);
		Jogador jogador2 = new JogadorImpl("Teste", saldo);
		
		Propriedade imovel = new Imovel(valorDaPropriedade,valorDoAluguel);

		try {
			imovel.comprarLogradouro(jogador1);
			imovel.comprarLogradouro(jogador2);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Propriedade já adquirida";
			assertEquals(mensagemEsperada, e.getMessage());
		}
		
		
	}
	
	@Test
	public void verificarSeEstaVendidaEmPropriedadeNaoAdquirida(){
		
			final double valorDaPropriedade = 200;
			final double valorDoAluguel = 20;
		
			Propriedade imovel = new Imovel(valorDaPropriedade,valorDoAluguel);
			assertTrue(imovel.propriedadeEstaVendida() == false);
	}
	
	@Test
	public void verificarSeEstaVendidaEmPropriedadeJaAdquirida(){
		
			final double valorDaPropriedade = 200;
			final double valorDoAluguel = 20;
		
			Propriedade imovel = new Imovel(valorDaPropriedade,valorDoAluguel);
			
			Jogador jogador = new JogadorImpl("Teste",200.00);
			
			try {
				imovel.comprarLogradouro(jogador);
			} catch (Exception e) {
				fail();
			}
			
			assertTrue(imovel.propriedadeEstaVendida());
	}
	
	@Test
	public void comprarLogradouroSemTerSaldoSuficiente(){

		final double saldoInicial = 500;
		final double valorDaPropriedade = 600;
		final double valorDoAluguel = 50;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		Propriedade imovel = new Imovel(valorDaPropriedade,valorDoAluguel);
		
		try {
			imovel.comprarLogradouro(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "O Jogador não possui saldo suficiente para comprar essa propriedade.";
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void comprarLogradouroComSaldoSuficiente(){
		
		final double saldoInicial = 500;
		final double valorDaPropriedade = 350;
		final double valorDoAluguel = 25;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		Propriedade imovel = new Imovel(valorDaPropriedade,valorDoAluguel);
		
		try {
			imovel.comprarLogradouro(jogador);
			assertTrue(jogador.equals(imovel.getDonoDaPropriedade()));
		
		} catch (Exception e) {
			fail();
		}
	}

}
