package br.ufc.quixada.pds.bancoimobiliario.controller.telainicial;


import java.util.List;

import javax.swing.JButton;

import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaInicial;

public class ControladorTelaInicial {
	private GUITelaInicial guiTelaInicial;
	
	public ControladorTelaInicial(){
		this.guiTelaInicial = new GUITelaInicial();
	}
	
	public void inicializar(){
		this.guiTelaInicial.setVisible(true);
		adicionarEventoNosTecnicos();
		adicionarEventoDeIniciarPartida();
		adicionarEventoAlterar();
		adicionarEventoDePararMusica();
	}
	
	private void adicionarEventoNosTecnicos(){
		List<JButton> tecnicos = this.guiTelaInicial.getTecnicos();
		for(JButton tecnico: tecnicos){
			tecnico.addActionListener(new ActionListenerSelecionarTecnico(tecnico, this.guiTelaInicial.getTecnicosDosJogadores()));
		}
	}
	
	private void adicionarEventoDeIniciarPartida(){
		JButton botaoInicial = this.guiTelaInicial.getBotaoInicial();
		botaoInicial.addActionListener(new ActionListenerIniciarJogo(botaoInicial, this.guiTelaInicial.getTextFielNomeJogadores()
				, this.guiTelaInicial, this.guiTelaInicial.getTecnicosDosJogadores()));
	}
	
	private void adicionarEventoAlterar(){
		List<JButton> botoesAlterar = this.guiTelaInicial.getBotoesAlterar();
		List<JButton> tecnicos = this.guiTelaInicial.getTecnicos();
		List<JButton> tecnicosDosJogadores = this.guiTelaInicial.getTecnicosDosJogadores();
		for(int i=0; i<2; i++){
			botoesAlterar.get(i).addActionListener(new ActionListenerAlterarTecnico(tecnicos, tecnicosDosJogadores.get(i)));
		}
	}
	
	private void adicionarEventoDePararMusica(){
		JButton pararMusica = this.guiTelaInicial.getPararMusica();
		pararMusica.addActionListener(new ActionListenerPararMusica(pararMusica, this.guiTelaInicial));
	}
	
		
}
