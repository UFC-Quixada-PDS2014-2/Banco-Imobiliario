package br.ufc.quixada.pds.bancoimobiliario.config;

import java.io.IOException;

public interface LeitorArquivo {

	public String lerArquivo(String caminho) throws IOException;
	
}
