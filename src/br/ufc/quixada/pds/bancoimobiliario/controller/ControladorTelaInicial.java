package br.ufc.quixada.pds.bancoimobiliario.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaInicial;

public class ControladorTelaInicial {
	private GUITelaInicial guiTelaInicial;
	
	public ControladorTelaInicial(){
		this.guiTelaInicial = new GUITelaInicial();
		inicializar();
	}
	
	private void inicializar(){
		this.guiTelaInicial.setVisible(true);
		adicionarEventoNosTecnicos();
		adicionarEventoDeIniciarPartida();
	}
	
	private void adicionarEventoNosTecnicos(){
		List<JButton> tecnicos = this.guiTelaInicial.getTecnicos();
		for(JButton tecnico: tecnicos){
			tecnico.addActionListener(new ActionSelecionarTecnico(tecnico));
		}
	}
	
	private void adicionarEventoDeIniciarPartida(){
		JButton botaoInicial = this.guiTelaInicial.getBotaoInicial();
		botaoInicial.addActionListener(new ActionIniciarJogo(botaoInicial));
	}
	
	private class ActionSelecionarTecnico implements ActionListener{
		private JButton tecnico;
		
		public ActionSelecionarTecnico(JButton tecnico){
			this.tecnico = tecnico;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	
	
	private class ActionIniciarJogo implements ActionListener{
		private JButton botaoInicial;
		
		public ActionIniciarJogo(JButton botaoInicial){
			this.botaoInicial = botaoInicial;
			
			System.out.println("asdsad");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO:
		}
	}
}
