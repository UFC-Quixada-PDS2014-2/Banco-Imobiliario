package br.ufc.quixada.pds.bancoimobiliario.viewTeste;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;

public class IJogador {

	private Jogador jogador;
	private int x;
	private int y;
	
	public IJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Jogador getJogador() {
		return jogador;
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
