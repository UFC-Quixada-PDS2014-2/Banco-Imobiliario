package br.ufc.quixada.pds.bancoimobiliario.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.ufc.quixada.pds.bancoimobiliario.view.GUITabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.view.ILogradouro;

public class ControladorTabuleiro{
	
	private GUITabuleiro guiTabuleiro;
	
	public ControladorTabuleiro(GUITabuleiro guiTabuleiro){
		this.guiTabuleiro = guiTabuleiro;
		this.guiTabuleiro.setVisible(true);
		adicionarEventosBotoesCasas();
	}
	
	public void adicionarEventosBotoesCasas(){
		
		List<ILogradouro> iLogradouros = guiTabuleiro.getiLogradouros();
		
		for (ILogradouro iLogradouro : iLogradouros) {
			
			JButton casa = iLogradouro.getCasa();
			casa.setText(iLogradouro.getLogradouro().getNome());
			casa.addActionListener(new ActionListenerCasa(iLogradouro.getLogradouro().getNome()));
		}
		
	}
	
	private class ActionListenerCasa implements ActionListener{

		private String mensagem;
		
		public ActionListenerCasa(String mensagem){
			this.mensagem = mensagem;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(ControladorTabuleiro.this.guiTabuleiro, mensagem);
		}
		
	}
	
	
}
