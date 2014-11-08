package br.ufc.quixada.pds.bancoimobiliario.controller.telatabuleiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;

public class ActionListenerClickCasa implements ActionListener{

	private Logradouro logradouro;
	
	public ActionListenerClickCasa(Logradouro logradouro){
		this.logradouro = logradouro;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, logradouro);
	}
	
}
