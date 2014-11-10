package br.ufc.quixada.pds.bancoimobiliario.config;

import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;

public interface ReaderLogradouros {
	public PontoDePartida getPontoDePartida();
	public List<Logradouro> lerLogradouros();
	public void carregarReader() throws ErroNaLeituraDoXMLException ;
}
