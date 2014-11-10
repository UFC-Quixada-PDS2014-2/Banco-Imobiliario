package br.ufc.quixada.pds.bancoimobiliario.guice;

import br.ufc.quixada.pds.bancoimobiliario.config.ReaderArquivo;
import br.ufc.quixada.pds.bancoimobiliario.config.ReaderArquivoImpl;

import com.google.inject.AbstractModule;

public class GuiTelaAjudaModule extends AbstractModule{
	
	@Override
	protected void configure() {
		bind(ReaderArquivo.class).to(ReaderArquivoImpl.class);
	}
	
}