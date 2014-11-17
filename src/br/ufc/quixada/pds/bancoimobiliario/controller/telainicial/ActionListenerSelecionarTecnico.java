package br.ufc.quixada.pds.bancoimobiliario.controller.telainicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;

import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaInicial;

public class ActionListenerSelecionarTecnico implements ActionListener{
	private JButton tecnico;
	private List<JButton> tecnicoDosJogadores;
	private GUITelaInicial guiTelaInicial;
	
	public ActionListenerSelecionarTecnico(JButton tecnico, List<JButton> tecnicosDosJogadores, GUITelaInicial guiTelaInicial){
		this.tecnico = tecnico;
		this.tecnicoDosJogadores = tecnicosDosJogadores;
		this.guiTelaInicial = guiTelaInicial;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(JButton tecnicoDoJogador: this.tecnicoDosJogadores){
			if(tecnicoDoJogador.getIcon() == null && this.tecnico.isEnabled()){
				tecnicoDoJogador.setIcon(this.tecnico.getIcon());
				
				String nome = guiTelaInicial.getMapTecnicos().get(tecnico);
				int indice = this.tecnicoDosJogadores.indexOf(tecnicoDoJogador);
				
				List<JLabel> nomesJogadores = this.guiTelaInicial.getJLabelNomeJogadores();
				JLabel jogador = nomesJogadores.get(indice);
				jogador.setText(nome);
				
				this.tecnico.setEnabled(false);
				break;
			}
		}
	}	
}
