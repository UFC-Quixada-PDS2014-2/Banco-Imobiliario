package br.ufc.quixada.pds.bancoimobiliario.controller.telavencedor;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ActionListenerSair implements ActionListener {
	private JFrame telaVencedor;
	
	public ActionListenerSair(JFrame telaVencedor) {
		this.telaVencedor = telaVencedor;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		telaVencedor.dispose();
	}

}
