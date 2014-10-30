package br.ufc.quixada.pds.bancoimobiliario.config;


import java.io.File;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.AcaoAvancaPosicao;
import br.ufc.quixada.pds.bancoimobiliario.model.AcaoDecrementaSaldo;
import br.ufc.quixada.pds.bancoimobiliario.model.AcaoIncrementaSaldo;
import br.ufc.quixada.pds.bancoimobiliario.model.AcaoVoltaPosicao;
import br.ufc.quixada.pds.bancoimobiliario.model.Empresa;
import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.LugarEspecial;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ConfiguracaoCasasTabuleiroComXStream implements ReaderLogradouros{
	private XStream stream;
	private List<Logradouro> listaDeLogradouros; 
	
	public ConfiguracaoCasasTabuleiroComXStream(){
		this.stream = new XStream(new DomDriver());
	}
	
	private void configurarClassesParaAlias(){
		stream.alias("PontoDePartida", PontoDePartida.class);
		stream.alias("Imovel", Imovel.class);
		stream.alias("Empresa", Empresa.class);
		stream.alias("LugarEspecial", LugarEspecial.class);
		stream.alias("AcaoIncrementaSaldo", AcaoIncrementaSaldo.class);
		stream.alias("AcaoDecrementaSaldo", AcaoDecrementaSaldo.class);
		stream.alias("AcaoAvancaPosicao", AcaoAvancaPosicao.class);
		stream.alias("AcaoVoltaPosicao", AcaoVoltaPosicao.class);
		stream.alias("List", List.class);
		stream.alias("Jogador", JogadorImpl.class);
	}
	
	private void carregarElementosXMLLista() throws ErroNaLeituraDoXMLException{
		File file = new File(ConfiguracaoCasasTabuleiroComXStream.class.getResource("configuracao_tabuleiro.xml").getPath());
		
		if(!file.exists()){
			throw new ErroNaLeituraDoXMLException();
		}
		
		try{
			this.listaDeLogradouros =  (ArrayList) stream.fromXML(file);
		}catch(Exception e){
			throw new ErroNaLeituraDoXMLException();
		}
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

	@Override
	public void carregarReader() throws ErroNaLeituraDoXMLException {
		configurarClassesParaAlias();
		carregarElementosXMLLista();
	}

	
}
