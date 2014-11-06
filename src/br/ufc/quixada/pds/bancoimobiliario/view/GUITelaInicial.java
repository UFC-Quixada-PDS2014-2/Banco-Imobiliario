package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class GUITelaInicial extends JFrame {
	private JTextField nomeJogador1TxtArea;
	private JTextField nomeJogador2TxtArea;
	
	public GUITelaInicial(){
		
		Rectangle dimensoesTela = new Rectangle(1150, 700);
	    this.setBounds(dimensoesTela);
	    initComponents();
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
	    
	    JLabel background = new JLabel();
	    background.setIcon(new ImageIcon(GUITelaInicial.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/TelaInicialBackground.png")));
	    background.setBounds(0, 0, 1150, 700);
	    getContentPane().add(background);
	    
	    JButton tecnico1 = new JButton("");
	    tecnico1.setIcon(null);
	    tecnico1.setBackground(Color.WHITE);
	    tecnico1.setBounds(64, 150, 117, 150);
	    background.add(tecnico1);
	    
	    JButton tecnico2 = new JButton("");
	    tecnico2.setBackground(Color.WHITE);
	    tecnico2.setBounds(245, 150, 117, 150);
	    background.add(tecnico2);
	    
	    JButton tecnico3 = new JButton("");
	    tecnico3.setBackground(Color.WHITE);
	    tecnico3.setBounds(426, 150, 117, 150);
	    background.add(tecnico3);
	    
	    JButton tecnico4 = new JButton("");
	    tecnico4.setBackground(Color.WHITE);
	    tecnico4.setBounds(607, 150, 117, 150);
	    background.add(tecnico4);
	    
	    JButton tecnico5 = new JButton("");
	    tecnico5.setBackground(Color.WHITE);
	    tecnico5.setBounds(788, 150, 117, 150);
	    background.add(tecnico5);
	    
	    JButton tecnico6 = new JButton("");
	    tecnico6.setBackground(Color.WHITE);
	    tecnico6.setBounds(969, 150, 117, 150);
	    background.add(tecnico6);
	    
	    nomeJogador1TxtArea = new JTextField();
	    nomeJogador1TxtArea.setBounds(40, 440, 169, 33);
	    background.add(nomeJogador1TxtArea);
	    nomeJogador1TxtArea.setColumns(10);
	    
	    JButton jogador1Selecionado = new JButton("");
	    jogador1Selecionado.setBackground(Color.WHITE);
	    jogador1Selecionado.setBounds(40, 493, 117, 150);
	    background.add(jogador1Selecionado);
	    
	    JLabel nomeJogador1Label = new JLabel("Nome jogador 1:");
	    nomeJogador1Label.setBounds(40, 413, 119, 20);
	    background.add(nomeJogador1Label);
	    
	    JButton jogador2Selecionado = new JButton("");
	    jogador2Selecionado.setBackground(Color.WHITE);
	    jogador2Selecionado.setBounds(993, 493, 117, 150);
	    background.add(jogador2Selecionado);
	    
	    nomeJogador2TxtArea = new JTextField();
	    nomeJogador2TxtArea.setColumns(10);
	    nomeJogador2TxtArea.setBounds(941, 440, 169, 33);
	    background.add(nomeJogador2TxtArea);
	    
	    JLabel nomeJogador2Label = new JLabel("Nome jogador 2:");
	    nomeJogador2Label.setBounds(991, 413, 119, 20);
	    background.add(nomeJogador2Label);
	    
	    JButton alterarJogador1 = new JButton("Alterar");
	    alterarJogador1.setBounds(40, 650, 117, 25);
	    background.add(alterarJogador1);
	    
	    JButton alterarJogador2 = new JButton("Alterar");
	    alterarJogador2.setBounds(993, 650, 117, 25);
	    background.add(alterarJogador2);
	    
	    JButton iniciarJogo = new JButton();
	    iniciarJogo.setEnabled(false);
	    iniciarJogo.setBounds(553, 450, 50, 50);
	    iniciarJogo.setBorder(null);
	    iniciarJogo.setOpaque(false);
	    background.add(iniciarJogo);
	    
	    this.setResizable(false);
	    this.setVisible(true);
	}
	
	public void initComponents(){
		
	   
	}
}
