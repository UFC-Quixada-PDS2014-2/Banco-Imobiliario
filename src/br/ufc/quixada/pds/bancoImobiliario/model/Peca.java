package br.ufc.quixada.pds.bancoImobiliario.model;

public class Peca {

		private Logradouro localizacao;
		
		public void atualizarLocalizacao(Logradouro logradouro){
			this.localizacao = logradouro;
		}
		
		// Quebra de encapsulamento - Rever
		public Logradouro pegarLocalizacao(){
			return this.localizacao;
		}
}
