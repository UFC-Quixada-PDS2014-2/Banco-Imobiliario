package br.ufc.quixada.pds.bancoimobiliario.controller.telainicial;


import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorRestartGame;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaInicial;

public class ControladorTelaInicial {
	private GUITelaInicial guiTelaInicial;
	private ControladorRestartGame restartGame;
	
	public ControladorTelaInicial(ControladorRestartGame restartGame){
		this.guiTelaInicial = new GUITelaInicial();
		this.restartGame = restartGame;
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
			List<JButton> tecnicosJogadores = this.guiTelaInicial.getTecnicosDosJogadores();
			tecnico.addActionListener(new ActionListenerSelecionarTecnico(tecnico, tecnicosJogadores));
		}
	}
	
	private void adicionarEventoDeIniciarPartida(){
		JButton botaoInicial = this.guiTelaInicial.getBotaoInicial();
		List<JTextField> textFieldNomeJogadores = this.guiTelaInicial.getTextFielNomeJogadores();
		List<JButton> tecnicosJogadores = this.guiTelaInicial.getTecnicosDosJogadores();
		
		botaoInicial.addActionListener(new ActionListenerIniciarJogo(botaoInicial, textFieldNomeJogadores
				, this.guiTelaInicial, tecnicosJogadores, this.restartGame) );
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
