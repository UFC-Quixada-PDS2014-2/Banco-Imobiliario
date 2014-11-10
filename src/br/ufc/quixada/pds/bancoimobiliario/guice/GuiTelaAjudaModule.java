package br.ufc.quixada.pds.bancoimobiliario.guice;

import br.ufc.quixada.pds.bancoimobiliario.config.LeitorArquivo;
import br.ufc.quixada.pds.bancoimobiliario.config.LeitorArquivoImpl;

import com.google.inject.AbstractModule;

public class GuiTelaAjudaModule extends AbstractModule{
	
	@Override
	protected void configure() {
		bind(LeitorArquivo.class).to(LeitorArquivoImpl.class);
	}
	
}