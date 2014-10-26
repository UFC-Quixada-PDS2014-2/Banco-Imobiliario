package br.ufc.quixada.pds.bancoimobiliario.model;

public class JogadorInvalidoException extends Exception {

		public JogadorInvalidoException() {
			super("Jogador usando é inválido ou não existe.");
		}
}
