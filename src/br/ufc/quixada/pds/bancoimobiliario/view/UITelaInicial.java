package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UITelaInicial extends JFrame {
	
	public UITelaInicial(){
		
		Rectangle dimensoesTela = new Rectangle(600, 700);
	    this.setBounds(dimensoesTela);
	    this.getContentPane().setLayout(null);
	    initComponents();
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	public void initComponents(){
		
		JLabel titulo = new JLabel("BANCO IMOBILIÁRIO");
		Font fontTitulo = new Font("Stencil", Font.CENTER_BASELINE, 32);
		titulo.setBounds(100, 50, 400, 60);
		titulo.setFont(fontTitulo);
		this.add(titulo);
		
		Font fontLabelsNomes = new Font("Times New Roman", Font.CENTER_BASELINE, 15);
		
		JTextField nomeJogador1 = new JTextField();
		nomeJogador1.setBounds(50, 400, 140, 40);
		this.add(nomeJogador1);
		
		
		JLabel jogador1 = new JLabel("Jogador 1:");
		jogador1.setBounds(50, 350, 120, 40);
		jogador1.setFont(fontLabelsNomes);
		this.add(jogador1);
		
		JLabel jogador1Image = new JLabel();
		ImageIcon jogador1Icon = new ImageIcon(getClass().getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/escudo_jogador.png"));
		jogador1Image.setIcon(jogador1Icon);
		jogador1Image.setBounds(50, 200, 120, 120);
		this.add(jogador1Image);
		
		JTextField nomeJogador2 = new JTextField();
		nomeJogador2.setBounds(410, 400, 140, 40);
		this.add(nomeJogador2);
		
		JLabel jogador2 = new JLabel("Jogador 2:");
		jogador2.setBounds(410, 350, 140, 40);
		jogador2.setFont(fontLabelsNomes);
		this.add(jogador2);
		
		JLabel jogador2Image = new JLabel();
		ImageIcon jogador2Icon = new ImageIcon(getClass().getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/escudo_jogador.png"));
		jogador2Image.setIcon(jogador2Icon);
		jogador2Image.setBounds(410, 200, 120, 120);
		this.add(jogador2Image);
		
	    JButton botaoIniciar = new JButton("Jogar");
	    Font fontBotaoIniciar = new Font("Times New Roman", Font.CENTER_BASELINE, 25);
	    botaoIniciar.setFont(fontBotaoIniciar);
	    botaoIniciar.setBounds(200, 530, 200, 130);
	    this.add(botaoIniciar);
	    
	    JButton botaoRegras = new JButton("Regras");
	    botaoRegras.setBounds(480, 630, 90, 50);
	    this.add(botaoRegras);
	    
	    
	    
	    JLabel jLabel3 = new javax.swing.JLabel();
	    
	    
	    
	}
}
