package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.model.Empresa;
import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Propriedade;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.PropriedadeJaVendidaException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class JogadorTeste {

	@Test
	public void verificaSeJogadorIniciaSemPropriedades() {
		
		Jogador jogador = new JogadorImpl("Teste", 200.00);
		assertEquals(0, jogador.getPropriedadesAdquiridas().size());
	}
	
	@Test
	public void testeIncrementarSaldo(){
		
		final double saldoInisical = 0.00;
		final double incremento = 2.51;
		
		Jogador jogador  = new JogadorImpl("Teste", saldoInisical);
		
		try {
			jogador.acrescentarSaldo(incremento);
			
		} catch (ValorInvalidoException e) {
			fail(e.getMessage());
		}
		
		assertEquals(saldoInisical + incremento, jogador.getSaldo(), 0.00);
	}
	
	@Test
	public void testeDecrementarSaldo(){
		
		final double saldoInicial = 500;
		final double decremento = 100;
		
		Jogador jogador  = new JogadorImpl("Teste", saldoInicial);
		
		try {
			jogador.decrementarSaldo(decremento);
		} catch (Exception  e) {
			fail(e.getMessage());
		}
		
		assertEquals(saldoInicial - decremento, jogador.getSaldo(), 0.00);
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
		
		final double valorDaPropriedade = 600;
		final double valorDoAluguel = 60;
		final double saldoInicial = 1000;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		Propriedade imovel = new Imovel(valorDaPropriedade,valorDoAluguel);
		
		try {
			imovel.comprarPropriedade(jogador);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(saldoInicial - valorDaPropriedade, jogador.getSaldo(), 0.00);
	}
	
	@Test
	public void verificaPropriedadesDoJogadorAposComprarUmaPropriedade(){

			final double saldoInicial = 2000;
			final double valorDaPropriedade = 200;
			final double valorDaTaxa = 60;
			
			Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
			Propriedade empresa = new Empresa(valorDaPropriedade,valorDaTaxa);
				
			try {
				empresa.comprarPropriedade(jogador);
			} catch (Exception e) {
			
				fail(e.getMessage());
			}
			assertEquals(1, jogador.getPropriedadesAdquiridas().size());
			
			Iterator<Propriedade> it = jogador.getPropriedadesAdquiridas().iterator(); 
			
			while(it.hasNext()){
				assertEquals(empresa, it.next());
			}
	}
	
	@Test
	public void verificaPropriedadesDoJogadorAposACompraDeTresPropriedades(){

		final double saldoInicial = 2000;
		final double valorDaPropriedade = 100;
		final double valorDaTaxa = 20;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		List<Propriedade> propriedades = new ArrayList<>();
		
		try {
			
			Propriedade imovel = new Imovel(valorDaPropriedade,valorDaTaxa);	
			imovel.comprarPropriedade(jogador);
			propriedades.add(imovel);
			
			imovel = new Imovel(valorDaPropriedade,valorDaTaxa);		
			imovel.comprarPropriedade(jogador);
			propriedades.add(imovel);
			
			Propriedade empresa = new Empresa(valorDaPropriedade,valorDaTaxa);
			empresa.comprarPropriedade(jogador);
			propriedades.add(empresa);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(propriedades.size(),jogador.getPropriedadesAdquiridas().size());
		
		Iterator<Propriedade> propriedadesEsperadas = propriedades.iterator();
		Iterator<Propriedade> propriedadesAtuais = jogador.getPropriedadesAdquiridas().iterator();
				
		while(propriedadesEsperadas.hasNext() && propriedadesAtuais.hasNext()){
			assertEquals(propriedadesEsperadas.next(), propriedadesAtuais.next());
		}
	}
	
	@Test
	public void testaSeJogadorEhDonoDaPropriedadeComprada(){
		
		final double saldoInicial = 10000;
		final double valorDaPropriedade = 200;
		final double valorDaTaxa = 20;
		
		Jogador jogador = new JogadorImpl("Teste", saldoInicial);
		
		Propriedade imovel = new Imovel(valorDaPropriedade,valorDaTaxa);
		Propriedade empresa  = new Empresa(valorDaPropriedade,valorDaTaxa);
		
		try {
			empresa.comprarPropriedade(jogador);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertFalse(jogador.equals(imovel.getDonoDaPropriedade()));
		assertTrue(jogador.equals(empresa.getDonoDaPropriedade()));	
	}
}
