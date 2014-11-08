package br.ufc.quixada.pds.bancoimobiliario.controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.google.inject.Guice;
import com.google.inject.Injector;

import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.guice.TabuleiroModule;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliarioImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.MontadorTabuleiroException;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaInicial;
import br.ufc.quixada.pds.bancoimobiliario.view.IJogador;
import br.ufc.quixada.pds.bancoimobiliario.view.listeners.ActionListenerIniciarJogo;
import br.ufc.quixada.pds.bancoimobiliario.view.listeners.ActionListenerSelecionarTecnico;

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
			tecnico.addActionListener(new ActionListenerSelecionarTecnico(tecnico, this.guiTelaInicial.getTecnicosDosJogadores()));
		}
	}
	
	private void adicionarEventoDeIniciarPartida(){
		JButton botaoInicial = this.guiTelaInicial.getBotaoInicial();
		botaoInicial.addActionListener(new ActionListenerIniciarJogo(botaoInicial, this.guiTelaInicial.getTextFielNomeJogadores()
				, this.guiTelaInicial, this.guiTelaInicial.getTecnicosDosJogadores()));
	}
	
	
		
}
