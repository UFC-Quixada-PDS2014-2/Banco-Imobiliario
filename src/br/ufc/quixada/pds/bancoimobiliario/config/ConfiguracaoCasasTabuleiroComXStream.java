package br.ufc.quixada.pds.bancoimobiliario.config;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.ufc.quixada.pds.bancoimobiliario.model.Empresa;
import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.LugarEspecialModificaPosicao;
import br.ufc.quixada.pds.bancoimobiliario.model.LugarEspecialModificarSaldo;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;

public class ConfiguracaoCasasTabuleiroComXStream implements ReaderLogradouros{
	private XStream stream;
	private List<Logradouro> listaDeLogradouros; 
	
	public ConfiguracaoCasasTabuleiroComXStream(){
		this.stream = new XStream(new DomDriver());
		configurarClassesParaAlias();
		carregarElementosXMLLista();
	}
	
	private void configurarClassesParaAlias(){
		stream.alias("PontoDePartida", PontoDePartida.class);
		stream.alias("Imovel", Imovel.class);
		stream.alias("Empresa", Empresa.class);
		stream.alias("LugarEspecialModificaPosicao", LugarEspecialModificaPosicao.class);
		stream.alias("LugarEspecialModificaSaldo", LugarEspecialModificarSaldo.class);
		stream.alias("List", List.class);
	}
	
	private void carregarElementosXMLLista(){
		File file = new File("src/br/ufc/quixada/pds/bancoimobiliario/config/configuracao_tabuleiro.xml");
		this.listaDeLogradouros =  (ArrayList) stream.fromXML(file);
	}
	
	@Override
	public PontoDePartida pegarPontoDePartida() {
		PontoDePartida pontoDePartida = (PontoDePartida) this.listaDeLogradouros.get(0);
		return pontoDePartida;
	}

	@Override
	public List<Logradouro> lerLogradouros() {
		int tamanhoDaLista = this.listaDeLogradouros.size();
		List<Logradouro> sublistaDeLogradouros = this.listaDeLogradouros.subList(1, tamanhoDaLista);
		return sublistaDeLogradouros;
	}

}
