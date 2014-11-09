package br.ufc.quixada.pds.bancoimobiliario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.Empresa;
import br.ufc.quixada.pds.bancoimobiliario.model.GerenciadorDeCompra;
import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.Propriedade;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.LogradouroIndisponivelCompraException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class GerenciadorDeCompraImpl implements GerenciadorDeCompra{

	@Override
	public void comprarPropriedade(Jogador compradorDaPropriedade, Logradouro logradouro) throws LogradouroIndisponivelCompraException, SaldoJogadorInsuficienteException, JogadorInvalidoException, JogadorComSaldoNegativoException, ValorInvalidoException {
			
		try{
			
			Propriedade propriedade = (Propriedade) logradouro;
			propriedade.comprarPropriedade(compradorDaPropriedade);
	
		} catch(ClassCastException e){
			throw new LogradouroIndisponivelCompraException();
		}
	}

	@Override
	public Iterator<Imovel> getImoveisDoJogador(Jogador jogador) {
		Iterator<Propriedade> propriedadesDoJogador = jogador.getPropriedadesAdquiridas();
		List<Imovel> imoveisDoJogador = new ArrayList<>();
		
		while(propriedadesDoJogador.hasNext()){
			Propriedade propriedade = propriedadesDoJogador.next();
			
			if(propriedade instanceof Imovel){
				imoveisDoJogador.add((Imovel)propriedade);
			}
		}
		return imoveisDoJogador.iterator();
	}

	@Override
	public Iterator<Empresa> getEmpresasDoJogador(Jogador jogador) {

		Iterator<Propriedade> propriedadesDoJogador = jogador.getPropriedadesAdquiridas();
		List<Empresa> empresasDoJogador = new ArrayList<Empresa>();
		
		while(propriedadesDoJogador.hasNext()){
			Propriedade propriedade = propriedadesDoJogador.next();
			
			if(propriedade instanceof Empresa){
				empresasDoJogador.add((Empresa) propriedade);
			}
		}
		return empresasDoJogador.iterator();
	}

}
