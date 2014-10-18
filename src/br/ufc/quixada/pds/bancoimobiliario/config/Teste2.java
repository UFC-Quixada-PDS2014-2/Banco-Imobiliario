package br.ufc.quixada.pds.bancoimobiliario.config;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.ufc.quixada.pds.bancoimobiliario.model.Imovel;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;

public class Teste2 {
	
	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		//List<Object> lista = new ArrayList<Object>();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Imovel.class);
		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		File XMLfile = new File("src/br/ufc/quixada/pds/bancoimobiliario/config/teste.xml");
		
		Imovel lista = (Imovel) jaxbUnmarshaller.unmarshal(XMLfile);
		
		//System.out.println(lista.get(10).getNome());
	}
}
