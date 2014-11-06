package br.ufc.quixada.pds.bancoimobiliario.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.w3c.dom.views.AbstractView;

import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.view.IJogador;
import br.ufc.quixada.pds.bancoimobiliario.view.ILogradouro;

public class ControladorTabuleiro{
	
	private GUITabuleiro guiTabuleiro;
	private BancoImobiliario bancoImobiliario;
	private IJogador iJogador1;
	private IJogador iJogador2;
	
	public ControladorTabuleiro(BancoImobiliario bancoImobiliario, IJogador iJogador1, IJogador iJogador2){
		this.bancoImobiliario = bancoImobiliario;
		this.iJogador1 = iJogador1;
		this.iJogador2 = iJogador2;
		this.guiTabuleiro = new GUITabuleiro(bancoImobiliario, iJogador1, iJogador2);
		inicializar();
	}
	
	public void inicializar(){
		this.guiTabuleiro.setVisible(true);
		this.guiTabuleiro.setJogadorDaVez(detectarJogadorDaVez());
		adicionarEventosBotoesCasas();
	}
	
	private IJogador detectarJogadorDaVez(){
		Jogador jogador = bancoImobiliario.getJogadorDaVez();
		
		if(iJogador1.isJogador(jogador)){
			return iJogador1;
		}else{
			return iJogador2;
		}
	}
	
	private void adicionarEventosBotoesCasas(){
		
		List<ILogradouro> iLogradouros = guiTabuleiro.getiLogradouros();
		
		for (ILogradouro iLogradouro : iLogradouros) {
			
			JButton casa = iLogradouro.getCasa();
			casa.setToolTipText(iLogradouro.getNome());
			casa.setText(iLogradouro.getNome());
			casa.addActionListener(new ActionListenerCasa(iLogradouro.getLogradouro().getNome()));
			
		}
		
	}
	
	private class ActionRealizarRodada implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
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
