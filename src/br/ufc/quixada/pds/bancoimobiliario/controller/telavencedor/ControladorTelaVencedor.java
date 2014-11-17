package br.ufc.quixada.pds.bancoimobiliario.controller.telavencedor;

import javax.swing.JButton;
import javax.swing.JFrame;

import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorRestartGame;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaVencedor;

public class ControladorTelaVencedor {
	private JButton sair;
	private JButton reiniciarJogo;
	private GUITelaVencedor telaVencedor;
	private ControladorRestartGame restartGame;
	
	public ControladorTelaVencedor(Jogador jogador, ControladorRestartGame restartGame) {
		this.restartGame = restartGame;
		this.telaVencedor = new GUITelaVencedor(jogador);
		this.reiniciarJogo = this.telaVencedor.getBotaoReiniciar();
		this.sair = this.telaVencedor.getBotaoSair();
		
	}
	
	public void inicializar(){
		this.telaVencedor.setVisible(true);
		adicionarEventoReiniciarJogo();
		adicionarEventoSair();
	}
	
	private void adicionarEventoReiniciarJogo(){
		this.reiniciarJogo.addActionListener(new ActionListenerReiniciarJogo(this.telaVencedor, this.restartGame));
	}
	
	private void adicionarEventoSair(){
		this.sair.addActionListener(new ActionListenerSair(this.telaVencedor));
	}
}
