package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

public class JogadorTeste {

	@Test
	public void verificaSeJogadorIniciaSemPropriedades() {
		
		Jogador jogador = new JogadorImpl("Teste", 200.00);
		assertEquals(0, jogador.getPropriedadesAdquiridas().size());
	}
	
	@Test
	public void testeIncrementarSaldo(){
		
		Jogador jogador  = new JogadorImpl("Teste", 0.00);
		try {
			jogador.acrescentarSaldo(2.51);
		} catch (ValorInvalidoException e) {
			fail();
			e.printStackTrace();
		}
		
		assertEquals(2.51, jogador.getSaldo(), 0.001);
	}
	
	@Test
	public void testeDecrementarSaldo(){
		
		Jogador jogador  = new JogadorImpl("Teste", 500.00);
		try {
			jogador.decrementarSaldo(100.00);
		} catch (JogadorComSaldoNegativoException | ValorInvalidoException e) {
			fail();
			e.printStackTrace();
		}
		
		assertEquals(400.00, jogador.getSaldo(), 0.001);
	}
	
	@Test
	public void incrementarSaldoComValorNegativo(){
		
		Jogador jogador= new JogadorImpl("Teste", 200.00);
		
		double valor = -250.00;
		
		try {
			jogador.acrescentarSaldo(valor);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
		
	}
	
	@Test
	public void decrementarSaldoComValorNegativo(){
	
		Jogador jogador= new JogadorImpl("Teste", 200.00);
		
		double valor = -550.00;
		
		try {
			jogador.decrementarSaldo(valor);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Valor deve ser maior que zero.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void verificarJogadorComSaldoNegativo(){
		
		Jogador jogador= new JogadorImpl("Teste", 200.00);
		
		double valor = 550.00;
		
		try {
			jogador.decrementarSaldo(valor);
			fail();
		} catch (Exception e) {
			
			final String mensagemEsperada = "Jogador com saldo negativo.";
			
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
	@Test
	public void verificarSaldoAposCompraDePropriedade(){
		
		Jogador jogador = new JogadorImpl("Teste", 1000.00);
		
		Propriedade imovel = new Imovel();
		imovel.setValorDaPropriedade(600.00);
		
		try {
			imovel.comprarPropriedade(jogador);
			
			assertEquals(400.00, jogador.getSaldo(), 0.001);
		} catch (SaldoJogadorInsuficienteException
				| PropriedadeJaVendidaException | JogadorInvalidoException
				| JogadorComSaldoNegativoException | ValorInvalidoException e) {
			
			fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void verificaPropriedadesDoJogadorAposComprarUmaPropriedade(){
		
			Jogador jogador = new JogadorImpl("Teste", 2000.00);
		
			Propriedade empresa = new Empresa();
			empresa.setValorDaPropriedade(500.00);
				
			try {
				empresa.comprarPropriedade(jogador);
			} catch (SaldoJogadorInsuficienteException
					| PropriedadeJaVendidaException | JogadorInvalidoException 
					| JogadorComSaldoNegativoException | ValorInvalidoException e) {
			
				fail();
				e.printStackTrace();
			}
			
			assertEquals(1, jogador.getPropriedadesAdquiridas().size());
			
			Iterator<Propriedade> it = jogador.getPropriedadesAdquiridas().iterator(); 
			
			while(it.hasNext()){
				assertEquals(empresa, it.next());
			}
	}
	
	@Test
	public void verificaPropriedadesDoJogadorAposACompraDeTresPropriedades(){
		
		Jogador jogador = new JogadorImpl("Teste", 2000.00);
		
		List<Propriedade> propriedades = new ArrayList<>();
		
		
		
		try {
			
			Propriedade imovel = new Imovel();	
			imovel.setValorDaPropriedade(200.00);	
			imovel.comprarPropriedade(jogador);
			propriedades.add(imovel);
			
			
			imovel = new Imovel();		
			imovel.setValorDaPropriedade(150.00);
			imovel.comprarPropriedade(jogador);
			propriedades.add(imovel);
			
			Propriedade empresa = new Empresa();
			empresa.setValorDaPropriedade(100.00);
			empresa.comprarPropriedade(jogador);
			propriedades.add(empresa);
			
		} catch (SaldoJogadorInsuficienteException
				| PropriedadeJaVendidaException | JogadorInvalidoException 
				| JogadorComSaldoNegativoException | ValorInvalidoException e) {
			
			fail();
		}
		
		assertEquals(propriedades.size(),jogador.getPropriedadesAdquiridas().size());
		
		Iterator<Propriedade> propriedadesEsperadas = propriedades.iterator();
		Iterator<Propriedade> propriedadesAtuais = jogador.getPropriedadesAdquiridas().iterator();
				
		while(propriedadesEsperadas.hasNext() && propriedadesAtuais.hasNext()){
			assertEquals(propriedadesEsperadas.next(), propriedadesAtuais.next());
		}
	}
}
