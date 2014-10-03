package com.ufc.quixada.pds.bancoImobiliario.entidade;

public class Peca {

		private Logradouro localizacao;
		
		public void atualizarLocalizacao(Logradouro logradouro){
			this.localizacao = logradouro;
		}
		
		// Quebra de encapsulamento - Rever
		public Logradouro buscarLocalizacao(){
			return this.localizacao;
		}
}
