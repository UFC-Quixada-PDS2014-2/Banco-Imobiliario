package br.ufc.quixada.pds.bancoimobiliario.controller.telatabuleiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.quixada.pds.bancoimobiliario.view.GUIPortfolioJogador;
import br.ufc.quixada.pds.bancoimobiliario.view.IJogador;

public class ActionListenerBotaoPortfolio implements ActionListener{

	private IJogador iJogador;
	
    public ActionListenerBotaoPortfolio(IJogador iJogador) {
    	this.iJogador = iJogador;
    }
	
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		GUIPortfolioJogador guiPortfolioJogador = new GUIPortfolioJogador(iJogador);
		guiPortfolioJogador.setVisible(true);
	}

}
