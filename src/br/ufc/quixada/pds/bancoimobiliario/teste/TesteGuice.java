package br.ufc.quixada.pds.bancoimobiliario.teste;

import br.ufc.quixada.pds.bancoimobiliario.config.guice.TabuleiroModule;
import br.ufc.quixada.pds.bancoimobiliario.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroDirector;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TesteGuice {
	
	public static void main(String[] args) throws ErroArquivoConfiguracoesException {
		
		Injector injector = Guice.createInjector(new TabuleiroModule());
		
		TabuleiroDirector tabuleiroDirector = injector.getInstance(TabuleiroDirector.class);
		
		tabuleiroDirector.construirTabuleiro();
		
		
		
		
	}

}
