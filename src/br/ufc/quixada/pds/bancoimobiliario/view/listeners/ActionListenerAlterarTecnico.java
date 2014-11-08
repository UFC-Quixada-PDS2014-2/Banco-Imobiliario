package br.ufc.quixada.pds.bancoimobiliario.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class ActionListenerAlterarTecnico implements ActionListener{
	private JButton tecnicoAtual;
	private List<JButton> tecnicos;
	
	public ActionListenerAlterarTecnico(List<JButton> tecnicos, JButton tecnicoAtual){
		this.tecnicos = tecnicos;
		this.tecnicoAtual = tecnicoAtual;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(JButton tecnico: this.tecnicos){
			if(tecnicoAtual.getIcon() == null){
				break;
			}
			if(tecnico.getIcon() != null && tecnico.getIcon().equals(this.tecnicoAtual.getIcon()) && !tecnico.isEnabled()){
				tecnico.setEnabled(true);
				break;
			}
		}
		
		tecnicoAtual.setIcon(null);
	}

}
