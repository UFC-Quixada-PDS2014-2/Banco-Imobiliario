package br.ufc.quixada.pds.bancoimobiliario.config;

import java.io.File;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;


public class Teste {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		//List<Object> lista = new ArrayList<Object>();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(ArrayList.class);
		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		File XMLfile = new File("src/br/ufc/quixada/pds/bancoimobiliario/config/configuracao_tabuleiro.xml");
		
		ArrayList<Logradouro> lista = (ArrayList<Logradouro>) jaxbUnmarshaller.unmarshal(XMLfile);
		
		//System.out.println(lista.get(10).getNome());
	}

}
