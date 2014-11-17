package br.ufc.quixada.pds.bancoimobiliario.controller.telavencedor;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorRestartGame;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaVencedor;

public class ActionListenerReiniciarJogo implements ActionListener {
	private GUITelaVencedor telaVencedor;
	private ControladorRestartGame restartGame;
	
	public ActionListenerReiniciarJogo(GUITelaVencedor telaVencedor, ControladorRestartGame restartGame) {
		this.telaVencedor = telaVencedor;
		this.restartGame = restartGame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		telaVencedor.dispose();
		restartGame.reiniciarJogo();
	}

}
