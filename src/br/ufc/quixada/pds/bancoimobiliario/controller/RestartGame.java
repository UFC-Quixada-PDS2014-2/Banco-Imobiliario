package br.ufc.quixada.pds.bancoimobiliario.controller;


public class RestartGame {
	
	public void reiniciarJogo(){
		
		Runtime runtime = Runtime.getRuntime();
		runtime.runFinalization();
		runtime.gc();
		
		Main jogo = new Main();
		jogo.iniciarJogo();
		
	}

}
