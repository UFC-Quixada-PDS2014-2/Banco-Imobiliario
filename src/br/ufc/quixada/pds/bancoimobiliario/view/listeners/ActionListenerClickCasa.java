package br.ufc.quixada.pds.bancoimobiliario.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionListenerClickCasa implements ActionListener{

	private String mensagem;
	
	public ActionListenerClickCasa(String mensagem){
		this.mensagem = mensagem;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
}
