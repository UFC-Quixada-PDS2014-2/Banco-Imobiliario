package br.ufc.quixada.pds.bancoimobiliario.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeitorArquivoImpl implements LeitorArquivo{
	
	public String lerArquivo(String caminho) throws IOException{
		
		Path caminhoArquivo = Paths.get(caminho);
		
		BufferedReader reader = Files.newBufferedReader(caminhoArquivo, StandardCharsets.UTF_8);
		
		String linha;
		String texto = "";
		 
		while((linha = reader.readLine()) != null){
			texto += linha + "\n";
		}
		
		return texto;
	}

}
