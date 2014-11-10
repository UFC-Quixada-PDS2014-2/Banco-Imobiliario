package br.ufc.quixada.pds.bancoimobiliario.controller.telatabuleiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaAjuda;

public class ActionListenerBotaoAjuda implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new GUITelaAjuda();
	}

}
