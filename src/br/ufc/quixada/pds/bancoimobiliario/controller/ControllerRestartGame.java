package br.ufc.quixada.pds.bancoimobiliario.controller;

import java.util.Observable;

public class ControllerRestartGame extends Observable{
	
	public void reiniciarJogo(){
		
		setChanged();
		notifyObservers();
		
	}

}
