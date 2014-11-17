package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.CaminhoImagensEnum;

public class GUITelaVencedor extends JFrame{
	private JButton reiniciarJogo;
	private JButton sair;
	
	public GUITelaVencedor(Jogador jogadorVencedor) {
		
		
		JLabel labelBackground = new JLabel();
		labelBackground.setIcon(new ImageIcon(GUITelaVencedor.class.getResource(CaminhoImagensEnum.PASTA_IMAGENS.getValor()+"telaVencedorBackground.png")));
		labelBackground.setBounds(0,10,1150, 780);
		add(labelBackground);
		
		JLabel nomeJogador = new JLabel(jogadorVencedor.getNome() + " foi o vencedor!!", SwingConstants.CENTER);
		nomeJogador.setBounds(325, 500, 500, 40);
		nomeJogador.setForeground(Color.WHITE);
		nomeJogador.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelBackground.add(nomeJogador);
		
		this.reiniciarJogo = new JButton("Reiniciar Jogo");
		reiniciarJogo.setBounds(825, 600, 200, 30);
		reiniciarJogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelBackground.add(reiniciarJogo);
		
		sair = new JButton("Sair");
		sair.setBounds(1050, 600, 75, 30);
		sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelBackground.add(sair);
		
		this.setSize(1150, 647);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public JButton getBotaoReiniciar(){
		return this.reiniciarJogo;
	}
	
	public JButton getBotaoSair(){
		return this.sair;
	}
	
}
