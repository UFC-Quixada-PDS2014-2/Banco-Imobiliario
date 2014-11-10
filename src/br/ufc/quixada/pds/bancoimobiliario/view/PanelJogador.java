package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PanelJogador extends JPanel {

	private IJogador iJogador;
	private JLabel lblSaldo;
	private JLabel lblNomeJogador;
	private JLabel lblIconJogador;
	private JButton btnPortfolio;
	
	/**
	 * Create the panel.
	 */
	public PanelJogador(IJogador jogador, Icon pinoJogador) {
		setOpaque(false);
		this.iJogador = jogador;
		
		JLabel lblPinoJogador = new JLabel();
		lblPinoJogador.setIcon(pinoJogador);
		lblPinoJogador.setBounds(10,10,100,100);
		
		lblNomeJogador = new JLabel(jogador.getNomeJogador());
		lblNomeJogador.setBounds(12, 12, 155, 31);
		lblNomeJogador.setForeground(Color.WHITE);
		lblNomeJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeJogador.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblIconJogador = new JLabel("");
		lblIconJogador.setBounds(12, 55, 155, 150);
		lblIconJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconJogador.setIcon(iJogador.getImagemPersonagem());
		
		lblSaldo = new JLabel("Saldo : R$ " + jogador.getSaldoJogador());
		lblSaldo.setBounds(12, 211, 155, 35);
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setForeground(Color.WHITE);
		lblSaldo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		setLayout(null);
		
		btnPortfolio = new JButton("Portfólio");
		btnPortfolio.setBounds(48, 252, 95, 25);
		add(btnPortfolio);
		add(lblSaldo);
		add(lblNomeJogador);
		add(lblIconJogador);
		add(lblPinoJogador);
	}
	
	public void atualizar(){
		
		lblSaldo.setText("Saldo : R$ " + iJogador.getSaldoJogador());
		//TODO Atualizar lista de propriedades
		
	}
	
	public void atualizarBordaJogadorDaVez(IJogador iJogador){
		if(this.iJogador.equals(iJogador)){
			
			Border bordaPanel = new LineBorder(Color.RED, 8);
			this.setBorder(bordaPanel);
			
		}else{

			Border bordaPanel = new LineBorder(Color.white, 0);
			this.setBorder(bordaPanel);
		}
	}
	
	public JButton getBotaoPortfolio(){
		return this.btnPortfolio;
	}
	
	
}
