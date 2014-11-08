package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;


public class GUITelaInicial extends JFrame {
	private List<JTextField> nomesJogadores; 
	private List<JButton> tecnicos;
	private JButton bola;
	private String[] nomesTecnicos = {"Pep Guardiola", "José Mourinho", "Jürgen Klopp", "Arsene Wenger", "Diego Simeone", "Carlo Ancelotti"};
	private static final String caminhoImagens = "/br/ufc/quixada/pds/bancoimobiliario/view/img/";
	private List<JButton> tecnicosDosJogadores;
	private List<JButton> botoesAlterar;
	
	public GUITelaInicial(){
		this.tecnicos = new ArrayList<JButton>();
		this.nomesJogadores = new ArrayList<JTextField>();
		this.tecnicosDosJogadores = new ArrayList<JButton>();
		this.botoesAlterar = new ArrayList<JButton>();
	    this.setBounds(100, 0, 1150, 700);
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
	    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	    
	    for(int i=0; i<6; i++){
	    	JButton tecnico = new JButton("");
	    	tecnico.setBackground(Color.WHITE);
	    	tecnico.setBounds(64+(i*181),150,117,150);
	    	tecnico.setToolTipText(this.nomesTecnicos[i]);
	    	
	    	String nomeImagem = this.nomesTecnicos[i].replaceAll("\\s","").toLowerCase();
			nomeImagem = Normalizer.normalize(nomeImagem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			
			
			URL pathImagem = GUITelaInicial.class.getResource(caminhoImagens  + "tecnicos/" + nomeImagem  +".png");
			ImageIcon imageIcon = new ImageIcon(pathImagem);
			tecnico.setIcon(imageIcon);
			
			
			tecnico.setCursor(cursor);
			
	    	this.tecnicos.add(tecnico);
	    	background.add(tecnico);
	    	
	    	JLabel nomeTecnico = new JLabel(this.nomesTecnicos[i], SwingConstants.CENTER);
	    	nomeTecnico.setBounds(64+(i*181), 310, 117, 30);
	    	nomeTecnico.setForeground(Color.WHITE);
	    	background.add(nomeTecnico);
	    }
	    
	    JTextField nomeJogador1TxtField = new JTextField(null);
	    nomeJogador1TxtField.setBounds(40, 440, 169, 33);
	    background.add(nomeJogador1TxtField);
	    this.nomesJogadores.add(nomeJogador1TxtField);
	    nomeJogador1TxtField.setColumns(10);
	    
	    JButton jogador1Selecionado = new JButton("");
	    jogador1Selecionado.setBackground(Color.WHITE);
	    jogador1Selecionado.setBounds(40, 493, 117, 150);
	    this.tecnicosDosJogadores.add(jogador1Selecionado);
	    background.add(jogador1Selecionado);
	    
	    JLabel nomeJogador1Label = new JLabel("Nome jogador 1:");
	    nomeJogador1Label.setFont(new Font("Tahoma", Font.BOLD, 14));
	    nomeJogador1Label.setForeground(Color.WHITE);
	    nomeJogador1Label.setBounds(40, 413, 150, 20);
	    background.add(nomeJogador1Label);
	    
	    JButton jogador2Selecionado = new JButton("");
	    jogador2Selecionado.setBackground(Color.WHITE);
	    jogador2Selecionado.setBounds(993, 493, 117, 150);
	    this.tecnicosDosJogadores.add(jogador2Selecionado);
	    background.add(jogador2Selecionado);
	    
	    JTextField nomeJogador2TxtField = new JTextField(null);
	    nomeJogador2TxtField.setColumns(10);
	    nomeJogador2TxtField.setBounds(941, 440, 169, 33);
	    this.nomesJogadores.add(nomeJogador2TxtField);
	    background.add(nomeJogador2TxtField);
	    
	    JLabel nomeJogador2Label = new JLabel("Nome jogador 2:");
	    nomeJogador2Label.setFont(new Font("Tahoma", Font.BOLD, 14));
	    nomeJogador2Label.setForeground(Color.WHITE);
	    nomeJogador2Label.setBounds(978, 413, 150, 20);
	    background.add(nomeJogador2Label);
	    
	    JButton alterarJogador1 = new JButton("Alterar");
	    alterarJogador1.setBounds(40, 650, 117, 25);
	    this.botoesAlterar.add(alterarJogador1);
	    background.add(alterarJogador1);
	    
	    JButton alterarJogador2 = new JButton("Alterar");
	    alterarJogador2.setBounds(993, 650, 117, 25);
	    this.botoesAlterar.add(alterarJogador2);
	    background.add(alterarJogador2);
	    
	    JLabel iniciarOJogoLabel = new JLabel("Iniciar o Jogo");
	    iniciarOJogoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	    iniciarOJogoLabel.setBounds(530, 500, 150, 15);
	    background.add(iniciarOJogoLabel);
	    
	    bola = new JButton();
	    bola.setBackground(Color.WHITE);
	    bola.setIcon(new ImageIcon(GUITelaInicial.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/Bola.png")));
	    bola.setOpaque(false);
	    bola.setContentAreaFilled(false);
	    bola.setBorderPainted(false);
	    bola.setBorder(null);
	    bola.setBounds(543, 430, 70, 70);
	    bola.setToolTipText("Clique para iniciar");
	    bola.setCursor(cursor);
	    background.add(bola);
	}
	
	public List<JButton> getTecnicos(){
		return this.tecnicos;
	}
	
	public JButton getBotaoInicial(){
		return this.bola;
	}
	
	public String[] getNomesTecnicos(){
		return this.nomesTecnicos;
	}
	
	public List<JTextField> getTextFielNomeJogadores(){
		return this.nomesJogadores;
	}
	
	public List<JButton> getTecnicosDosJogadores(){
		return this.tecnicosDosJogadores;
	}
	
	public  List<JButton> getBotoesAlterar(){
		return this.botoesAlterar;
	}
}
