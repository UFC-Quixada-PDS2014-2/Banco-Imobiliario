package br.ufc.quixada.pds.bancoimobiliario.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.quixada.pds.bancoimobiliario.exception.ValorDosDadosInvalidosException;
import br.ufc.quixada.pds.bancoimobiliario.model.Copo;

public class CopoTeste{

	
	@Test
	public void testeComValorDosDadosNoLimiteInferior(){
		Copo copo = new Copo();
		try{
			copo.lancarDados(2);
			assertEquals(2, copo.obterValorDosDados());
		} catch(Exception e){
			fail();
		}
	}
	
	@Test
	public void testeComValorDosDadosNoLimiteSuperior(){
		
		Copo copo = new Copo();
		try{
			copo.lancarDados(12);
			assertEquals(12, copo.obterValorDosDados());
		} catch(Exception e){
			fail();
		}
	}
	
	@Test
	public void testeComValoresDentroDoLimite() {
		Copo copo = new Copo();
		try{
			
			copo.lancarDados(4);
			assertEquals(4, copo.obterValorDosDados());
			
			copo.lancarDados(8);
			assertEquals(8, copo.obterValorDosDados());
			
			copo.lancarDados(11);
			assertEquals(11, copo.obterValorDosDados());
			
		} catch(Exception e){
			fail();
		}
	}
	
	@Test
	public void testeComValorMenorQueLimiteInferior(){
		Copo copo = new Copo();
		
		try{
			copo.lancarDados(1);
			fail();
		}catch(ValorDosDadosInvalidosException e){
			
		}
	}
	
	@Test
	public void testeComValorMaiorQueOLimiteSuperior(){
		
		Copo copo = new Copo();
		
		try{
			copo.lancarDados(13);
			fail();
		}catch(ValorDosDadosInvalidosException e){
			
		}
	}
	
	@Test
	public void testeComValorDosDadosNegativos(){
		
		Copo copo = new Copo();
		
		try{
			copo.lancarDados(-1);
			fail();
		} catch(ValorDosDadosInvalidosException e){
			
		}
	}
	
	@Test
	public void testeComValorDosDadosZero(){
		
		Copo copo = new Copo();
		
		try{
			copo.lancarDados(0);
			fail();
		}catch (ValorDosDadosInvalidosException e){
			
		}
	}

}
