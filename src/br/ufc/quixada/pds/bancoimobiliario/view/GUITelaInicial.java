package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class GUITelaInicial extends JFrame {
	private JTextField nomeJogador1TxtArea;
	private JTextField nomeJogador2TxtArea;
	private List<JButton> tecnicos;
	private JButton bola;
	
	public GUITelaInicial(){
		this.tecnicos = new ArrayList<JButton>();
		Rectangle dimensoesTela = new Rectangle(1150, 700);
	    this.setBounds(dimensoesTela);
	    initComponents();
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
	    this.setResizable(false);
	}
	
	public void initComponents(){
		JLabel background = new JLabel();
	    background.setIcon(new ImageIcon(GUITelaInicial.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/TelaInicialBackground.png")));
	    background.setBounds(0, 0, 1150, 700);
	    getContentPane().add(background);
	    
	    for(int i=0; i<6; i++){
	    	JButton tecnico = new JButton("");
	    	tecnico.setBackground(Color.WHITE);
	    	tecnico.setBounds(64+(i*181),150,117,150);
	    	this.tecnicos.add(tecnico);
	    	background.add(tecnico);
	    }
	    
	    nomeJogador1TxtArea = new JTextField();
	    nomeJogador1TxtArea.setBounds(40, 440, 169, 33);
	    background.add(nomeJogador1TxtArea);
	    nomeJogador1TxtArea.setColumns(10);
	    
	    JButton jogador1Selecionado = new JButton("");
	    jogador1Selecionado.setBackground(Color.WHITE);
	    jogador1Selecionado.setBounds(40, 493, 117, 150);
	    background.add(jogador1Selecionado);
	    
	    JLabel nomeJogador1Label = new JLabel("Nome jogador 1:");
	    nomeJogador1Label.setForeground(Color.WHITE);
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
	    nomeJogador2Label.setForeground(Color.WHITE);
	    nomeJogador2Label.setBounds(991, 413, 119, 20);
	    background.add(nomeJogador2Label);
	    
	    JButton alterarJogador1 = new JButton("Alterar");
	    alterarJogador1.setBounds(40, 650, 117, 25);
	    background.add(alterarJogador1);
	    
	    JButton alterarJogador2 = new JButton("Alterar");
	    alterarJogador2.setBounds(993, 650, 117, 25);
	    background.add(alterarJogador2);
	    
	    JLabel iniciarOJogoLabel = new JLabel("Iniciar o Jogo");
	    iniciarOJogoLabel.setBounds(540, 405, 150, 15);
	    background.add(iniciarOJogoLabel);
	    
	    bola = new JButton();
	    bola.setBackground(Color.WHITE);
	    bola.setIcon(new ImageIcon(GUITelaInicial.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/Bola.png")));
	    bola.setOpaque(false);
	    bola.setContentAreaFilled(false);
	    bola.setBorderPainted(false);
	    bola.setBorder(null);
	    bola.setBounds(543, 430, 70, 70);
	    background.add(bola);
	}
	
	public List<JButton> getTecnicos(){
		return this.tecnicos;
	}
	
	public JButton getBotaoInicial(){
		return this.bola;
	}
}
