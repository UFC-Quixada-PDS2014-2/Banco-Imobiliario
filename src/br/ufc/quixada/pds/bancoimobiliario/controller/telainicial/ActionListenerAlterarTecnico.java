package br.ufc.quixada.pds.bancoimobiliario.controller.telainicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ActionListenerAlterarTecnico implements ActionListener{
	private JButton tecnicoSelecionadoAtualmente;
	private List<JButton> tecnicos;
	private JLabel nomeAtual;
	
	public ActionListenerAlterarTecnico(List<JButton> tecnicos, JButton tecnicoAtual, JLabel nomeAtual){
		this.tecnicos = tecnicos;
		this.tecnicoSelecionadoAtualmente = tecnicoAtual;
		this.nomeAtual = nomeAtual;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(JButton tecnico: this.tecnicos){
			if(tecnicoSelecionadoAtualmente.getIcon() == null){
				break;
			}
			Icon iconeTecnicoSelecionadoAtualmente = this.tecnicoSelecionadoAtualmente.getIcon();
			Icon iconeTecnico = tecnico.getIcon();
			
			if(iconeTecnico != null && iconeTecnico.equals(iconeTecnicoSelecionadoAtualmente) && !tecnico.isEnabled()){
				tecnico.setEnabled(true);
				break;
			}
		}
		
		tecnicoSelecionadoAtualmente.setIcon(null);
		nomeAtual.setText("");
	}

}
