package br.ufc.quixada.pds.bancoimobiliario.view;

import java.util.Iterator;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.Propriedade;

public class IJogador {

	private Jogador jogador;
	private String imagemPersonagem;
	
	public IJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	public String getNomeJogador(){
		return this.jogador.getNome();
	}

	public double getSaldoJogador(){
		return this.jogador.getSaldo();
	}
	
	public Iterator<Propriedade> getPropriedades(){
		return this.jogador.getPropriedadesAdquiridas();
	}
	
	public Jogador getJogador() {
		return jogador;
	}

	public String getImagemPersonagem() {
		return imagemPersonagem;
	}

	public void setImagemPersonagem(String imagemPersonagem) {
		this.imagemPersonagem = imagemPersonagem;
	}
	
	public boolean isJogador(Jogador jogador){
		boolean isJogador = this.jogador == jogador;
		
		return isJogador;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IJogador other = (IJogador) obj;
		if (jogador == null) {
			if (other.jogador != null)
				return false;
		} else if (!jogador.equals(other.jogador))
			return false;
		return true;
	}

}
