package br.ufc.quixada.pds.bancoimobiliario.controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		botaoInicial.addMouseListener(new ActionIniciarJogo(botaoInicial));
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
	
	
	
	private class ActionIniciarJogo implements MouseListener{
		private JButton botaoInicial;
		
		public ActionIniciarJogo(JButton botaoInicial){
			this.botaoInicial = botaoInicial;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
			botaoInicial.setCursor(cursor);
			botaoInicial.setToolTipText("Clique para iniciar");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
