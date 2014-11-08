package br.ufc.quixada.pds.bancoimobiliario.controller.telainicial;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class ActionListenerSelecionarTecnico implements ActionListener{
	private JButton tecnico;
	private List<JButton> tecnicoDosJogadores;
	
	public ActionListenerSelecionarTecnico(JButton tecnico, List<JButton> tecnicosDosJogadores){
		this.tecnico = tecnico;
		this.tecnicoDosJogadores = tecnicosDosJogadores;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(JButton tecnicoDoJogador: this.tecnicoDosJogadores){
			if(tecnicoDoJogador.getIcon() == null && this.tecnico.isEnabled()){
				tecnicoDoJogador.setIcon(this.tecnico.getIcon());
				this.tecnico.setEnabled(false);
				break;
			}
		}
	}	
}
