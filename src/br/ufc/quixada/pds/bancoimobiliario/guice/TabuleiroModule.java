package br.ufc.quixada.pds.bancoimobiliario.guice;

import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroBuilder;
import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroBuilderConcrete;
import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.config.ConfiguracaoCasasTabuleiroComXStream;
import br.ufc.quixada.pds.bancoimobiliario.config.ReaderLogradouros;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroImpl;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class TabuleiroModule extends AbstractModule{
	
	@Override
	protected void configure() {
		bind(TabuleiroBuilder.class).to(TabuleiroBuilderConcrete.class);
		bind(ReaderLogradouros.class).to(ConfiguracaoCasasTabuleiroComXStream.class);
	}
}