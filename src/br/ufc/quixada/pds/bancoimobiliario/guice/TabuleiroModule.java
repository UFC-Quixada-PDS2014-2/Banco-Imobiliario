package br.ufc.quixada.pds.bancoimobiliario.guice;

import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroBuilder;
import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroBuilderConcrete;
import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.config.ConfiguracaoCasasTabuleiroComXStream;
import br.ufc.quixada.pds.bancoimobiliario.config.LeitorLogradouros;

import com.google.inject.AbstractModule;

public class TabuleiroModule extends AbstractModule{
	
	@Override
	protected void configure() {
		bind(TabuleiroBuilder.class).to(TabuleiroBuilderConcrete.class);
		bind(LeitorLogradouros.class).to(ConfiguracaoCasasTabuleiroComXStream.class);
	}
}