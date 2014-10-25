package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Empresa;
import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Propriedade;
import br.ufc.quixada.pds.bancoimobiliario.model.PropriedadeJaVendidaException;
import br.ufc.quixada.pds.bancoimobiliario.model.SaldoJogadorInsuficienteException;

public class PropriedadeTeste {

	@Test
	public void testeComprarPropiedadePassandoJogadorNull(){
		
		Propriedade imovel = new Imovel();
		
		Jogador jogador = null;
		 //TODO : Implementar validaçao para q nao ocorra nullponiterexception
		/*try {
			imovel.comprarPropriedade(jogador);
		} catch (SaldoJogadorInsuficienteException
				| PropriedadeJaVendidaException e) {
			
		}*/
	}
	
	@Test
	public void comprarPropriedadeJaAdquirida() {
		
		double saldo = 200.00;
		
		Jogador jogador1 = new JogadorImpl("Jogador1", saldo);
		Jogador jogador2 = new JogadorImpl("Cayk", saldo);
		
		Propriedade imovel = new Imovel();
		
		try {
			imovel.comprarPropriedade(jogador1);
			imovel.comprarPropriedade(jogador2);
			fail();
		} catch (SaldoJogadorInsuficienteException
				| PropriedadeJaVendidaException e) {
			
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
			Jogador jogador = new JogadorImpl("Teste",200.00);
			
			try {
				imovel.comprarPropriedade(jogador);
			} catch (SaldoJogadorInsuficienteException
					| PropriedadeJaVendidaException e) {
				fail();
			}
			
			assertTrue(imovel.propriedadeEstaVendida());
	}
	
	@Test
	public void comprarPropriedadeSemTerSaldoSuficiente(){
		//TODO: 
	}

}
