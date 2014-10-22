package br.ufc.quixada.pds.bancoimobiliario.config.guice;

import br.ufc.quixada.pds.bancoimobiliario.config.ConfiguracaoCasasTabuleiroComXStream;
import br.ufc.quixada.pds.bancoimobiliario.config.ReaderLogradouros;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroBuilder;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroBuilderConcrete;

import com.google.inject.AbstractModule;

public class TabuleiroModule extends AbstractModule{
	
	@Override
	protected void configure() {
		
		bind(TabuleiroBuilder.class).to(TabuleiroBuilderConcrete.class);
		bind(ReaderLogradouros.class).to(ConfiguracaoCasasTabuleiroComXStream.class);

	}

}
