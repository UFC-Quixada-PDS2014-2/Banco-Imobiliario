package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUITelaIntroducao extends JFrame{
	
	public GUITelaIntroducao(){
		this.setBounds(100, 10, 1150, 700);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setResizable(false);
	}
	
	public void initComponents(){
		JLabel skipMensagem = new JLabel("Aperte ESC para pular");
		skipMensagem.setForeground(Color.WHITE);
		skipMensagem.setBounds(900, 650, 200, 30);
		getContentPane().add(skipMensagem);
	}
}
