package br.ufc.quixada.pds.bancoimobiliario.controller;

import java.util.Observable;

public class ControladorRestartGame extends Observable{
	
	public void reiniciarJogo(){
		
		setChanged();
		notifyObservers();
		
	}

}
