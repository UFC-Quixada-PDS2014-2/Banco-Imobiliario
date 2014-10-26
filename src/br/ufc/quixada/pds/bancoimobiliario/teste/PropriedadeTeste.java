package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Empresa;
import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.Propriedade;
import br.ufc.quixada.pds.bancoimobiliario.model.PropriedadeJaVendidaException;
import br.ufc.quixada.pds.bancoimobiliario.model.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.ValorInvalidoException;

public class PropriedadeTeste {

	@Test
	public void testeComprarPropiedadePassandoJogadorNull(){
		
		Propriedade imovel = new Imovel();
		
		Jogador jogador = null;
		 
		try {
			imovel.comprarPropriedade(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Jogador usando é inválido ou não existe.";
			assertEquals(mensagemEsperada,e.getMessage());
		}
	}
	
	@Test
	public void comprarPropriedadeJaAdquirida() {
		
		double saldo = 200.00;
		
		Jogador jogador1 = new JogadorImpl("Jogador1", saldo);
		Jogador jogador2 = new JogadorImpl("Teste", saldo);
		
		Propriedade imovel = new Imovel();
		imovel.setValorDaPropriedade(2.00);
		
		try {
			imovel.comprarPropriedade(jogador1);
			imovel.comprarPropriedade(jogador2);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Propriedade já adquirida";
			assertEquals(mensagemEsperada, e.getMessage());
		}
		
		
	}
	
	@Test
	public void verificarSeEstaVendidaEmPropriedadeNaoAdquirida(){
		
			Propriedade imovel = new Imovel();
			assertTrue(imovel.propriedadeEstaVendida() == false);
	}
	
	@Test
	public void verificarSeEstaVendidaEmPropriedadeJaAdquirida(){
		
			Propriedade imovel = new Imovel();
			imovel.setValorDaPropriedade(2.00);
			Jogador jogador = new JogadorImpl("Teste",200.00);
			
			try {
				imovel.comprarPropriedade(jogador);
			} catch (Exception e) {
				fail();
			}
			
			assertTrue(imovel.propriedadeEstaVendida());
	}
	
	@Test
	public void comprarPropriedadeSemTerSaldoSuficiente(){
	
		Jogador jogador = new JogadorImpl("Teste", 500.00);
		
		Propriedade imovel = new Imovel();
		imovel.setValorDaPropriedade(500.01);
		
		try {
			imovel.comprarPropriedade(jogador);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "O Jogador não possui saldo suficiente para comprar essa propriedade.";
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void comprarPropriedadeComSaldoSuficiente(){
		
		Jogador jogador = new JogadorImpl("Teste", 500.00);
		
		Propriedade imovel = new Imovel();
		imovel.setValorDaPropriedade(350.00);
		
		try {
			imovel.comprarPropriedade(jogador);
		} catch (Exception e) {
			fail();
		}
	}

}
